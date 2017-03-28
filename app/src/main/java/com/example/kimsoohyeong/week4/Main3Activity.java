package com.example.kimsoohyeong.week4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TextView;

import static com.example.kimsoohyeong.week4.R.layout.apt;
import static com.example.kimsoohyeong.week4.R.layout.bmi;

public class Main3Activity extends AppCompatActivity implements TabHost.OnTabChangeListener, View.OnClickListener {
    public TabHost tabhost;
    public FrameLayout fl1;
    public TextView t2, t3;
    public EditText e1, e2, e3;

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
                        View view = View.inflate(Main3Activity.this, bmi, null);
                        e1 = (EditText) view.findViewById(R.id.e1);
                        e2 = (EditText) view.findViewById(R.id.e2);
                        t2 = (TextView) view.findViewById(R.id.t2);
                        return view;
                    }
                }
        ).setIndicator("BMI 계산기");
        tabhost.addTab(tab1);

        TabHost.TabSpec tab2 = tabhost.newTabSpec("B").setContent(
                new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        View view = View.inflate(Main3Activity.this, apt, null);
                        e3 = (EditText) view.findViewById(R.id.e3);
                        t3 = (TextView) view.findViewById(R.id.t3);
                        return view;
                    }
                }
        ).setIndicator("각종 계산기");
        tabhost.addTab(tab2);
    }

    private void clear() {
        t2.setText("결과가 없습니다.");
        t2.setTextColor(Color.GRAY);
        t3.setText("계산결과가 없습니다.");
        e1.setText("");
        e2.setText("");
        e3.setText("");
    }

    @Override
    public void onTabChanged(String tabId) {
        clear();

        switch (tabId) {
            case "A":
                fl1.setBackgroundColor(Color.YELLOW);
                break;
            case "B":
                fl1.setBackgroundColor(Color.rgb(81, 177, 209));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                double height = str1.equals("") ? 155.0 : Double.parseDouble(str1);
                double weight = str2.equals("") ? 49.0 : Double.parseDouble(str2);
                double bmi = weight / (height * height) * 10000;

                t2.setTextColor(Color.RED);
                if (bmi < 18.5) {
                    t2.setText("체중부족입니다 !!!");
                } else if (bmi < 23.0) {
                    t2.setText("정상입니다 !!!");
                } else if (bmi < 25.0) {
                    t2. setText("과체중입니다 !!!");
                } else {
                    t2.setText("비만입니다 !!!");
                }
                break;
            case R.id.b2:
                String str3 = e3.getText().toString();

                double num3 = (str3.equals("") ? 10.0 : Double.parseDouble(str3)) * 3.305785;

                t3.setText(num3 + " 제곱미터");
                break;
            case R.id.b3:
                String str4 = e3.getText().toString();

                double num4 = (str4.equals("") ? 10.0 : Double.parseDouble(str4)) * 0.3025;

                t3.setText(num4 + " 평");
                break;
        }
    }
}
