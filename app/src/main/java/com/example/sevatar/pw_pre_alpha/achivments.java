package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class achivments extends AppCompatActivity {

  String record1, record2;
  TextView ach1,ach2,ach3,ach4,ach5;
  ProgressBar a1,a2,a3,a4,a5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achivments);

        ach1 = (TextView) findViewById(R.id.ach1);
        ach2 = (TextView) findViewById(R.id.ach2);
        ach3 = (TextView) findViewById(R.id.ach3);
        ach4 = (TextView) findViewById(R.id.ach4);
        ach5 = (TextView) findViewById(R.id.ach5);
        a1 = (ProgressBar) findViewById(R.id.a1);
        a2 = (ProgressBar) findViewById(R.id.a2);
        a3 = (ProgressBar) findViewById(R.id.a3);
        a4 = (ProgressBar) findViewById(R.id.a4);
        a5 = (ProgressBar) findViewById(R.id.a5);

        Intent intent116 = getIntent();

        record1 = intent116.getStringExtra("record1");
        record2 = intent116.getStringExtra("record4");

        a1.setMax(60);
        a2.setMax(120);
        a3.setMax(180);
        a4.setMax(300);
        a5.setMax(5000);



        if (Integer.valueOf(record1) >= 60) {
            a1.setProgress(60);
            ach1.setText("60/60");
        }
             else {
                 a1.setProgress(Integer.valueOf(record1));
                 ach1.setText(record1+"/60");
        }





        if (Integer.valueOf(record2) >= 120) {
            a2.setProgress(120);
            ach2.setText("120/120");
        }
        else {
            a2.setProgress(Integer.valueOf(record1));
            ach2.setText(record1+"/120");
        }



        if (Integer.valueOf(record1) >= 180) {
            a3.setProgress(180);
            ach3.setText("180/180");
        }
        else {
            a3.setProgress(Integer.valueOf(record1));
            ach3.setText(record1+"/180");
        }


        if (Integer.valueOf(record1) >= 300) {
            a4.setProgress(300);
            ach4.setText("300/300");
        }
        else {
            a4.setProgress(Integer.valueOf(record1));
            ach4.setText(record1+"/300");
        }

        if (Integer.valueOf(record2) >= 5000) {
            a5.setProgress(5000);
            ach5.setText("5000/5000");
        }
        else {
            a5.setProgress(Integer.valueOf(record2));
            ach5.setText(record2+"/5000");
        }

        }




    @Override
    public void onBackPressed () {
        super.onBackPressed();

        Intent intent116 = new Intent(achivments.this, game_menu.class);
        startActivity(intent116);
        // intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
        overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
        finish();
    }


}


