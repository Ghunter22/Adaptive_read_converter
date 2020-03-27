package com.example.sevatar.pw_pre_alpha;

import android.animation.ObjectAnimator;
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

public class ADD_VIDEO extends AppCompatActivity {
    private Button btnOk;
    String Ws, Com ;
    private EditText edt1,edt2;
    Integer page = 0;
    String dir = "storage/emulated/0/Download/";
    String type = "a";
    String del = "____";
    String f_name;
    private ImageView img,img2,img3,img4;
    String end_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__video);

        Intent intent51 = getIntent();
        String page_count = intent51.getStringExtra("page_count");
        f_name = intent51.getStringExtra("f_name");
        page = Integer.parseInt(page_count);
        edt1 = (EditText) findViewById(R.id.editText);
        edt2 = (EditText) findViewById(R.id.editText2);
        img = (ImageView)findViewById(R.id.img4);
        img2 = (ImageView)findViewById(R.id.imageView19);
        img3 = (ImageView)findViewById(R.id.imageView20);
        img4 = (ImageView)findViewById(R.id.imageView21);

        ObjectAnimator animation4 = ObjectAnimator.ofFloat(img, "alpha", 1.0f, 0.3f);
        animation4.setDuration(1);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();

        ObjectAnimator animation5 = ObjectAnimator.ofFloat(img2, "alpha", 1.0f, 0.3f);
        animation5.setDuration(1);
        animation5.setInterpolator(new AccelerateDecelerateInterpolator());
        animation5.start();

        ObjectAnimator animation6 = ObjectAnimator.ofFloat(img3, "alpha", 1.0f, 0.3f);
        animation6.setDuration(1);
        animation6.setInterpolator(new AccelerateDecelerateInterpolator());
        animation6.start();

        ObjectAnimator animation7 = ObjectAnimator.ofFloat(img4, "alpha", 1.0f, 0.3f);
        animation7.setDuration(1);
        animation7.setInterpolator(new AccelerateDecelerateInterpolator());
        animation7.start();


        addListenerOnButton();
    }
    public void addListenerOnButton() {
        btnOk = (Button) findViewById(R.id.butOk);
        btnOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ws = edt1.getText().toString(); // приводим к типу String
                        Com = edt2.getText().toString(); // приводим к типу String
                        if(Ws.length()==0){
                            Toast.makeText(
                                    ADD_VIDEO.this ,"Заполните поле" ,
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                        else {
                            //img.setImageResource(R.drawable.redarc);
                        end_info = String.valueOf(page) + del + type + del + Ws + del + Com;

//                        Toast.makeText(
//                ADD_VIDEO.this ,String.valueOf(page) + del + type + del + Ws + del + Com ,
//                Toast.LENGTH_SHORT)
//                .show();
                        try {
                            FileWriter writer = new FileWriter( dir +f_name+".txt", true);     //работает норм
                            writer.write(end_info+'\n'); // не забывай знак новой строки
                            //  writer.write(a_info.get(0)+'\n');
                            writer.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                        Toast.makeText(
                ADD_VIDEO.this ,"Сохранено" ,
                Toast.LENGTH_SHORT)
                .show();
                            File file = new File(dir +"arc_z"+f_name + ".txt");
                            file.delete();
                            anim();
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

    public  void anim(){

        ObjectAnimator animation4 = ObjectAnimator.ofFloat(img, "alpha", .3f, 1.0f);
        animation4.setDuration(2000);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();

        ObjectAnimator animation5 = ObjectAnimator.ofFloat(img2, "alpha", .3f, 1.0f);
        animation5.setDuration(2000);
        animation5.setStartDelay(1400);
        animation5.setInterpolator(new AccelerateDecelerateInterpolator());
        animation5.start();

        ObjectAnimator animation6 = ObjectAnimator.ofFloat(img3, "alpha", .3f, 1.0f);
        animation6.setDuration(2000);
        animation6.setStartDelay(2600);
        animation6.setInterpolator(new AccelerateDecelerateInterpolator());
        animation6.start();

        ObjectAnimator animation7 = ObjectAnimator.ofFloat(img4, "alpha", .3f, 1.0f);
        animation7.setDuration(2000);
        animation7.setStartDelay(3500);
        animation7.setInterpolator(new AccelerateDecelerateInterpolator());
        animation7.start();

    }

}
