package org.actvinfo.tab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.actvinfo.R;
import org.actvinfo.base.ActivityInfo;
import org.actvinfo.base.ActivityInfo.Building;
import org.actvinfo.base.ActivityInfoSet;
import org.actvinfo.util.GeneralUtil;
import org.actvinfo.util.PosOverLay;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

// 必须继承MapActivity
public class ActivityMapTab extends MapActivity
{
	// 定义界面上的的可视化控件
	RadioGroup mapType;	
	MapView mv;
	// 定义MapController对象
	MapController controller;
	Bitmap posBitmap;
	
	ActivityInfoSet actSet;//~~~~~~~~~~~~~~~~~~~~~~~~~~
	ArrayList<ActivityInfo> activities;
	Map<String, GeoPoint> locMap;
	LocationManager locManager;
	
	@Override
	protected void onCreate(Bundle status)
	{
		super.onCreate(status);
		setContentView(R.layout.tab_activitymap);
		
		actSet = new ActivityInfoSet();
		activities = actSet.getActivities();
		
		AlertDialog.Builder someActi = new AlertDialog.Builder(this);
		someActi.setTitle("提示：共有"+String.valueOf(activities.size())+"项活动。");
		someActi.show();
		
		locMap = new HashMap<String, GeoPoint>();
		setLocMap(locMap);
		
		posBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pos);
		// 获得界面上MapView对象
		mv = (MapView) findViewById(R.id.mv);
		// 设置显示放大、缩小的控制按钮
		mv.setBuiltInZoomControls(true);		
		// 创建MapController对象
		controller = mv.getController();
		controller.setZoom(17);
		
		// 调用方法更新MapView
		updateMapView(); 
		// 获得RadioGroup对象
		mapType = (RadioGroup) findViewById(R.id.rg); 
		// 为RadioGroup的选中状态改变添加监听器
		mapType.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{				
				switch(checkedId)
				{
					// 如果勾选的是"正常视图"的单选框
					case R.id.normal:
						mv.setSatellite(false);
						break;
					// 如果勾选的是"卫星视图"的单选框
					case R.id.satellite:
						mv.setSatellite(true);
						break;
				}
			}
		});
	}

	@Override
	protected boolean isRouteDisplayed()
	{
		return true;
	}
	
	

	// 根据经度、纬度将MapView定位到指定地点的方法
	private void updateMapView()
	{
		// 设置显示放大缩小按钮
		mv.displayZoomControls(true);
		// 获得MapView上原有的Overlay对象
		List<Overlay> ol = mv.getOverlays();
		// 清除原有的Overlay对象
		ol.clear();
		// 添加一个新的OverLay对象
		Drawable drawable = this.getResources().getDrawable(R.drawable.pos);
		PosOverLay newOverLay = new PosOverLay(drawable, this);
		
		Iterator<ActivityInfo> it = activities.iterator();
		ActivityInfo lastActivity = null;
		String actiInfoInSamePlace = new String();
		GeoPoint initgp = locMap.get("current");
		
		OverlayItem overlayit = new OverlayItem(initgp, "当前", "current");
		newOverLay.addOverlay(overlayit);
		//GeoPoint initgp = locMap.get(BuildingToString(activities.get(0).getLocBuilding()));
		//GeoPoint initgp = new GeoPoint(116326321, 40003834);
		
		while(it.hasNext())
		{
			ActivityInfo curActivity = it.next();
			if(lastActivity != null && !lastActivity.getLocBuilding().equals(curActivity.getLocBuilding()))
			{
				GeoPoint gp = locMap.get(BuildingToString(lastActivity.getLocBuilding()));
				OverlayItem overlayitem = new OverlayItem(gp, "活动", actiInfoInSamePlace);
				newOverLay.addOverlay(overlayitem);
				
				actiInfoInSamePlace = new String();
			}
			actiInfoInSamePlace += activityToString(curActivity);
			lastActivity = curActivity;
		}
		if(lastActivity != null)
		{
			GeoPoint gp = locMap.get(BuildingToString(lastActivity.getLocBuilding()));
			OverlayItem overlayitem = new OverlayItem(gp, "活动", actiInfoInSamePlace);
			newOverLay.addOverlay(overlayitem);
		}
		ol.add(newOverLay);
		
		// 将地图移动到指定的地理位置 
		controller.animateTo(initgp);
	}
	
	private String BuildingToString(Building bd)
	{
		String Building = "";
		switch(bd)
		{
		case YIJIAO:
			Building = "一教";
			break;
		case ERJIAO:
			Building = "二教";
			break;
		case SANJIAO:
			Building = "三教";
			break;
		case SIJIAO:
			Building = "四教";
			break;
		case WUJIAO:
			Building = "五教";
			break;
		case LIUJIAO:
			Building = "六教";
			break;
		case FIT:
			Building = "FIT";
			break;
		}
		return Building;
	}
	private String activityToString(ActivityInfo curActivity)
	{
		String actiInfoInSamePlace = "";
		
		actiInfoInSamePlace += "主题："+curActivity.getSubject()+"endofitem";
		
		actiInfoInSamePlace += "时间："+ GeneralUtil.getDisplay(GeneralUtil.Style.ALL2LINE,
				curActivity.getDisplayDate(actSet.currentTime), curActivity.getDisplayClock())
				+"endofitem";
		
		String Building = BuildingToString(curActivity.getLocBuilding());
		actiInfoInSamePlace += "地点："+Building+curActivity.getLocRoom()+"endofitem";
		
		actiInfoInSamePlace += "活动信息："+curActivity.getDescription()+"endofitem";
		actiInfoInSamePlace += "主讲："+curActivity.getSpeakerName()+"endofitem";
		actiInfoInSamePlace += "主讲介绍："+curActivity.getSpeakerDscp()+"endofitem";
		
		actiInfoInSamePlace += "endofactivity";
		
		return actiInfoInSamePlace;
	}
	
	private void setLocMap(Map<String, GeoPoint> locMap)
	{
		double dLong = 40.003834;
		double dLat = 116.326321;
		
		GeoPoint gp = new GeoPoint(40001686, 116324068);
		locMap.put("一教", gp);
		
		gp = new GeoPoint(40002323, 116323999);
		locMap.put("二教", gp);
		
		gp = new GeoPoint(40002643, 116328464);
		locMap.put("三教", gp);
		
		gp = new GeoPoint(40002524, 116327287);
		locMap.put("四教", gp);
		
		gp = new GeoPoint(40002719, 116326665);
		locMap.put("五教", gp);
		
		gp = new GeoPoint(40002869, 116329985);
		locMap.put("六教", gp);
		
		gp = new GeoPoint(39996923, 116332201);
		locMap.put("FIT", gp);
		
		locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Location location = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		gp = new GeoPoint((int)Math.floor(location.getLatitude()*1000000)+1100, (int)Math.floor(location.getLongitude()*1000000)+6000);
		locMap.put("current", gp);
	}
}