package com.example.a5725finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //String vPath = "android.resource://" + getPackageName() + "/raw/boids";
//        String vPath = "https://www.google.com";
        String vPath = "http://10.49.10.99:8000";


        WebView webView = findViewById(R.id.wv);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(vPath);


    }
}