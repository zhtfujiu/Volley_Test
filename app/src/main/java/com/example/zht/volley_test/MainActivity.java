package com.example.zht.volley_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        volley_Get_StringRequest();
        volley_Get_JsonObjectRequest();
    }

    private void volley_Get_StringRequest() {
        String url = "http://www.aoyiyun.com/datastatisticpage";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.i("MainActivity",s);
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.i("MainAcitvity",volleyError.toString());
                    }
                }
        );
        //设置一个有意义的Tag
        request.setTag("abcGet");
        //添加到全局队列
        MyApplication.getHttpRequest().add(request);
    }
    private void volley_Get_JsonObjectRequest(){
        String url = "http://www.aoyiyun.com/datastatisticpage";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener() {

                    @Override
                    public void onResponse(Object o) {
                        Log.i("MainActivity",o.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.i("MainActivity",volleyError.toString());
                    }
                });
        request.setTag("JsonGet");
        MyApplication.getHttpRequest().add(request);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Volley与Activity的联动   注意对应好Tag
        MyApplication.getHttpRequest().cancelAll("JsonGet");
    }
}
