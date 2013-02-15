package org.actvinfo.base;

import java.util.Calendar;

import org.actvinfo.*;

public class ActivityInfo {
	public enum Building {
		YIJIAO(0), ERJIAO(1), SANJIAO(2), SIJIAO(3), WUJIAO(4), 
		LIUJIAO(5), FIT(6), DALITANG(7);
		private int value;
		Building(int n) {
			this.value = n;
		}
	};
	
	public enum Category {
		COMPSCIENG, MATH, CHEMISTRY, CULTLECTURE, DEFAULT
	};
	String subject;
	String speakerName;
	String speakerDscp;
	Calendar startTime;
	Building locBuilding;
	String locRoom;
	String organiser;
	String description;
	Category type;
	
	public ActivityInfo(String subject, String speakerName, Calendar startTime, 
			Building locBuilding, String locRoom) {
		this.subject = subject;
		this.speakerName = speakerName;
		this.speakerDscp = "";
		this.startTime = startTime;
		this.locBuilding = locBuilding;
		this.locRoom = locRoom;
		this.organiser  = "";
		this.description = "";
		this.type = Category.DEFAULT;
	}
	
	public ActivityInfo(String subject, String speakerName, String speakerDscp,
			Calendar startTime, Building locBuilding, String locRoom,
			String organiser, String description) {
		this.subject = subject;
		this.speakerName = speakerName;
		this.speakerDscp = speakerDscp;
		this.startTime = startTime;
		this.locBuilding = locBuilding;
		this.locRoom = locRoom;
		this.organiser  = organiser;
		this.description = description;
		this.type = Category.DEFAULT;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getSpeakerName() {
		return speakerName;
	}
	
	public String getSpeakerDscp() {
		return speakerDscp;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public Building getLocBuilding() {
		return locBuilding;
	}
	
	public String getLocRoom() {
		return locRoom;
	}
	
	public String getOrganiser() {
		return organiser;
	}

	public String getDescription() {
		return description;
	}

	public Category getType() {
		return type;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	
	public void setspeakerDiscription(String speakerDscp) {
		this.speakerDscp = speakerDscp;
	}
	
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	
	public void setlocation(Building locBuilding, String locRoom) {
		this.locBuilding = locBuilding;
		this.locRoom = locRoom;
	}
	
	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setType(Category type) {
		this.type = type;
	}
	
	public int compareToTime(ActivityInfo ai) {
		return startTime.compareTo(ai.getStartTime());
	}
	
	public int compareToBuilding(ActivityInfo ai) {
		return locBuilding.compareTo(ai.locBuilding);
	}
	
	public int compareTo(ActivityInfo ai) {
		int r = compareToTime(ai);
		if (r != 0)
			return r;
		else
			return compareToBuilding(ai);
	}
	
	public int getDaysOfYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return 366;
		else
			return 365;
	}
	
	public String getDisplayDate(Calendar currentTime) {
		switch (startTime.get(Calendar.DAY_OF_YEAR)
				+ getDaysOfYear(currentTime.get(Calendar.YEAR)) * 
				(startTime.get(Calendar.YEAR) - currentTime.get(Calendar.YEAR))
				- currentTime.get(Calendar.DAY_OF_YEAR)) {
		case -2: return "前天";
		case -1: return "昨天";
		case 0:  return "今天";
		case 1:  return "明天";
		case 2:  return "后天";
		default: return ""+(startTime.get(Calendar.MONTH)+1)+"月"
							+startTime.get(Calendar.DAY_OF_MONTH)+"日";
		}
	}
	
	public String getDisplayClock() {
		String str = "";
		int h = startTime.get(Calendar.AM_PM)*12+startTime.get(Calendar.HOUR);
		int m = startTime.get(Calendar.MINUTE);
		if (h < 10)
			str += ("0"+h);
		else
			str += h;
		str += ":";
		if (m < 10)
			str += ("0"+m);
		else
			str += m;
		return str;
	}
	
	public String building2String() {
		switch (locBuilding) {
		case YIJIAO:	return "一教";
		case ERJIAO:	return "二教";
		case SANJIAO:	return "三教";
		case SIJIAO:	return "四教";
		case WUJIAO:	return "五教";
		case LIUJIAO:	return "六教";
		case FIT:		return "FIT";
		case DALITANG:	return "大礼堂";
		default:		return "默认";
		}
	}
	
	public String getDisplayLocation() {
		return building2String()+" "+locRoom;
	}
	
	public int getTypeDrawable() {
		switch (type) {
		case COMPSCIENG:	return R.drawable.actv_ico;
		case MATH:			return R.drawable.actv_ico;
		case CHEMISTRY:		return R.drawable.actv_ico;
		case CULTLECTURE:	return R.drawable.actv_ico;
		case DEFAULT: 		return R.drawable.actv_ico;
		default:			return R.drawable.actv_ico;
		}
	}
}
