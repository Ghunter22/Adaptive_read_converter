package com.example.sevatar.pw_pre_alpha;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.github.barteksc.pdfviewer.PDFView;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SA_1 extends AppCompatActivity {
    public String dir = "storage/emulated/0/Download/";
  //  public String dir2 = "storage/emulated/0/VK/Download/";
    public String ext = ".pdf";
    ImageView r1,r2,r3;


    private ListView list;
    //   private static String [] files2 = new String[] {};
    public static List<String> files1 = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_1);
        findFiles(dir, ext);
       // findFiles(dir2, ext);
        list1();
        r1 = (ImageView)findViewById(R.id.wall2);
        r2 = (ImageView)findViewById(R.id.wall3);
        r3 = (ImageView)findViewById(R.id.wall4);
        anim();

    }


    public void list1() {                            //сюда список выводится список файлов

        String[] files = new String[files1.size()];
        files1.toArray(files);

        list = (ListView) findViewById(R.id.listView3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.text_colors_lv2, files);
        list.setAdapter(adapter);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        int index;
                        String n_val;
                        String val = (String) list.getItemAtPosition(i);        //имя файла включающее расширение
                        index = val.indexOf(".");                                 // получение длины строки без расширения
                        n_val = val.substring(0,index) ;               //  копирование имени файла без расширения
                     //  new File(dir+n_val).mkdir();                     // создание пакета

                        //Создание файла хранения данных с расширением txt
//                        File newFile = new File(dir+n_val+"/"+n_val+".txt");
//                        try
//                        {
//                            boolean created = newFile.createNewFile();
//                            if(created)
//                                System.out.println("File has been created");
//                        }
//                        catch(IOException ex){
//
//                            System.out.println(ex.getMessage());
//                        }
                        ////////////////////////////////////////// ниже отправка данных на следующее активити
                        Intent intent11 = new Intent(SA_1.this, SA_1_1.class);
                        intent11.putExtra("fname1", val);
                        intent11.putExtra("fname2", n_val);
                        // intent22.putExtra( )
                        startActivity(intent11);
                        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
//                        Toast.makeText(
//                                SA_2.this, dir+val , Toast.LENGTH_SHORT
//                        ).show();
                        // OpenFile(val);
                    }
                }
        );
    }





    public static void findFiles(String dir, String ext) {              //функция поиска файлов
        files1.clear();
        File file = new File(dir);
        if (!file.exists()) files1.add("");
        File[] listFiles = file.listFiles(new MyFileNameFilter(ext));
        if (listFiles.length == 0) {
            files1.add(dir + " не содержит файлов с расширением " + ext);
        } else
            // {
            for (File f : listFiles)
                files1.add(f.getName());

        //}
    }

    public  void  anim(){
//        ObjectAnimator player_right = ObjectAnimator.ofFloat(r1, "translationY", -500); //убираю картинку за экран
//        player_right.setDuration(1);
//        player_right.setInterpolator(new AccelerateDecelerateInterpolator());
//        player_right.start();

        ObjectAnimator player_right1 = ObjectAnimator.ofFloat(r1, "translationY", 500,-1500); //убираю картинку за экран
        player_right1.setDuration(21000);
        player_right1.setStartDelay(10);
        player_right1.setRepeatMode(ValueAnimator.RESTART);
        player_right1.setRepeatCount(-1);
        player_right1.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right1.start();

        ObjectAnimator player_right2 = ObjectAnimator.ofFloat(r1, "translationX", -100,100); //убираю картинку за экран
        player_right2.setDuration(2500);
        player_right2.setStartDelay(10);
        player_right2.setRepeatMode(ValueAnimator.REVERSE);
        player_right2.setRepeatCount(-1);
        player_right2.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right2.start();

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(r1,  // анимация
                PropertyValuesHolder.ofFloat("scaleX", 0.65f),
                PropertyValuesHolder.ofFloat("scaleY", 0.65f));
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.setRepeatCount(-1);
        scaleDown.setDuration(4000);
        //  scaleDown.setStartDelay(1200);
        scaleDown.start();








        ObjectAnimator player_right3 = ObjectAnimator.ofFloat(r2, "translationY", 500,-1500); //убираю картинку за экран
        player_right3.setDuration(33000);
        player_right3.setStartDelay(10);
        player_right3.setRepeatMode(ValueAnimator.RESTART);
        player_right3.setRepeatCount(-1);
        player_right3.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right3.start();

        ObjectAnimator player_right4 = ObjectAnimator.ofFloat(r2, "translationX", -100,100); //убираю картинку за экран
        player_right4.setDuration(3600);
        player_right4.setStartDelay(10);
        player_right4.setRepeatMode(ValueAnimator.REVERSE);
        player_right4.setRepeatCount(-1);
        player_right4.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right4.start();

        ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(r2,  // анимация
                PropertyValuesHolder.ofFloat("scaleX", 0.75f),
                PropertyValuesHolder.ofFloat("scaleY", 0.75f));
        scaleDown1.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown1.setRepeatCount(-1);
        scaleDown1.setDuration(3500);
        //  scaleDown.setStartDelay(1200);
        scaleDown1.start();










        ObjectAnimator player_right5 = ObjectAnimator.ofFloat(r3, "translationY", 500,-1500); //убираю картинку за экран
        player_right5.setDuration(24000);
        player_right5.setStartDelay(10);
        player_right5.setRepeatMode(ValueAnimator.RESTART);
        player_right5.setRepeatCount(-1);
        player_right5.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right5.start();

        ObjectAnimator player_right6 = ObjectAnimator.ofFloat(r3, "translationX", -100,100); //убираю картинку за экран
        player_right6.setDuration(4000);
        player_right6.setStartDelay(10);
        player_right6.setRepeatMode(ValueAnimator.REVERSE);
        player_right6.setRepeatCount(-1);
        player_right6.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right6.start();



        ObjectAnimator scaleDown2 = ObjectAnimator.ofPropertyValuesHolder(r3,  // анимация
                PropertyValuesHolder.ofFloat("scaleX", 0.85f),
                PropertyValuesHolder.ofFloat("scaleY", 0.85f));
        scaleDown2.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown2.setRepeatCount(-1);
        scaleDown2.setDuration(3000);
        //  scaleDown.setStartDelay(1200);
        scaleDown2.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent11 = new Intent(SA_1.this, Main2Activity.class);
        // intent22.putExtra( )
        startActivity(intent11);
        finish();
        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
    }

    public static class MyFileNameFilter implements FilenameFilter {          //фильтр по пдф

        private String ext;

        private MyFileNameFilter(String ext) {
            this.ext = ext.toLowerCase();
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }

    }
