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

public class ADD_TEXT extends AppCompatActivity {
    private Button btnOk;
    String Ws, Com ;
    private EditText edt1,edt2;
    Integer page = 0;
    String dir = "storage/emulated/0/Download/";
    String type = "d";
    String del = "____";
    String f_name;
    String end_info;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__text);
        Intent intent52 = getIntent();
        String page_count = intent52.getStringExtra("page_count");
        f_name = intent52.getStringExtra("f_name");
        page = Integer.parseInt(page_count);
        edt1 = (EditText) findViewById(R.id.editText7);
       // edt1.max
        img = (ImageView)findViewById(R.id.img3);
      //  edt2 = (EditText) findViewById(R.id.editText6);
         //  Ws = "";
        addListenerOnButton();
    }
    public void addListenerOnButton() {
        btnOk = (Button) findViewById(R.id.butOk4);
        btnOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                   //     Ws = "http"; // приводим к типу String
                        Com = edt1.getText().toString(); // приводим к типу String
                        if(Com.length()==0){
                            Toast.makeText(
                                    ADD_TEXT.this ,"Заполните поле" ,
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                        else {
                          //  img.setImageResource(R.drawable.redarc);
                            anim();
                        end_info = String.valueOf(page) + del + type + del + Ws + del + Com;

//                        Toast.makeText(
//                ADD_VIDEO.this ,String.valueOf(page) + del + type + del + Ws + del + Com ,
//                Toast.LENGTH_SHORT)
//                .show();
                        try {
                            FileWriter writer = new FileWriter( dir  +f_name+".txt", true);     //работает норм
                            writer.write(end_info+'\n'); // не забывай знак новой строки
                            //  writer.write(a_info.get(0)+'\n');
                            writer.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                        Toast.makeText(
                                ADD_TEXT.this ,"Сохранено" ,
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

        ObjectAnimator player_right = ObjectAnimator.ofFloat(img, "translationY", -900); //убираю картинку за экран
        player_right.setDuration(9000);
        player_right.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right.start();


        ObjectAnimator animation4 = ObjectAnimator.ofFloat(img, "alpha", 1.0f, 0.0f);
        animation4.setDuration(8000);
      //  animation4.setRepeatCount(0);
      //  animation4.setRepeatMode(ObjectAnimator.RESTART);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();
    }

}