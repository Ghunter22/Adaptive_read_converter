package com.example.sevatar.pw_pre_alpha;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;

import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private Button btn, btn1, btn2;
    private ImageView img;
    private ImageView anim,anim2, anim3,anim4,anim5, anim6,anim7,cde,anim8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // img = (ImageView)findViewById(R.id.imageView);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        isStoragePermissionGranted();
        addListenerOnButton();

        anim = (ImageView)findViewById(R.id.imageView13);
        anim2 = (ImageView)findViewById(R.id.imageView9);
        anim3 = (ImageView)findViewById(R.id.imageView10);
        anim4 = (ImageView)findViewById(R.id.imageView8);
        anim5 = (ImageView)findViewById(R.id.imageView12);
        anim6 = (ImageView)findViewById(R.id.imageView18);
        anim7 = (ImageView)findViewById(R.id.imageView11);
        anim8 = (ImageView)findViewById(R.id.imageView22);

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(anim6,  // анимация
                PropertyValuesHolder.ofFloat("scaleX", 0.85f),
                PropertyValuesHolder.ofFloat("scaleY", 0.85f));
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.setRepeatCount(-1);
        scaleDown.setDuration(3100);
        //  scaleDown.setStartDelay(1200);
        scaleDown.start();

        ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(anim8,  // анимация
                PropertyValuesHolder.ofFloat("scaleX", 0.65f),
                PropertyValuesHolder.ofFloat("scaleY", 0.65f));
        scaleDown1.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown1.setRepeatCount(-1);
        scaleDown1.setDuration(5100);
        //  scaleDown.setStartDelay(1200);
        scaleDown1.start();
       // main_anim();



//        Drawable drawable1 = anim1.getDrawable();
//        if (drawable1 instanceof Animatable){
//            ((Animatable) drawable1).start();
//        }
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
        anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent116 = new Intent(Main2Activity.this, help.class);
                startActivity(intent116);
                // intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                finish();
            }
        });

        anim7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Main2Activity.this);
                        a_builder.setMessage("")
                                .setCancelable(false)
                                .setPositiveButton("Отмена", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                                .setNegativeButton("Закрыть", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        finish();

                                    }
                                });
                        AlertDialog alert1 = a_builder.create();
                        alert1.setTitle("Закрыть приложение?");
                        alert1.show();

            }
        });

        anim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(".SA_1");
                startActivity(Intent1);
                overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
                finish();
            }
        });

        anim3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent2 = new Intent(".SA_2");
                startActivity(Intent2);
                overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
                finish();
            }
        });

        anim5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent11 = new Intent(Main2Activity.this, inst.class);
                // intent22.putExtra( )
                startActivity(intent11);
                finish();
                overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
            }
        });

        anim4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent11 = new Intent(Main2Activity.this, prog.class);
                // intent22.putExtra( )
                startActivity(intent11);
                finish();
                overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
            }
        });

    }

    public void  main_anim(){    //функция анимации кнопок главного меню

//                Drawable drawable1 = anim6.getDrawable();
//        if (drawable1 instanceof Animatable){
//            ((Animatable) drawable1).start();
//        }

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(anim,  // анимация
                PropertyValuesHolder.ofFloat("scaleX", 0.92f),
                PropertyValuesHolder.ofFloat("scaleY", 0.92f));
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.setRepeatCount(-1);
        scaleDown.setDuration(3100);
        //  scaleDown.setStartDelay(1200);
        scaleDown.start();

        ObjectAnimator scaleDown2 = ObjectAnimator.ofPropertyValuesHolder(anim3, // анимация открыть
                PropertyValuesHolder.ofFloat("scaleX", 0.95f),
                PropertyValuesHolder.ofFloat("scaleY", 0.95f));
        scaleDown2.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown2.setRepeatCount(-1);
        scaleDown2.setDuration(3600);
        scaleDown2.setStartDelay(900);
        scaleDown2.start();

        ObjectAnimator scaleDown3 = ObjectAnimator.ofPropertyValuesHolder(anim4, //анимация о приложении
                PropertyValuesHolder.ofFloat("scaleX", 0.96f),
                PropertyValuesHolder.ofFloat("scaleY", 0.96f));
        scaleDown3.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown3.setRepeatCount(-1);
        scaleDown3.setDuration(3300);
        scaleDown3.setStartDelay(400);
        scaleDown3.start();

        ObjectAnimator scaleDown4 = ObjectAnimator.ofPropertyValuesHolder(anim5,   //анимация инструкции
                PropertyValuesHolder.ofFloat("scaleX", 0.94f),
                PropertyValuesHolder.ofFloat("scaleY", 0.94f));
        scaleDown4.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown4.setRepeatCount(-1);
        scaleDown4.setDuration(3200);
        scaleDown4.setStartDelay(100);
        scaleDown4.start();

        ObjectAnimator scaleDown5 = ObjectAnimator.ofPropertyValuesHolder(anim2, // анимация открыть
                PropertyValuesHolder.ofFloat("scaleX", 0.94f),
                PropertyValuesHolder.ofFloat("scaleY", 0.94f));
        scaleDown5.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown5.setRepeatCount(-1);
        scaleDown5.setDuration(3500);
        scaleDown5.setStartDelay(1100);
        scaleDown5.start();

        ObjectAnimator scaleDown6 = ObjectAnimator.ofPropertyValuesHolder(anim7, // анимация открыть
                PropertyValuesHolder.ofFloat("scaleX", 0.94f),
                PropertyValuesHolder.ofFloat("scaleY", 0.94f));
        scaleDown6.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown6.setRepeatCount(-1);
        scaleDown6.setDuration(3500);
        scaleDown6.setStartDelay(330);
        scaleDown6.start();


    }
    public void addListenerOnButton() {
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

    }



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
