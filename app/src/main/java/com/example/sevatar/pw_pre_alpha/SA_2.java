package com.example.sevatar.pw_pre_alpha;
import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;


public class SA_2 extends AppCompatActivity {
   public    String dir = "storage/emulated/0/Download/";
   public    String ext = ".pdf";
   public    String ext1 = ".txt";
   private ImageView anim,anim1;

    private ListView list;
 //   private static String [] files2 = new String[] {};
    public static   List<String> files1 = new ArrayList<String>();
    public static   List<String> files2 = new ArrayList<String>();
    public static   List<String> files = new ArrayList<String>();
    ImageView r1,r2,r3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_2);
            findFiles(dir, ext);
            findFiles1(dir, ext1);
             list1();
        r1 = (ImageView)findViewById(R.id.wall2);
        r2 = (ImageView)findViewById(R.id.wall3);
        r3 = (ImageView)findViewById(R.id.wall4);
        anim23();

//             anim = (ImageView)findViewById(R.id.imageView5);
//             anim1 = (ImageView)findViewById(R.id.imageView6);

    //anima(); //запуск анимации



    }


    public void list1() {                            //сюда список выводится список файлов
 Integer i = 0;
 Integer j = 0;
 Integer count1 = 0;
 Integer count2 = 0;
 String c1 = " ";
 String c2 = " ";
 files.clear();;



        String[] filesPDF = new String[files1.size()];
                files1.toArray(filesPDF);
        String[] filesTXT = new String[files2.size()];
        files2.toArray(filesTXT);

        for (i = 0; i < files1.size() ; i++){
            for (j = 0; j < files2.size(); j++){

                count1 = filesPDF[i].length();     //получаем название pdf файла без расширения
                count2 = filesTXT[j].length();      //получаем название txt файла без расширения
                c1 = filesPDF[i].substring(0,count1 - 4);
                c2 = filesTXT[j].substring(0,count2 - 4);

                if(c1.equals(c2)) {
                    files.add(filesPDF[i]);
                }

            }
        }


        String[] arc_files = new String[files.size()];
        files.toArray(arc_files);

        list = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.text_colors_lv1, arc_files);
        list.setAdapter(adapter);
        list.setOnItemClickListener(
               new AdapterView.OnItemClickListener() {
                    @Override
                   public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String val = (String) list.getItemAtPosition(i);
                        Integer index;
                        index = val.indexOf(".");                                 // получение длины строки без расширения
                        String n_val = val.substring(0,index) ;

                        Intent intent22 =  new Intent (SA_2.this, SA_2_2.class);
                        intent22.putExtra("fname2",val );
                        intent22.putExtra("fname3", n_val);
                       // intent22.putExtra( )
                        startActivity(intent22);
                            overridePendingTransition(R.anim.alpha_back,R.anim.alpha);


                    }
                }
        );

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent11 = new Intent(SA_2.this, Main2Activity.class);
        // intent22.putExtra( )
        startActivity(intent11);
        finish();
        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
    }





public static void findFiles(String dir, String ext1) {              //функция поиска файлов
    files1.clear();
    File file = new File(dir);
    if(!file.exists())files1.add(dir + " папка не существует");
    File[] listFiles =  file.listFiles(new MyFileNameFilter(ext1));
    if(listFiles.length == 0){
       files1.add(dir + " не содержит файлов с расширением " + ext1);
      }
      else
         // {
         for(File f : listFiles)
             files1.add(f.getName());

    //}
}
    public static   class MyFileNameFilter implements FilenameFilter{          //фильтр по пдф

        private String ext ;

        private MyFileNameFilter(String ext){
            this.ext = ext.toLowerCase();
        }
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }





