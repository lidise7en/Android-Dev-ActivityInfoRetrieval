package org.actvinfo.tab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.actvinfo.R;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.actvinfo.util.*;
import org.actvinfo.base.*;

public class ActivityListTab extends ListActivity {
	@Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        ListView listView = this.getListView();
        listView.setCacheColorHint(Color.TRANSPARENT);
        
        SimpleAdapter adapter = new SimpleAdapter(this, new ActivityInfoSet().getActvList(),
        		R.layout.activity_list_item, new String[]{"time","subject","speaker","dscp","img","location"}, 
                new int[]{R.id.time,R.id.subject,R.id.speaker,R.id.dscp,R.id.img,R.id.location}); 
        setListAdapter(adapter); 
    } 
}
