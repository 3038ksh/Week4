package com.example.kimsoohyeong.week4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    LinearLayout ll1;
    TextView t1;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("메뉴를 둘러보세요");

        init();
    }

    void init() {
        ll1 = (LinearLayout) findViewById(R.id.activity_main2);
        t1 = (TextView) findViewById(R.id.t1);
        iv1 = (ImageView) findViewById(R.id.iv1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chicken_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuRed:
                ll1.setBackgroundColor(Color.RED);
                break;
            case R.id.mnuBlue:
                ll1.setBackgroundColor(Color.BLUE);
                break;
            case R.id.mnuYellow:
                ll1.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.mnuVisible:
                item.setChecked(item.isChecked() ? false : true);
                t1.setVisibility(item.isChecked() ? View.VISIBLE : View.INVISIBLE);
                break;
            case R.id.mnuSizeDouble:
                item.setChecked(item.isChecked() ? false : true);
                if (item.isChecked()) {
                    iv1.setScaleX((float) 1.414);
                    iv1.setScaleY((float) 1.414);
                } else {
                    iv1.setScaleX(1);
                    iv1.setScaleY(1);
                }
                break;
            case R.id.mnuSpin:
                iv1.setRotation(iv1.getRotation() + 30);
                break;
            case R.id.mnuChoice1:
                t1.setText("겁나 맛있는 치킨");
                iv1.setImageResource(R.drawable.chi);
                item.setChecked(true);
                break;
            case R.id.mnuChoice2:
                t1.setText("새콤한 스파게티");
                iv1.setImageResource(R.drawable.spa);
                item.setChecked(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
