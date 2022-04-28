package com.example.broadcastactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyBRReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //核心部分代码：
        myReceiver = new MyBRReceiver();
        IntentFilter itFilter = new IntentFilter();
        itFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        itFilter.addAction("Context.CONNECTIVITY_SERVICE");
        itFilter.addAction("ConnectivityManager.TYPE_MOBILE");
        itFilter.addAction("ConnectivityManager.TYPE_WIFI");
        registerReceiver(myReceiver, itFilter);
    }

    //将广播挂起哦~
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}