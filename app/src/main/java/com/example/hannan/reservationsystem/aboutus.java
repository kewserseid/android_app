package com.example.hannan.reservationsystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;


public class aboutus extends AppCompatActivity {
    ImageView call, call2,map;
    Intent intent=null;
    Intent chooser=null;
    private WebView wv;
    Button we;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        wv = (WebView)findViewById(R.id.web);

        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://www.skylight.com");
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        
        call=(ImageView)findViewById(R.id.call1);
        call2=(ImageView)findViewById(R.id.call1);
        we=(Button)findViewById(R.id.we);
        map=(ImageView)findViewById(R.id.map);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1();
            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2();
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map();
            }
        });

        we.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group();
            }
        });
    }

    public void btn1(){
        String number= "0923456787";
        Intent i2 = new Intent(Intent.ACTION_CALL);
        i2.setData(Uri.parse("tel:" + number));
        startActivity(i2);
    }

    public void btn2(){
        String number= "0918898091";
        Intent i2 = new Intent(Intent.ACTION_CALL);
        i2.setData(Uri.parse("tel:"+number));
        startActivity(i2);
    }

    public void map(){
        intent = new Intent(intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:9.0011,38.8078"));
        Intent chooser=Intent.createChooser(intent,"launch.map");
        startActivity(chooser);
    }

    public void group(){
        Intent i=new Intent(aboutus.this, group.class);
        startActivity(i);
    }
}