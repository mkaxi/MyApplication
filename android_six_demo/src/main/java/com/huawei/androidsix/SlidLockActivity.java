package com.huawei.androidsix;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlidLockActivity extends Activity {

    private static String TAG = "QINZDLOCK";
    private SliderRelativeLayout sliderLayout = null;
    public static int MSG_LOCK_SUCESS = 1;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lock_layout);
        initViews();
        sliderLayout.setMainHandler(mHandler);
    }


    private void initViews() {
        sliderLayout = (SliderRelativeLayout) findViewById(R.id.slider_layout);
    }

    private Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {

            Log.i(TAG, "handleMessage :  #### ");

            if (MSG_LOCK_SUCESS == msg.what)
                finish();
        }
    };






}