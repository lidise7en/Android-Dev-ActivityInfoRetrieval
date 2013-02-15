package org.actvinfo.util;

import java.util.Calendar;

import org.actvinfo.base.ActivityInfo;
import org.actvinfo.base.ActivityInfoSet;
import org.actvinfo.*;

import android.R;

import com.google.android.maps.GeoPoint;

public class GeneralUtil {
	public enum Style {MMDD, HHMM, ALL2LINE};
	public enum LocMethod {LOCAL, AP};
	/*
	public static GeoPoint getGeoPointLocal() {
		
	}
	*/
	public static GeoPoint getGeoPointServer() {
		return (new GeoPoint(0,0));
	}
	
	/*
	public static GeoPoint getGeoPoint(LocMethod locMethod) {
		
	}
	*/

	public static String getDisplay(Style style, String dateStr, String timeStr) {
		switch (style) {
		case MMDD:		return dateStr;
		case ALL2LINE:	return dateStr+"\n"+timeStr;
		case HHMM:		return timeStr;
		default:		return "Other Style";
		}
	}
}
