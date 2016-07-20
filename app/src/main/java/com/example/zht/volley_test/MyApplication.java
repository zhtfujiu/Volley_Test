package com.example.zht.volley_test;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by zht on 16/7/20.
 *
 * 建立全局的请求队列!!!!
 */
public class MyApplication extends Application {
    private static RequestQueue queues;

    @Override
    public void onCreate() {
        super.onCreate();
        queues= Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getHttpRequest(){
        return queues;
    }
}
