package com.example.sevatar.pw_pre_alpha;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ADD_WS extends AppCompatActivity {
    private Button btnOk;
    String Ws, Com ;
    private EditText edt1,edt2;
    Integer page = 0;
    String dir = "storage/emulated/0/Download/";
    String type = "c";
    String del = "____";
    String f_name;
    String end_info;
    private ImageView img,img2,img3,img4,img5,img6,img7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__ws);
        Intent intent52 = getIntent();
        String page_count = intent52.getStringExtra("page_count");
        f_name = intent52.getStringExtra("f_name");
        page = Integer.parseInt(page_count);
        edt1 = (EditText) findViewById(R.id.editText5);
        edt2 = (EditText) findViewById(R.id.editText6);
        img = (ImageView)findViewById(R.id.img2);
        img2 = (ImageView)findViewById(R.id.img3);
        img3 = (ImageView)findViewById(R.id.img4);
        img4 = (ImageView)findViewById(R.id.img5);
        img5 = (ImageView)findViewById(R.id.img6);
        img6 = (ImageView)findViewById(R.id.img7);
        img7 = (ImageView)findViewById(R.id.img8);

        ObjectAnimator animation3 = ObjectAnimator.ofFloat(img4, "alpha", 1.0f, 0.0f);
        animation3.setDuration(1);
        animation3.setInterpolator(new AccelerateDecelerateInterpolator());
        animation3.start();

        ObjectAnimator animation4 = ObjectAnimator.ofFloat(img5, "alpha", 1.0f, 0.0f);
        animation4.setDuration(1);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();

        ObjectAnimator animation5 = ObjectAnimator.ofFloat(img6, "alpha", 1.0f, 0.0f);
        animation5.setDuration(1);
        animation5.setInterpolator(new AccelerateDecelerateInterpolator());
        animation5.start();

        ObjectAnimator animation6 = ObjectAnimator.ofFloat(img7, "alpha", 1.0f, 0.0f);
        animation6.setDuration(1);
        animation6.setInterpolator(new AccelerateDecelerateInterpolator());
        animation6.start();

        ObjectAnimator animation7 = ObjectAnimator.ofFloat(img, "alpha", 1.0f, 0.5f);
        animation7.setDuration(1);
        animation7.setInterpolator(new AccelerateDecelerateInterpolator());
        animation7.start();

        ObjectAnimator animation8 = ObjectAnimator.ofFloat(img2, "alpha", 1.0f, 0.5f);
        animation8.setDuration(1);
        animation8.setInterpolator(new AccelerateDecelerateInterpolator());
        animation8.start();

        ObjectAnimator animation9 = ObjectAnimator.ofFloat(img3, "alpha", 1.0f, 0.5f);
        animation9.setDuration(1);
        animation9.setInterpolator(new AccelerateDecelerateInterpolator());
        animation9.start();

        addListenerOnButton();
    }
    public void addListenerOnButton() {
        btnOk = (Button) findViewById(R.id.butOk2);
        btnOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ws = edt1.getText().toString(); // приводим к типу String
                        Com = edt2.getText().toString(); // приводим к типу String
                        if (Ws.length() == 0) {
                            Toast.makeText(
                                    ADD_WS.this, "Заполните поле",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                         //   img.setImageResource(R.drawable.redarc);
                            anim();
                            end_info = String.valueOf(page) + del + type + del + Ws + del + Com;

//                        Toast.makeText(
//                ADD_VIDEO.this ,String.valueOf(page) + del + type + del + Ws + del + Com ,
//                Toast.LENGTH_SHORT)
//                .show();
                            try {
                                FileWriter writer = new FileWriter(dir + f_name + ".txt", true);     //работает норм
                                writer.write(end_info + '\n'); // не забывай знак новой строки
                                //  writer.write(a_info.get(0)+'\n');
                                writer.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                            Toast.makeText(
                                    ADD_WS.this, "Сохранено",
                                    Toast.LENGTH_SHORT)
                                    .show();
                            File file = new File(dir +"arc_z"+f_name + ".txt");
                            file.delete();
                        }
                    }
                }
        );
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
    }

    public void anim(){
        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(1f, 360000f);
        Keyframe kf2 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf3 = Keyframe.ofFloat(1f, -36000f);


        Keyframe kf4 = Keyframe.ofFloat(0,0f);
        Keyframe kf5 = Keyframe.ofFloat(.4f,100f);
        Keyframe kf6 = Keyframe.ofFloat(.8f,40f);
        Keyframe kf7 = Keyframe.ofFloat(1f,0f);

        Keyframe kf8 = Keyframe.ofFloat(0f,0f);
        Keyframe kf9 = Keyframe.ofFloat(.4f,20f);
        Keyframe kf10 = Keyframe.ofFloat(.8f,90f);
        Keyframe kf11 = Keyframe.ofFloat(1f,0f);

        Keyframe kf12 = Keyframe.ofFloat(0f,0f);
        Keyframe kf13 = Keyframe.ofFloat(.3f,-90f);
        Keyframe kf14 = Keyframe.ofFloat(.7f,-20f);
        Keyframe kf15 = Keyframe.ofFloat(1f,0f);

        Keyframe kf16 = Keyframe.ofFloat(0,0f);
        Keyframe kf17 = Keyframe.ofFloat(.3f,40f);
        Keyframe kf18 = Keyframe.ofFloat(.7f,-40f);
        Keyframe kf19 = Keyframe.ofFloat(1f,0f);


        ObjectAnimator animation3 = ObjectAnimator.ofFloat(img4, "alpha", 0.0f, 1.0f);
        animation3.setDuration(1500);
        animation3.setInterpolator(new AccelerateDecelerateInterpolator());
        animation3.start();

        ObjectAnimator animation4 = ObjectAnimator.ofFloat(img5, "alpha", 0.0f, 1.0f);
        animation4.setDuration(1500);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();

        ObjectAnimator animation5 = ObjectAnimator.ofFloat(img6, "alpha", 0.0f, 1.0f);
        animation5.setDuration(2000);
        animation5.setInterpolator(new AccelerateDecelerateInterpolator());
        animation5.start();

        ObjectAnimator animation6 = ObjectAnimator.ofFloat(img7, "alpha", 0.0f, 1.0f);
        animation6.setDuration(2000);
        animation6.setInterpolator(new AccelerateDecelerateInterpolator());
        animation6.start();

        ObjectAnimator animation7 = ObjectAnimator.ofFloat(img, "alpha", 0.5f, 1.0f);
        animation7.setDuration(2000);
        animation7.setInterpolator(new AccelerateDecelerateInterpolator());
        animation7.start();

        ObjectAnimator animation8 = ObjectAnimator.ofFloat(img2, "alpha", 0.5f, 1.0f);
        animation8.setDuration(2000);
        animation8.setInterpolator(new AccelerateDecelerateInterpolator());
        animation8.start();

        ObjectAnimator animation9 = ObjectAnimator.ofFloat(img3, "alpha", 0.5f, 1.0f);
        animation9.setDuration(2000);
        animation9.setInterpolator(new AccelerateDecelerateInterpolator());
        animation9.start();

        //////////////////////////////
        ObjectAnimator animation33 = ObjectAnimator.ofFloat(img4, "alpha", 1.0f, 0.0f);
        animation33.setDuration(1000);
        animation33.setStartDelay(60000);
        animation33.setInterpolator(new AccelerateDecelerateInterpolator());
        animation33.start();

        ObjectAnimator animation44 = ObjectAnimator.ofFloat(img5, "alpha", 1.0f, 0.0f);
        animation44.setDuration(1000);
        animation44.setStartDelay(60000);
        animation44.setInterpolator(new AccelerateDecelerateInterpolator());
        animation44.start();

        ObjectAnimator animation55 = ObjectAnimator.ofFloat(img6, "alpha", 1.0f, 0.0f);
        animation55.setDuration(1000);
        animation55.setStartDelay(60000);
        animation55.setInterpolator(new AccelerateDecelerateInterpolator());
        animation55.start();

        ObjectAnimator animation66 = ObjectAnimator.ofFloat(img7, "alpha", 1.0f, 0.0f);
        animation66.setDuration(1000);
        animation66.setStartDelay(60000);
        animation66.setInterpolator(new AccelerateDecelerateInterpolator());
        animation66.start();


        ObjectAnimator animation332 = ObjectAnimator.ofFloat(img, "alpha", 1.0f, 0.5f);
        animation332.setDuration(1000);
        animation332.setStartDelay(60000);
        animation332.setInterpolator(new AccelerateDecelerateInterpolator());
        animation332.start();

        ObjectAnimator animation442 = ObjectAnimator.ofFloat(img2, "alpha", 1.0f, 0.5f);
        animation442.setDuration(1000);
        animation442.setStartDelay(60000);
        animation442.setInterpolator(new AccelerateDecelerateInterpolator());
        animation442.start();

        ObjectAnimator animation552 = ObjectAnimator.ofFloat(img3, "alpha", 1.0f, 0.5f);
        animation552.setDuration(1000);
        animation552.setStartDelay(60000);
        animation552.setInterpolator(new AccelerateDecelerateInterpolator());
        animation552.start();
        //////////


//        Keyframe kf4 = Keyframe.ofFloat(1f, 1920f);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1);
        ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(img, pvhRotation);
        rotationAnim.setDuration(60000);
        rotationAnim.setRepeatMode(ValueAnimator.RESTART);
        rotationAnim.setRepeatCount(0);
        rotationAnim.start();

        ObjectAnimator rotationAnim1 = ObjectAnimator.ofPropertyValuesHolder(img2, pvhRotation);
        rotationAnim1.setDuration(60000);
        rotationAnim1.setRepeatMode(ValueAnimator.RESTART);
        rotationAnim1.setRepeatCount(0);
        rotationAnim1.start();

        PropertyValuesHolder pvhRotation1 = PropertyValuesHolder.ofKeyframe("rotation", kf2, kf3);
        ObjectAnimator rotationAnim2 = ObjectAnimator.ofPropertyValuesHolder(img3, pvhRotation1);
        rotationAnim2.setDuration(60000);
        rotationAnim2.setRepeatMode(ValueAnimator.RESTART);
        rotationAnim2.setRepeatCount(0);
        rotationAnim2.start();

        PropertyValuesHolder pvhRotation2 = PropertyValuesHolder.ofKeyframe("translationX", kf4, kf5,kf6,kf7);
        ObjectAnimator rotationAnim3 = ObjectAnimator.ofPropertyValuesHolder(img4, pvhRotation2);
        rotationAnim3.setDuration(500);
        rotationAnim3.setRepeatMode(ValueAnimator.RESTART);
        rotationAnim3.setRepeatCount(120);
        rotationAnim3.start();

        PropertyValuesHolder pvhRotation3 = PropertyValuesHolder.ofKeyframe("translationY", kf8, kf9,kf10,kf11);

        ObjectAnimator rotationAnim4 = ObjectAnimator.ofPropertyValuesHolder(img4, pvhRotation3);
        rotationAnim4.setDuration(500);
        rotationAnim4.setRepeatMode(ValueAnimator.RESTART);
        rotationAnim4.setRepeatCount(120);
        rotationAnim4.start();


        PropertyValuesHolder pvhRotation4 = PropertyValuesHolder.ofKeyframe("translationX", kf12, kf13,kf14,kf15);
        ObjectAnimator rotationAnim5 = ObjectAnimator.ofPropertyValuesHolder(img5, pvhRotation4);
        rotationAnim5.setDuration(490);
        rotationAnim5.setRepeatMode(ValueAnimator.RESTART);
        rotationAnim5.setRepeatCount(120);
        rotationAnim5.start();

        PropertyValuesHolder pvhRotation5 = PropertyValuesHolder.ofKeyframe("translationY", kf16, kf17,kf18,kf19);

        ObjectAnimator rotationAnim6 = ObjectAnimator.ofPropertyValuesHolder(img5, pvhRotation5);
        rotationAnim6.setDuration(510);
        rotationAnim6.setRepeatMode(ValueAnimator.RESTART);
        rotationAnim6.setRepeatCount(120);
        rotationAnim6.start();


        Keyframe kf20 = Keyframe.ofFloat(0f,0f);
        Keyframe kf21 = Keyframe.ofFloat(1f,8f);      //верх
        Keyframe kf22 = Keyframe.ofFloat(0f,0f);
        Keyframe kf23 = Keyframe.ofFloat(1f,8f);

        Keyframe kf24 = Keyframe.ofFloat(0f,0f);
        Keyframe kf25 = Keyframe.ofFloat(1f,-8f);
        Keyframe kf26 = Keyframe.ofFloat(0f,0f);       //низ
        Keyframe kf27 = Keyframe.ofFloat(1f,-8f);

        PropertyValuesHolder pvhRotation6 = PropertyValuesHolder.ofKeyframe("translationX", kf20,kf21);
        PropertyValuesHolder pvhRotation66 = PropertyValuesHolder.ofKeyframe("translationY",kf22,kf23);

        ObjectAnimator rotationAnim66 = ObjectAnimator.ofPropertyValuesHolder(img6, pvhRotation6);
        rotationAnim66.setDuration(80);
        rotationAnim66.setRepeatMode(ValueAnimator.REVERSE);
        rotationAnim66.setRepeatCount(900);
        rotationAnim66.start();

        ObjectAnimator rotationAnim666 = ObjectAnimator.ofPropertyValuesHolder(img6, pvhRotation66);
        rotationAnim666.setDuration(80);
        rotationAnim666.setRepeatMode(ValueAnimator.REVERSE);
        rotationAnim666.setRepeatCount(900);
        rotationAnim666.start();

//        PropertyValuesHolder pvhRotation7 = PropertyValuesHolder.ofKeyframe("translationX",kf24,kf25);
//        PropertyValuesHolder pvhRotation77 = PropertyValuesHolder.ofKeyframe("translationY", kf26,kf27);
//
//
//        ObjectAnimator rotationAnim661 = ObjectAnimator.ofPropertyValuesHolder(img7, pvhRotation7);
//        rotationAnim661.setDuration(80);
//        rotationAnim661.setRepeatMode(ValueAnimator.REVERSE);
//        rotationAnim661.setRepeatCount(900);
//        rotationAnim661.start();
//
//        ObjectAnimator rotationAnim6661 = ObjectAnimator.ofPropertyValuesHolder(img7, pvhRotation77);
//        rotationAnim6661.setDuration(80);
//        rotationAnim6661.setRepeatMode(ValueAnimator.REVERSE);
//        rotationAnim6661.setRepeatCount(900);
//        rotationAnim6661.start();

    }
}

