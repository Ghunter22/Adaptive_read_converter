package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class game_menu extends AppCompatActivity {

    ArrayList<String> str1 = new ArrayList<String>();   //массив для считывания
    public String dir = "storage/emulated/0/Download/";       //шаблон записи рекордов 1____325, в файле всегда только 3 записи
    public String f_name = "arc";                            // запись с текущим количеством очков 4____5000
    boolean ch = false;
    String time;
    Integer i = 0;
    Integer ind_count = 0;
    String[][] records;

    ImageView play, ext, achiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        play = (ImageView) findViewById(R.id.play);
        ext = (ImageView) findViewById(R.id.exit);
        achiv = (ImageView) findViewById(R.id.achiv);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent116 = new Intent(game_menu.this, game.class);
                intent116.putExtra("record1", records[0][1]);
                intent116.putExtra("record4", records[3][1]);
                startActivity(intent116);
                // intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                finish();
            }
        });

        achiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent116 = new Intent(game_menu.this, achivments.class);

                intent116.putExtra("record1", records[0][1]);
                intent116.putExtra("record2", records[1][1]);
                intent116.putExtra("record3", records[2][1]);
                intent116.putExtra("record4", records[3][1]);
                startActivity(intent116);


                // intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                finish();

            }
        });

////////////////////////////считываем рекорды/////////////////////////
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        fileExists(dir + f_name + ".txt");

        if (ch) { //файл найден
            try {
                FileInputStream fstream = new FileInputStream(dir + f_name + ".txt");
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

            records = new String[4][2];

            for (i = 0; i < 4; i++) {                             //циклы получения данных из листа в массив


                ind_count = n_arr_info[i].indexOf("____");
                records[i][0] = n_arr_info[i].substring(0, ind_count); //вытаскиваю номер рекорда

                n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);


                records[i][1] = n_arr_info[i];

            }


        } else {       //файла не существует
            try {
                FileWriter writer = new FileWriter(dir + f_name + ".txt", false);
                writer.write("1____0" + "\n");
                writer.write("2____0" + "\n");
                writer.write("3____0" + "\n");
                writer.write("4____0" + "\n");
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            records = new String[4][2];
            records[0][0] = "1";
            records[1][0] = "2";
            records[2][0] = "3";
            records[3][0] = "4";

            records[0][1] = "0";
            records[1][1] = "0";
            records[2][1] = "0";
            records[3][1] = "0";


        }
    }

    public boolean fileExists (String filename){
        File file = new File(filename);
        if (file.exists()) {

            ch = true;
            return true;

        } else {
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
