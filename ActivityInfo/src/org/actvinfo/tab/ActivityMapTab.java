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

// ����̳�MapActivity
public class ActivityMapTab extends MapActivity
{
	// ��������ϵĵĿ��ӻ��ؼ�
	RadioGroup mapType;	
	MapView mv;
	// ����MapController����
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
		someActi.setTitle("��ʾ������"+String.valueOf(activities.size())+"����");
		someActi.show();
		
		locMap = new HashMap<String, GeoPoint>();
		setLocMap(locMap);
		
		posBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pos);
		// ��ý�����MapView����
		mv = (MapView) findViewById(R.id.mv);
		// ������ʾ�Ŵ���С�Ŀ��ư�ť
		mv.setBuiltInZoomControls(true);		
		// ����MapController����
		controller = mv.getController();
		controller.setZoom(17);
		
		// ���÷�������MapView
		updateMapView(); 
		// ���RadioGroup����
		mapType = (RadioGroup) findViewById(R.id.rg); 
		// ΪRadioGroup��ѡ��״̬�ı���Ӽ�����
		mapType.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{				
				switch(checkedId)
				{
					// �����ѡ����"������ͼ"�ĵ�ѡ��
					case R.id.normal:
						mv.setSatellite(false);
						break;
					// �����ѡ����"������ͼ"�ĵ�ѡ��
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
	
	

	// ���ݾ��ȡ�γ�Ƚ�MapView��λ��ָ���ص�ķ���
	private void updateMapView()
	{
		// ������ʾ�Ŵ���С��ť
		mv.displayZoomControls(true);
		// ���MapView��ԭ�е�Overlay����
		List<Overlay> ol = mv.getOverlays();
		// ���ԭ�е�Overlay����
		ol.clear();
		// ���һ���µ�OverLay����
		Drawable drawable = this.getResources().getDrawable(R.drawable.pos);
		PosOverLay newOverLay = new PosOverLay(drawable, this);
		
		Iterator<ActivityInfo> it = activities.iterator();
		ActivityInfo lastActivity = null;
		String actiInfoInSamePlace = new String();
		GeoPoint initgp = locMap.get("current");
		
		OverlayItem overlayit = new OverlayItem(initgp, "��ǰ", "current");
		newOverLay.addOverlay(overlayit);
		//GeoPoint initgp = locMap.get(BuildingToString(activities.get(0).getLocBuilding()));
		//GeoPoint initgp = new GeoPoint(116326321, 40003834);
		
		while(it.hasNext())
		{
			ActivityInfo curActivity = it.next();
			if(lastActivity != null && !lastActivity.getLocBuilding().equals(curActivity.getLocBuilding()))
			{
				GeoPoint gp = locMap.get(BuildingToString(lastActivity.getLocBuilding()));
				OverlayItem overlayitem = new OverlayItem(gp, "�", actiInfoInSamePlace);
				newOverLay.addOverlay(overlayitem);
				
				actiInfoInSamePlace = new String();
			}
			actiInfoInSamePlace += activityToString(curActivity);
			lastActivity = curActivity;
		}
		if(lastActivity != null)
		{
			GeoPoint gp = locMap.get(BuildingToString(lastActivity.getLocBuilding()));
			OverlayItem overlayitem = new OverlayItem(gp, "�", actiInfoInSamePlace);
			newOverLay.addOverlay(overlayitem);
		}
		ol.add(newOverLay);
		
		// ����ͼ�ƶ���ָ���ĵ���λ�� 
		controller.animateTo(initgp);
	}
	
	private String BuildingToString(Building bd)
	{
		String Building = "";
		switch(bd)
		{
		case YIJIAO:
			Building = "һ��";
			break;
		case ERJIAO:
			Building = "����";
			break;
		case SANJIAO:
			Building = "����";
			break;
		case SIJIAO:
			Building = "�Ľ�";
			break;
		case WUJIAO:
			Building = "���";
			break;
		case LIUJIAO:
			Building = "����";
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
		
		actiInfoInSamePlace += "���⣺"+curActivity.getSubject()+"endofitem";
		
		actiInfoInSamePlace += "ʱ�䣺"+ GeneralUtil.getDisplay(GeneralUtil.Style.ALL2LINE,
				curActivity.getDisplayDate(actSet.currentTime), curActivity.getDisplayClock())
				+"endofitem";
		
		String Building = BuildingToString(curActivity.getLocBuilding());
		actiInfoInSamePlace += "�ص㣺"+Building+curActivity.getLocRoom()+"endofitem";
		
		actiInfoInSamePlace += "���Ϣ��"+curActivity.getDescription()+"endofitem";
		actiInfoInSamePlace += "������"+curActivity.getSpeakerName()+"endofitem";
		actiInfoInSamePlace += "�������ܣ�"+curActivity.getSpeakerDscp()+"endofitem";
		
		actiInfoInSamePlace += "endofactivity";
		
		return actiInfoInSamePlace;
	}
	
	private void setLocMap(Map<String, GeoPoint> locMap)
	{
		double dLong = 40.003834;
		double dLat = 116.326321;
		
		GeoPoint gp = new GeoPoint(40001686, 116324068);
		locMap.put("һ��", gp);
		
		gp = new GeoPoint(40002323, 116323999);
		locMap.put("����", gp);
		
		gp = new GeoPoint(40002643, 116328464);
		locMap.put("����", gp);
		
		gp = new GeoPoint(40002524, 116327287);
		locMap.put("�Ľ�", gp);
		
		gp = new GeoPoint(40002719, 116326665);
		locMap.put("���", gp);
		
		gp = new GeoPoint(40002869, 116329985);
		locMap.put("����", gp);
		
		gp = new GeoPoint(39996923, 116332201);
		locMap.put("FIT", gp);
		
		locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Location location = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		gp = new GeoPoint((int)Math.floor(location.getLatitude()*1000000)+1100, (int)Math.floor(location.getLongitude()*1000000)+6000);
		locMap.put("current", gp);
	}
}