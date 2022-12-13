package com.example.a5725finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int i = 0;
    private String ipAdress = "null";
    private String port = "null";
    private EditText et1;
    private EditText et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tv1;
        Button btn1;
        Button btn2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Activity2.class);
                startActivity(startIntent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ipAdress = ()
                et1 = (EditText) findViewById(R.id.Et1);
                et2 = (EditText) findViewById(R.id.Et2);
                ipAdress = et1.getText().toString();
                port = et2.getText().toString();
                Intent startIntent = new Intent(getApplicationContext(), Activity2.class);
                startIntent.putExtra("com.example.a5725finalproject", ipAdress);
                startIntent.putExtra("com.example.a5725finalproject", port);
            }
        });
    }
}