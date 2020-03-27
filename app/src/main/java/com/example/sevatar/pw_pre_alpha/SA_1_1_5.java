package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SA_1_1_5 extends AppCompatActivity {
    private Button btnOk;
    String Ws, Com ;
    private EditText edt1,edt2,edt3;
    Integer page = 0;
    String dir = "storage/emulated/0/Download/";
    String type = "f";
    String del = "____";
    String tm, ml, cd;
    String f_name;
    boolean check = false;
    String end_info;
   // private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_1_1_5);
        Intent intent52 = getIntent();
        String page_count = intent52.getStringExtra("page_count");
        f_name = intent52.getStringExtra("f_name");
        page = Integer.parseInt(page_count);


        edt1 = (EditText) findViewById(R.id.editText7);
        edt2 = (EditText) findViewById(R.id.editText8);
        edt3 = (EditText) findViewById(R.id.editText9);
        // edt1.max
       // img = (ImageView)findViewById(R.id.img3);
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
                        tm = edt1.getText().toString(); // приводим к типу String
                        ml = edt2.getText().toString();
                        cd = edt3.getText().toString();
                        if(tm.length()==0||ml.length()==0||cd.length()==0){
                            Toast.makeText(
                                    SA_1_1_5.this ,"Заполните все поля" ,
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                        else {
                              check = isDigit(tm);
                            if(check) {

                                end_info = String.valueOf(page) + del + type + del + Ws + del + tm+"|||"+ml+"|||"+cd;

                                try {
                                    FileWriter writer = new FileWriter( dir  +f_name+".txt", true);     //работает норм
                                    writer.write(end_info+'\n'); // не забывай знак новой строки
                                    //  writer.write(a_info.get(0)+'\n');
                                    writer.close();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }

                                Toast.makeText(
                                        SA_1_1_5.this ,"Сохранено" ,
                                        Toast.LENGTH_SHORT)
                                        .show();
                                File file = new File(dir +"arc_z"+f_name + ".txt");
                                file.delete();
                            } else {
                                Toast.makeText(
                                        SA_1_1_5.this ,"Введите число" ,
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                           // img.setImageResource(R.drawable.redarc);


//                        Toast.makeText(
//                ADD_VIDEO.this ,String.valueOf(page) + del + type + del + Ws + del + Com ,
//                Toast.LENGTH_SHORT)
//                .show();

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
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
