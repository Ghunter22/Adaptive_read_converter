package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class game2 extends AppCompatActivity {

    ImageView play_again,menu;
    TextView result,best1,best2,best3,all;
    ArrayList<String> str1 = new ArrayList<String>();   //массив для считывания
    public String dir = "storage/emulated/0/Download/";       //шаблон записи рекордов 1____325, в файле всегда только 3 записи
    public  String f_name = "arc";                            // запись с текущим количеством очков 4____5000
    boolean ch = false;
    String time;
    Integer i =0;
    Integer ind_count = 0;
    String[][] records;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        Intent intent113 = getIntent();

        // int flag = intent113.getFlags();
     //   finishActivity(flag);
        time  = intent113.getStringExtra("time");

        play_again = (ImageView) findViewById(R.id.play_again);
        menu = (ImageView) findViewById(R.id.play_menu);
        result = (TextView) findViewById(R.id.result2);
        best1 = (TextView) findViewById(R.id.best1);
        best2 = (TextView) findViewById(R.id.best2);
        best3= (TextView) findViewById(R.id.best3);
        all= (TextView) findViewById(R.id.all);
        result.setText(time);

        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent116 = new Intent(game2.this, game.class);


                intent116.putExtra("record1", records[0][1]);
                intent116.putExtra("record4", records[3][1]);

                startActivity(intent116);
               // intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                finish();

            }
        });

             menu.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent116 = new Intent(game2.this, game_menu.class);
                     startActivity(intent116);
                     // intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                     overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                     finish();
                 }
             });
            fileExists(dir + f_name+".txt");

            if(ch){ //файл найден
                try {
                    FileInputStream fstream = new FileInputStream(dir  + f_name + ".txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                        str1.add(strLine);               //тут надо считывать в массив

                    }
                    br.close();
                    fstream.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }


                String[] n_arr_info = new String[str1.size()];        //преобразуем лист в массив стринг
                str1.toArray(n_arr_info);

                records = new  String[4][2];

                for (i = 0; i < 4; i++) {                             //циклы получения данных из листа в массив


//                    Toast.makeText(
//                            game2.this, "№" + i + "  " + n_arr_info[i] ,
//                            Toast.LENGTH_SHORT)
//                            .show();


                    ind_count = n_arr_info[i].indexOf("____");
                   records[i][0] = n_arr_info[i].substring(0, ind_count); //вытаскиваю номер страницы

                    n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);


                    records[i][1] = n_arr_info[i];

                }


               records[3][1] = String.valueOf(Integer.valueOf(records[3][1]) + Integer.valueOf(time));

                if(Integer.valueOf(records[0][1]) < Integer.valueOf(time) ) {
                    records[2][1] =  records[1][1];
                    records[1][1] =  records[0][1];
                    records[0][1] = time;
                }

                if(Integer.valueOf(records[0][1]) > Integer.valueOf(time) && Integer.valueOf(records[1][1]) < Integer.valueOf(time) ) {
                    records[2][1] =  records[1][1];
                    records[1][1] = time;
                }

                if(Integer.valueOf(records[1][1]) > Integer.valueOf(time) && Integer.valueOf(records[2][1]) < Integer.valueOf(time) ) {
                    records[2][1] = time;
                }

                best1.setText("1. " +records[0][1]);
                best2.setText("2. " +records[1][1]);
                best3.setText("3. " +records[2][1]);
                all.setText("Всего очков: " +records[3][1]);

                try {
                    FileWriter writer = new FileWriter(dir + f_name + ".txt", false);
                    writer.write(  "1____" +records[0][1] + "\n");
                    writer.write("2____" +records[1][1] + "\n");
                    writer.write("3____" +records[2][1] + "\n");
                    writer.write("4____" +records[3][1] + "\n");
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }





            else{       //файла не существует
                try {
                    FileWriter writer = new FileWriter(dir + f_name + ".txt", false);
                    writer.write("1____"+time + "\n");
                    writer.write("2____0" + "\n");
                    writer.write("3____0" + "\n");
                    writer.write("4____"+time + "\n");
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


                best1.setText("1. " + time);
                best2.setText("2. 0");
                best3.setText("3. 0");
                all.setText("Всего очков: " + time);
            }











    }

    public boolean fileExists(String filename) {
        File file = new File(filename);
        if (file.exists()) {

            ch = true;
            return true;

        }
        else {
            ch = false;
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
