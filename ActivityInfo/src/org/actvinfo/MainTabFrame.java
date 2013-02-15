package org.actvinfo;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.actvinfo.tab.*;

public class MainTabFrame extends ActivityGroup {
    
    //Tab Activity Layout
    private LocalActivityManager localActivityManager = null;
    private LinearLayout mainTabContainer = null;
    private Intent mainTabIntent = null;

    //Tab banner title
    private TextView mainTabTitleTextView = null; 
    //Tab ImageView
    private ImageView actvMapImageView = null;
    private ImageView actvListImageView = null;
    private ImageView actvIssueImageView = null;
    private ImageView calendarImageView = null;
    private ImageView settingImageView = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_frame);
        
        mainTabContainer = (LinearLayout)findViewById(R.id.main_tab_container);
        localActivityManager = getLocalActivityManager();
        setContainerView("activitymap", ActivityMapTab.class);
        
        initTab();
        
    }

    
    /**
     * ��ʼ��Tab��
     */
    private void initTab() {
        mainTabTitleTextView = (TextView)findViewById(R.id.main_tab_banner_title);
        actvMapImageView = (ImageView)findViewById(R.id.activitymap_tab_btn);
        actvListImageView = (ImageView)findViewById(R.id.activitylist_tab_btn);
        calendarImageView = (ImageView)findViewById(R.id.calendar_tab_btn);
        actvIssueImageView = (ImageView)findViewById(R.id.activityissue_tab_btn);
        settingImageView = (ImageView)findViewById(R.id.setting_tab_btn);
        
        //���ͼ
        actvMapImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("���ͼ");
                setContainerView("activitymap", ActivityMapTab.class);
                actvMapImageView.setImageResource(R.drawable.actvmap_pr);
                actvListImageView.setImageResource(R.drawable.actvlist_nm);
                calendarImageView.setImageResource(R.drawable.calendar_nm);
                actvIssueImageView.setImageResource(R.drawable.actvissue_nm);
                settingImageView.setImageResource(R.drawable.setting_nm);
            }
        });
        
        //��б�
        actvListImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("��б�");
                setContainerView("activitylist", ActivityListTab.class);
                actvMapImageView.setImageResource(R.drawable.actvmap_nm);
                actvListImageView.setImageResource(R.drawable.actvlist_pr);
                calendarImageView.setImageResource(R.drawable.calendar_nm);
                actvIssueImageView.setImageResource(R.drawable.actvissue_nm);
                settingImageView.setImageResource(R.drawable.setting_nm);
            }
        });
        
        //�����
        calendarImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("�����");
                setContainerView("calendar", CalendarTab.class);
                actvMapImageView.setImageResource(R.drawable.actvmap_nm);
                actvListImageView.setImageResource(R.drawable.actvlist_nm);
                calendarImageView.setImageResource(R.drawable.calendar_pr);
                actvIssueImageView.setImageResource(R.drawable.actvissue_nm);
                settingImageView.setImageResource(R.drawable.setting_nm);
            }
        });
        
        //�����
        actvIssueImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("�����");
                setContainerView("activityissue", ActivityIssueTab.class);
                actvMapImageView.setImageResource(R.drawable.actvmap_nm);
                actvListImageView.setImageResource(R.drawable.actvlist_nm);
                calendarImageView.setImageResource(R.drawable.calendar_nm);
                actvIssueImageView.setImageResource(R.drawable.actvissue_pr);
                settingImageView.setImageResource(R.drawable.setting_nm);
            }
        });
        
        //����
        settingImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("����");
                setContainerView("setting", SettingTab.class);
                actvMapImageView.setImageResource(R.drawable.actvmap_nm);
                actvListImageView.setImageResource(R.drawable.actvlist_nm);
                actvIssueImageView.setImageResource(R.drawable.actvissue_nm);
                calendarImageView.setImageResource(R.drawable.calendar_nm);
                settingImageView.setImageResource(R.drawable.setting_pr);
            }
        });
    }
    
    public void setContainerView(String id, Class<?> activity){
        mainTabContainer.removeAllViews();
        mainTabIntent = new Intent(this,activity);
        Window subActivity = localActivityManager.startActivity(id, mainTabIntent);
        mainTabContainer.addView(subActivity.getDecorView());
    }
}