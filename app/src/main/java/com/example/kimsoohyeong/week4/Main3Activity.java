package com.example.kimsoohyeong.week4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;

public class Main3Activity extends AppCompatActivity implements TabHost.OnTabChangeListener{
    TabHost tabhost;
    FrameLayout fl1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("각종 계산기");

        init();
    }

    void init() {
        tabhost = (TabHost)findViewById(R.id.th1);
        fl1 = (FrameLayout)findViewById(android.R.id.tabcontent);
        tabInit();
    }

    void tabInit() {
        tabhost.setup();
        TabHost.TabSpec tab1 = tabhost.newTabSpec("A").setContent(
                new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        fl1.setBackgroundColor(Color.YELLOW);
                        View view = View.inflate(Main3Activity.this,
                                R.layout.bmi, null);

                        return view;
                    }
                }
        ).setIndicator("BMI 계산기");
        tabhost.addTab(tab1);
        TabHost.TabSpec tab2 = tabhost.newTabSpec("B").setContent(
                new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        fl1.setBackgroundColor(Color.BLUE);
                        View view = View.inflate(Main3Activity.this,
                                R.layout.apt, null);
                        return view;
                    }
                }
        ).setIndicator("각종 계산기");
        tabhost.addTab(tab2);
    }

    @Override
    public void onTabChanged(String tabId) {
        
    }
}
