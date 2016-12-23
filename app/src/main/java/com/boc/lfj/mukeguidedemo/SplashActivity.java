package com.boc.lfj.mukeguidedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext,GuideActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();

//                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(mContext,R.anim.slide_in_right,R.anim.slide_out_left);
//                ActivityCompat.startActivity(SplashActivity.this,intent,optionsCompat.toBundle());
//                startActivity(new Intent(mContext,GuideActivity.class));
//                finish();
            }
        },500);
    }
}
