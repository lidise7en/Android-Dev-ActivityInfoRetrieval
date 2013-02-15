package org.actvinfo.util;					//声明包语句

import java.util.ArrayList;

import org.actvinfo.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class PosOverLay extends ItemizedOverlay<OverlayItem>
{
	// 定义该PosOverLay绘制位图的位置
	
	private ArrayList<OverlayItem> mapOverlays = new ArrayList<OverlayItem>();
	private Context context;
	
	public PosOverLay(Drawable defaultMarker, Context context)
	{
		super(boundCenterBottom(defaultMarker));
		this.context = context;
	}
	
	@Override
	protected OverlayItem createItem(int i) 
	{
	    return mapOverlays.get(i);
	}
	
	@Override
	public int size()
	{
	    return mapOverlays.size();
	}
	
	@Override
	protected boolean onTap(int index) {
	   OverlayItem item = mapOverlays.get(index);
	   AlertDialog.Builder dialog = new AlertDialog.Builder(context);
	   dialog.setTitle(item.getTitle());
	   
	   final String[] actiInfo = item.getSnippet().split("endofactivity");
	   final String[] actiTitle = new String[actiInfo.length];
	   for(int i = 0;i < actiInfo.length;++i)
	   {
		   String titletmp = actiInfo[i].split("endofitem")[0];
		   int start = titletmp.indexOf("：");
		   actiTitle[i] = titletmp.substring(start+1);
	   }
	   
	   dialog.setItems(actiTitle
				//为按钮设置监听器
				, new OnClickListener() 
				{
					//该方法的which参数代表用户单击了那个列表项
					@Override
					public void onClick(DialogInterface dialog
						, int which) 
					{
						AlertDialog.Builder someActi = new AlertDialog.Builder(context);
						//TextView show = (TextView)findViewById(R.id.show);		
						LayoutInflater inflater = LayoutInflater.from(context);
						final View textView = inflater.inflate(R.layout.row, null);
						someActi = new AlertDialog.Builder(context);
						someActi.setView(textView);
						
						someActi.setTitle(actiTitle[which]);
						someActi.setIcon(R.drawable.pos);
						
						String []curItems = actiInfo[which].split("endofitem");
						final String []curContent = new String[curItems.length - 1];
						for(int i = 1;i < curItems.length;++i)
							curContent[i - 1] = curItems[i];
						
						someActi.setItems(curContent, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								AlertDialog.Builder detail = new AlertDialog.Builder(context);
								detail.setMessage(curContent[which]);
								detail.show();
							}
						});
						
						
						someActi.create().show();
						}
		});
			//创建、并显示对话框
			dialog.create().show();	
	   return true;
	}
	
	public void addOverlay(OverlayItem overlay)
	{
		mapOverlays.add(overlay);
		this.populate();
	}
}