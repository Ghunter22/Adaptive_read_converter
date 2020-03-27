package com.example.sevatar.pw_pre_alpha;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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

public class ADD_IMAGE extends AppCompatActivity {
    private Button btnOk;
   private ImageView img,img2;
    String Ws, Com ;
    private EditText edt1,edt2;
    Integer page = 0;
    String dir = "storage/emulated/0/Download/";
    String type = "b";
    String del = "____";
    String f_name;
    String end_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__image);

        Intent intent52 = getIntent();
        String page_count = intent52.getStringExtra("page_count");
        f_name = intent52.getStringExtra("f_name");
        page = Integer.parseInt(page_count);
        edt1 = (EditText) findViewById(R.id.editText3);
        edt2 = (EditText) findViewById(R.id.editText4);
        img = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);

        addListenerOnButton();


        ObjectAnimator animation4 = ObjectAnimator.ofFloat(img, "alpha", 1.0f, 0.0f);
        animation4.setDuration(1);
        //  animation4.setRepeatCount(0);
        //  animation4.setRepeatMode(ObjectAnimator.RESTART);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();


//        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(img,
//                PropertyValuesHolder.ofFloat("scaleX", 0.8f),
//                PropertyValuesHolder.ofFloat("scaleY", 0.8f));
//        scaleDown.setDuration(1);
//       // scaleDown.setStartDelay(1200);
//        scaleDown.start();
//
//        ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(img2,
//                PropertyValuesHolder.ofFloat("scaleX", 0.8f),
//                PropertyValuesHolder.ofFloat("scaleY", 0.8f));
//        scaleDown1.setDuration(1);
//      //  scaleDown1.setStartDelay(1200);
//        scaleDown1.start();
    }
    public void addListenerOnButton() {
        btnOk = (Button) findViewById(R.id.butOk1);
        btnOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ws = edt1.getText().toString(); // приводим к типу String
                        Com = edt2.getText().toString(); // приводим к типу String
                        if(Ws.length()==0){
                            Toast.makeText(
                                    ADD_IMAGE.this ,"Заполните поле" ,
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
                         anim();
                        Toast.makeText(
                                ADD_IMAGE.this ,"Сохранено" ,
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


        ObjectAnimator animation4 = ObjectAnimator.ofFloat(img, "alpha", 0.0f, 1.0f);
        animation4.setDuration(4000);
        //  animation4.setRepeatCount(0);
        //  animation4.setRepeatMode(ObjectAnimator.RESTART);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();

        ObjectAnimator animation5 = ObjectAnimator.ofFloat(img2, "alpha", 1.0f, 0.0f);
        animation5.setDuration(4000);
        //  animation4.setRepeatCount(0);
        //  animation4.setRepeatMode(ObjectAnimator.RESTART);
        animation5.setInterpolator(new AccelerateDecelerateInterpolator());
        animation5.start();

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(img,
                PropertyValuesHolder.ofFloat("scaleX", 1.05f),
                PropertyValuesHolder.ofFloat("scaleY", 1.05f));
        scaleDown.setDuration(4000);
      //  scaleDown.setStartDelay(1200);
        scaleDown.start();

        ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(img2,
                PropertyValuesHolder.ofFloat("scaleX", 1.05f),
                PropertyValuesHolder.ofFloat("scaleY", 1.05f));
        scaleDown1.setDuration(4000);
      //  scaleDown1.setStartDelay(1200);
        scaleDown1.start();
    }

}

