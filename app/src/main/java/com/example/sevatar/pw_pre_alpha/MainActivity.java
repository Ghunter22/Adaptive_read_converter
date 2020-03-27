package com.example.sevatar.pw_pre_alpha;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btn, btn1, btn2;
    private ImageView img;
    private ImageView anim, anim2, anim3;
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
      //  isStoragePermissionGranted();

        anim = (ImageView)findViewById(R.id.imageView7);
        Drawable drawable = anim.getDrawable();
        if (drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent22 =  new Intent (MainActivity.this, Main2Activity.class);
                startActivity(intent22);
                overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                finish();
//                Toast.makeText(
//                        MainActivity.this ,"Функция выполнилась" ,
//                        Toast.LENGTH_SHORT)
//                        .show();

            }
        }, SPLASH_TIME_OUT);

      //  sp();
    }

    public void sp() {
        Intent intent22 =  new Intent (MainActivity.this, SA_2_2.class);
        startActivity(intent22);
        overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
    }

        // img = (ImageView)findViewById(R.id.imageView);

      //  isStoragePermissionGranted();
      //  addListenerOnButton();

//        anim = (ImageView)findViewById(R.id.imageView7);
//        anim2 = (ImageView)findViewById(R.id.imageView9);
//        anim3 = (ImageView)findViewById(R.id.imageView10);
////        Drawable drawable1 = anim1.getDrawable();
////        if (drawable1 instanceof Animatable){
////            ((Animatable) drawable1).start();
////        }
//        Drawable drawable = anim.getDrawable();
//        if (drawable instanceof Animatable){
//            ((Animatable) drawable).start();
//        }
//        Drawable drawable1 = anim2.getDrawable();
//        if (drawable1 instanceof Animatable){
//            ((Animatable) drawable1).start();
//        }
//        Drawable drawable2 = anim3.getDrawable();
//        if (drawable2 instanceof Animatable){
//            ((Animatable) drawable2).start();
//        }
//
//        anim2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent Intent1 = new Intent(".SA_1");
//                        startActivity(Intent1);
//                        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
//            }
//        });
//
//        anim3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent Intent2 = new Intent(".SA_2");
//                        startActivity(Intent2);
//                        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
//            }
//        });

   // }

  //  public void addListenerOnButton() {
//        btn = (Button) findViewById(R.id.but);
//        btn1 = (Button) findViewById(R.id.open);
//        btn2 = (Button) findViewById(R.id.create);
        // btn3 = (Button)findViewById(R.id.open2);
//        btn.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
//                        a_builder.setMessage("Закрыть приложение?")
//                                .setCancelable(false)
//                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        finish();
//                                    }
//                                })
//                                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        dialog.cancel();
//                                    }
//                                });
//                        AlertDialog alert1 = a_builder.create();
//                        alert1.setTitle("Закрытие приложения");
//                        alert1.show();
//                    }
//                }
//        );
//        btn1.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent Intent1 = new Intent(".SA_1");
//                        startActivity(Intent1);
//                        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
//
//                    }
//                }
//        );
//        btn2.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent Intent2 = new Intent(".SA_2");
//                        startActivity(Intent2);
//                        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
//
//                    }
//                }
//        );

  //  }



    public boolean isStoragePermissionGranted() {             //штука которая дает доступ к файлам
        String TAG = "";
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }
}
