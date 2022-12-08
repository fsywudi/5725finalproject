package com.example.a5725finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
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

public class Activity2 extends AppCompatActivity {
    private Button right;
    private Button left;
    private Button forward;
    private Button backward;

    PrintWriter pw;


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

        forward = (Button) findViewById(R.id.button1);
        left = (Button) findViewById(R.id.button2);
        backward = (Button) findViewById(R.id.button4);
        right = (Button) findViewById(R.id.button3);

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg;
                try {
                    Socket s = new Socket("10.49.10.99", 5000);
                    pw = new PrintWriter(s.getOutputStream());
                    pw.println("123");
                    System.out.println("123");
                    pw.flush();
                    InputStreamReader ir = new InputStreamReader(s.getInputStream());
                    BufferedReader br = new BufferedReader(ir);
                    msg = br.readLine();
                    System.out.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });



    }
}