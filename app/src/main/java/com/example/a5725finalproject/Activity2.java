package com.example.a5725finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ScheduledExecutorService;

public class Activity2 extends AppCompatActivity {
    private Button rightBtn;
    private Button leftBtn;
    private Button forwardBtn;
    private Button backwardBtn;

    PrintWriter pw;
    MessageSender messageSender = MessageSender.getinstance();
    private final ScheduledExecutorService[] scheduledExecutorService = new ScheduledExecutorService[4];
    ScheduledExecutorService scheduledExecutorService1;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //String vPath = "android.resource://" + getPackageName() + "/raw/boids";
        //String vPath = "https://www.google.com";

        String vPath = "http://10.49.10.99:8000";

        WebView webView = findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(vPath);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient());

        String ipAddress = "10.48.103.25";
        String port = "5000";

        MessageSender messageSender = new MessageSender(ipAddress, port);

        forwardBtn = (Button) findViewById(R.id.button1);
        leftBtn = (Button) findViewById(R.id.button2);
        backwardBtn = (Button) findViewById(R.id.button4);
        rightBtn = (Button) findViewById(R.id.button3);

        forwardBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    messageSender.sendWithNoReply(1);
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP)
                    messageSender.sendWithNoReply(0);
                return false;
            }
        });

        leftBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    messageSender.sendWithNoReply(2);
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP)
                    messageSender.sendWithNoReply(0);
                return false;
            }
        });
        rightBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    messageSender.sendWithNoReply(3);
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP)
                    messageSender.sendWithNoReply(0);
                return false;
            }
        });
        backwardBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    messageSender.sendWithNoReply(4);
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP)
                    messageSender.sendWithNoReply(0);
                return false;
            }
        });
    }

}