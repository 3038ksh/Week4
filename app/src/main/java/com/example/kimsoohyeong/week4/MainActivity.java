package com.example.kimsoohyeong.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_choose, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.mnu1:
                intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.mnu2:
                intent = new Intent(this, Main3Activity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
