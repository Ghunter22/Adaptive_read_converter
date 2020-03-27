package com.example.sevatar.pw_pre_alpha;

import  android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SA_1_1_3 extends AppCompatActivity {
    private WebView web;
    String Ws, Com;
    @Override
    protected void onCreate(Bundle savedInstanceState) {     //вызов сайта
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_1_1_3);

        Intent intent113 = getIntent();

        Ws  = intent113.getStringExtra("Ws");
        Com = intent113.getStringExtra("Com");
        web = (WebView) findViewById(R.id.webView3);
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.loadUrl(Ws);
        web.setWebViewClient(new WebViewClient());
        Toast.makeText(
                SA_1_1_3.this , Com,
                Toast.LENGTH_LONG)
                .show();


    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack())
            web.goBack();
        else
            super.onBackPressed();
            finish();
            overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
        }

    }