public void anima() {         //функция анимации
    Drawable drawable1 = anim1.getDrawable();
    if (drawable1 instanceof Animatable){
        ((Animatable) drawable1).start();
    }
    Drawable drawable = anim.getDrawable();
    if (drawable instanceof Animatable){
        ((Animatable) drawable).start();
    }

    ObjectAnimator animation6 = ObjectAnimator.ofFloat(anim, "alpha", 1.0f, 0.0f);
    animation6.setDuration(1);
    animation6.setRepeatCount(0);
    //   animation6.setStartDelay(600);
    animation6.setRepeatMode(ObjectAnimator.RESTART);
    animation6.setInterpolator(new AccelerateDecelerateInterpolator());
    animation6.start();
    //появление
    ObjectAnimator animation1 = ObjectAnimator.ofFloat(anim, "alpha", 0.0f, 1.0f);
    animation1.setDuration(500);
    animation1.setRepeatCount(0);
    animation1.setStartDelay(300);
    animation1.setRepeatMode(ObjectAnimator.RESTART);
    animation1.setInterpolator(new AccelerateDecelerateInterpolator());
    animation1.start();
    //исчезновение
    ObjectAnimator animation2 = ObjectAnimator.ofFloat(anim, "alpha", 1.0f, 0.0f);
    animation2.setDuration(300);
    animation2.setRepeatCount(0);
    animation2.setStartDelay(3000);
    animation2.setRepeatMode(ObjectAnimator.RESTART);
    animation2.setInterpolator(new AccelerateDecelerateInterpolator());
    animation2.start();


    ObjectAnimator animation3 = ObjectAnimator.ofFloat(anim1, "alpha", 1.0f, 0.0f);
    animation3.setDuration(1);
    animation3.setRepeatCount(0);
    animation3.setStartDelay(0);
    animation3.setRepeatMode(ObjectAnimator.RESTART);
    animation3.setInterpolator(new AccelerateDecelerateInterpolator());
    animation3.start();

    ObjectAnimator animation4 = ObjectAnimator.ofFloat(anim1, "alpha", 0.0f, 1.0f);
    animation4.setDuration(300);
    animation4.setRepeatCount(0);
    animation4.setStartDelay(3000);
    animation4.setRepeatMode(ObjectAnimator.RESTART);
    animation4.setInterpolator(new AccelerateDecelerateInterpolator());
    animation4.start();

    ObjectAnimator animation5 = ObjectAnimator.ofFloat(anim1, "alpha", 1.0f, 0.0f);
    animation5.setDuration(1000);
    animation5.setRepeatCount(0);
    animation5.setStartDelay(3000);
    animation5.setRepeatMode(ObjectAnimator.RESTART);
    animation5.setInterpolator(new AccelerateDecelerateInterpolator());
    animation5.start();
}

public void anim23(){
    ObjectAnimator player_right1 = ObjectAnimator.ofFloat(r1, "translationY", 500,-1500); //убираю картинку за экран
    player_right1.setDuration(23000);
    player_right1.setStartDelay(10);
    player_right1.setRepeatMode(ValueAnimator.RESTART);
    player_right1.setRepeatCount(-1);
    player_right1.setInterpolator(new AccelerateDecelerateInterpolator());
    player_right1.start();

    ObjectAnimator player_right2 = ObjectAnimator.ofFloat(r1, "translationX", -100,100); //убираю картинку за экран
    player_right2.setDuration(2400);
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
    scaleDown.setDuration(4500);
    //  scaleDown.setStartDelay(1200);
    scaleDown.start();








    ObjectAnimator player_right3 = ObjectAnimator.ofFloat(r2, "translationY", 500,-1500); //убираю картинку за экран
    player_right3.setDuration(30000);
    player_right3.setStartDelay(10);
    player_right3.setRepeatMode(ValueAnimator.RESTART);
    player_right3.setRepeatCount(-1);
    player_right3.setInterpolator(new AccelerateDecelerateInterpolator());
    player_right3.start();

    ObjectAnimator player_right4 = ObjectAnimator.ofFloat(r2, "translationX", -100,100); //убираю картинку за экран
    player_right4.setDuration(3300);
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
    scaleDown1.setDuration(3200);
    //  scaleDown.setStartDelay(1200);
    scaleDown1.start();










    ObjectAnimator player_right5 = ObjectAnimator.ofFloat(r3, "translationY", 500,-1500); //убираю картинку за экран
    player_right5.setDuration(22000);
    player_right5.setStartDelay(10);
    player_right5.setRepeatMode(ValueAnimator.RESTART);
    player_right5.setRepeatCount(-1);
    player_right5.setInterpolator(new AccelerateDecelerateInterpolator());
    player_right5.start();

    ObjectAnimator player_right6 = ObjectAnimator.ofFloat(r3, "translationX", -100,100); //убираю картинку за экран
    player_right6.setDuration(3500);
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
    scaleDown2.setDuration(2800);
    //  scaleDown.setStartDelay(1200);
    scaleDown2.start();

}

    ////////////////функция поиска надстройки///////////////////////////
    public static void findFiles1(String dir, String ext1) {              //функция поиска файлов
        files2.clear();
        File file = new File(dir);
        if(!file.exists())files2.add(dir + " папка не существует");
        File[] listFiles =  file.listFiles(new MyFileNameFilter1(ext1));
        if(listFiles.length == 0){
            files2.add(dir + " не содержит файлов с расширением " + ext1);
        }
        else
            // {
            for(File f : listFiles)
                files2.add(f.getName());

        //}
    }
    public static   class MyFileNameFilter1 implements FilenameFilter{          //фильтр по txt

        private String ext1 ;

        private MyFileNameFilter1(String ext1){
            this.ext1 = ext1.toLowerCase();
        }
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext1);
        }
    }



}







