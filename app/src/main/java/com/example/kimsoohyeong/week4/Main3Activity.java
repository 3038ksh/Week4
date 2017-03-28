package com.example.kimsoohyeong.week4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import static com.example.kimsoohyeong.week4.R.layout.bmi;

public class Main3Activity extends AppCompatActivity implements TabHost.OnTabChangeListener, View.OnClickListener {
    public TabHost tabhost;
    public FrameLayout fl1;
    public TextView t1;
    public EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("각종 계산기");

        init();
    }

    private void init() {
        tabhost = (TabHost)findViewById(R.id.th1);
        fl1 = (FrameLayout)findViewById(android.R.id.tabcontent);
        tabInit();
        tabhost.setOnTabChangedListener(this);
    }

    private void tabInit() {
        tabhost.setup();
        TabHost.TabSpec tab1 = tabhost.newTabSpec("A").setContent(
                new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        View view = View.inflate(Main3Activity.this,
                                bmi, null);
                        return view;
                    }
                }
        ).setIndicator("BMI 계산기");
        tabhost.addTab(tab1);
        TabHost.TabSpec tab2 = tabhost.newTabSpec("B").setContent(
                new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        View view = View.inflate(Main3Activity.this,
                                R.layout.apt, null);
                        return view;
                    }
                }
        ).setIndicator("각종 계산기");
        tabhost.addTab(tab2);
        t1 = (TextView)findViewById(R.id.t1);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
    }

    private void clear() {
        t1.setText("결과가 없습니다.");
        t1.setTextColor(Color.GRAY);
        e1.setText("");
        e2.setText("");
    }

    @Override
    public void onTabChanged(String tabId) {
        clear();

        switch (tabId) {
            case "A":
                Log.d("asdf", "노랑으로 탭 바뀜");
                fl1.setBackgroundColor(Color.YELLOW);
                break;
            case "B":
                Log.d("asdf", "파랑으로 탭 바뀜");
                fl1.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                Log.d("asdf", "버튼 눌림");

                String str1 = e1.getText().toString();

                Log.d("asdf", "텍스트 가져옴");
                String str2 = e2.getText().toString();

                Log.d("asdf", "텍스트 가져옴");

                double height = str1.equals("") ? 155.0 : Double.parseDouble(str1);
                double weight = str2.equals("") ? 49.0 : Double.parseDouble(str2);
                double bmi = weight / (height * height) * 10000;

                Log.d("asdf", "파싱해버리기");

                t1.setTextColor(Color.RED);
                if (bmi < 18.5) {
                    t1.setText("체중부족입니다 !!!");
                } else if (bmi < 23.0) {
                    t1.setText("정상입니다 !!!");
                } else if (bmi < 25.0) {
                    t1. setText("과체중입니다 !!!");
                } else {
                    t1.setText("비만입니다 !!!");
                }
                break;
        }
    }
}
