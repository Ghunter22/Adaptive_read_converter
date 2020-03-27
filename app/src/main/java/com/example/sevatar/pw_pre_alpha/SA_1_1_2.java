package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.net.URL;

public class SA_1_1_2 extends AppCompatActivity { ////////воспроизведение изображения
    String Ws, Com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_1_1_2);
        String pathurl;
        Intent intent112 = getIntent();

        Ws  = intent112.getStringExtra("Ws");
        Com = intent112.getStringExtra("Com");

        pathurl = Ws;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this)
                .load(pathurl)
                .placeholder(R.drawable.ic_load)  // добавить предупреждение о загрузке
                .error(R.drawable.ic_onerr) //добавить предупреждение об ошибки загрзки на картинку
                .into(imageView);
                        Toast.makeText(
                        SA_1_1_2.this , Com,
                        Toast.LENGTH_LONG)
                        .show();







    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
    }

    }


