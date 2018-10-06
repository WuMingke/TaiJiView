package com.erkuai.taijiview;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static TaiJiView tai_ji_view;
    private static float degrees = 0;
    private static Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            tai_ji_view.startAnim(degrees +=5);
            this.sendEmptyMessageDelayed(1,20);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tai_ji_view = (TaiJiView)findViewById(R.id.tai_ji_view);
       // tai_ji_view.startAnim(5);
        handler.sendEmptyMessage(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
    }
}
