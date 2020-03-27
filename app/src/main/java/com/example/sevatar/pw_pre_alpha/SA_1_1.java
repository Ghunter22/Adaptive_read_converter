package com.example.sevatar.pw_pre_alpha;

import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.print.PageRange;
import android.print.pdf.PrintedPdfDocument;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class SA_1_1 extends AppCompatActivity implements OnPageChangeListener,OnLoadCompleteListener,OnPageScrollListener,OnTapListener {
    // private Button btn123;
    //TextView textView;
    private Button btnVid, btnIm, btnWs, btnTxt, btnDel;
    public    String dir = "storage/emulated/0/Download/";
    Integer pageNumber = 0;
    Integer check = 0;
    Integer PageCount;
    Integer i =0;
    String del= "____";
    String mail = "arc.mobile.help@gmail.com";
    String code = "325325";
    Integer doubles = 0;
    Integer hg=2;
    Integer hg2=0;
    Integer black_time = 13;
    Integer k =0;
    Integer j =0;
    Integer h =0;
    Integer ind_count = 0;
    Integer PC= 0;

  //  Integer ind_count = 0;
    PDFView pdfView;
    boolean ch = false;
    String count[] = new String[4];
    String f_name;
    ArrayList<String> str1 = new ArrayList<String>();   //массив для считывания
    ArrayList<String> grn = new ArrayList<String>(); //массив для записи
    ImageView vv,vp,timer,green,shield;
   // Integer PC=0;
    public String[][] all_info;    //объявление массива вне функций



    //Integer pages;
    public void addListenerOnButton() {
        btnVid = (Button) findViewById(R.id.butVid);
        btnIm = (Button) findViewById(R.id.butIm);
        btnWs = (Button) findViewById(R.id.butWs);
        btnTxt = (Button) findViewById(R.id.butTxt);
        btnVid.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent51 = new Intent(SA_1_1.this, ADD_VIDEO.class);
                        intent51.putExtra("page_count", String.valueOf(pageNumber));
                        intent51.putExtra("f_name", f_name);
                      //  intent51.putExtra("fname2", n_val);
                        startActivity(intent51);
                        overridePendingTransition(R.anim.diagonaltranslate2,R.anim.alpha);

                    }
                }
        );
        btnIm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent52 = new Intent(SA_1_1.this, ADD_IMAGE.class);
                        intent52.putExtra("page_count", String.valueOf(pageNumber));
                        intent52.putExtra("f_name", f_name);
                        startActivity(intent52);
                        overridePendingTransition(R.anim.diagonaltranslate2,R.anim.alpha);

                    }
                }
        );
        btnWs.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent53 = new Intent(SA_1_1.this, ADD_WS.class);
                        intent53.putExtra("page_count", String.valueOf(pageNumber));
                        intent53.putExtra("f_name", f_name);
                        startActivity(intent53);
                        overridePendingTransition(R.anim.diagonaltranslate2,R.anim.alpha);

                    }
                }
        );
        btnTxt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent54 = new Intent(SA_1_1.this, ADD_TEXT.class);
                        intent54.putExtra("page_count", String.valueOf(pageNumber));
                        intent54.putExtra("f_name", f_name);
                        startActivity(intent54);
                        overridePendingTransition(R.anim.diagonaltranslate2,R.anim.alpha);

                    }
                }
        );
        btnDel = (Button) findViewById(R.id.butDel);
        btnDel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(SA_1_1.this);
                        a_builder.setMessage("Вы действительно хотите удалить надстройку страницы?")
                                .setCancelable(false)
                                .setPositiveButton("Удалить", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                     delee();
                                   //  aa();
                                     //  rd1();
                                 //    fileExists(dir + f_name + ".txt");

                                    }
                                })

                                .setNeutralButton("Удалить все надстройки", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        File nFile = new File(dir+f_name+".txt");
                                        nFile.delete();
                                        grn.clear();
                                        aa();
                                        Toast.makeText(
                                                SA_1_1.this ,"Все надстройки удалены" ,
                                                Toast.LENGTH_SHORT)
                                                .show();
                                        File file = new File(dir +"arc_z"+f_name + ".txt");
                                        file.delete();
                                    }
                                })
                                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert1 = a_builder.create();
                        alert1.setTitle("Удаление надстроек");
                        alert1.show();
                    }
                }
        );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sa_1_1);
        Intent intent11 = getIntent();
       // PrintedPdfDocument document = new PrintedPdfDocument(context,);
        String fName = intent11.getStringExtra("fname1");
        String fName1 = intent11.getStringExtra("fname2");
        f_name = fName1;
        File pdfFileName = new File(dir,fName);


        vv = (ImageView)findViewById(R.id.del_arc);
        vv.setVisibility(View.INVISIBLE);

        timer = (ImageView)findViewById(R.id.timer);  // открываем панель таймера
        green = (ImageView)findViewById(R.id.green1);
        shield = (ImageView)findViewById(R.id.shield);
        green.setClickable(true);


        ObjectAnimator animation12 = ObjectAnimator.ofFloat(green, "alpha", 0f,0f);
        animation12.setDuration(1);
        animation12.setInterpolator(new AccelerateDecelerateInterpolator());
        animation12.start();


       // grn.clear();
        Drawable drawable1 = timer.getDrawable();
        if (drawable1 instanceof Animatable){
            ((Animatable) drawable1).start();
        }

        green.setOnClickListener(new View.OnClickListener() {     //тут выполняется запись или удаление выделения
            @Override
            public void onClick(View v) {
               boolean hog = true;
                for(i = 0; i < grn.size(); i++) {           //цикл по всей длине листа
                    if (grn.get(i).equals(String.valueOf(pageNumber))) {   //если в листе содержится номер страницы, такой же как текущий
                        grn.remove(String.valueOf(pageNumber));                                    //удаляем его
                        hog =false;
                        anm2();
                        hg=2;
                        break;
                        //выключить анимацию
                    }
                }
                if(hog) {
                    hg=1;
                    grn.add(String.valueOf(pageNumber));//если нет, то записываем
                    anm1();


                }


                        //включить анимацию знака

             // при смене страницы проверять, содержит ли лист важную страницу, если да, включить анимацию, еслит нет, выключить
            }
        });


        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent54 = new Intent(SA_1_1.this, SA_1_1_5.class);
                intent54.putExtra("page_count", "-1");
                intent54.putExtra("f_name", f_name);
                startActivity(intent54);
                overridePendingTransition(R.anim.diagonaltranslate2,R.anim.alpha);

            }
        });

        fileExists(dir + f_name + ".txt");
        if(ch){

        } else {
            shield.setClickable(false);
            shield.setVisibility(View.INVISIBLE);
        }

        shield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent54 = new Intent(SA_1_1.this, code_check.class);
               // intent54.putExtra("page_count", "-1");
                intent54.putExtra("f_name", f_name);
                startActivity(intent54);
                overridePendingTransition(R.anim.diagonaltranslate2,R.anim.alpha);

            }
        });

//        vp = (ImageView)findViewById(R.id.portal);
//        vp.setVisibility(View.INVISIBLE);

//        Drawable drawable1 = vv.getDrawable();
//        if (drawable1 instanceof Animatable){
//            ((Animatable) drawable1).start();
//        }

        pdfView = (PDFView) findViewById(R.id.pdfView);
       // pages =  pdfView.getPageCount();
        pdfView.fromFile(pdfFileName)
                .scrollHandle(new DefaultScrollHandle(this))
                //   .enableSwipe(true)
                  .onLoad(this)
                //.defaultPage(pageNumber)
                .onPageChange(this)
                .onPageScroll(this)
                .onTap(this)
                .load();
        //rd1();
        addListenerOnButton();

    }


public void aa() {
    vv.setVisibility(View.VISIBLE);
    Drawable drawable1 = vv.getDrawable();
    if (drawable1 instanceof Animatable){
        ((Animatable) drawable1).start();
    }
//                                        Drawable drawable = vp.getDrawable();
//                                        if (drawable instanceof Animatable){
//                                            ((Animatable) drawable).start();
//
//
//                                     }
    ObjectAnimator animation4 = ObjectAnimator.ofFloat(vv, "alpha", 0.0f, 1.0f);
    animation4.setDuration(600);
    animation4.setRepeatCount(0);
//    animation4.setStartDelay(1100);
    animation4.setRepeatMode(ObjectAnimator.RESTART);
    animation4.setInterpolator(new AccelerateDecelerateInterpolator());
    animation4.start();



    ObjectAnimator animation2 = ObjectAnimator.ofFloat(vv, "alpha", 1.0f, 0.0f);
    animation2.setDuration(800);
    animation2.setRepeatCount(0);
    animation2.setStartDelay(1100);
    animation2.setRepeatMode(ObjectAnimator.RESTART);
    animation2.setInterpolator(new AccelerateDecelerateInterpolator());
    animation2.start();

    ObjectAnimator animation3 = ObjectAnimator.ofFloat(vv, "alpha", 0.0f, 1.0f);
    animation3.setDuration(10);
    animation3.setRepeatCount(0);
    animation3.setStartDelay(2250);
    animation3.setRepeatMode(ObjectAnimator.RESTART);
    animation3.setInterpolator(new AccelerateDecelerateInterpolator());
    animation3.start();

    ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(vv,
            PropertyValuesHolder.ofFloat("scaleX", 0.1f),
            PropertyValuesHolder.ofFloat("scaleY", 0.1f));
    scaleDown.setDuration(600);
    scaleDown.setStartDelay(1200);
    scaleDown.start();

    ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(vv,
            PropertyValuesHolder.ofFloat("scaleX", 1.0f),
            PropertyValuesHolder.ofFloat("scaleY", 1.0f));
    scaleDown1.setDuration(10);
    scaleDown1.setStartDelay(2250);
    scaleDown1.start();
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


    public void rd1() {
        try {
            FileInputStream fstream = new FileInputStream(dir + f_name + ".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                PC = PC + 1;                             //количество строк в файле содержащем данные надстройки

            }

            br.close();
            fstream.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }



public void delee() { /////функция удаления надстройки только на текущей странице
    PC = 0;
    doubles = 0;
    check = 0;
    str1.clear();
    fileExists(dir + f_name + ".txt"); //проверка существования файла
    if (ch) {

        rd1(); // подсчет количества записей в файле

////////////////////////////////////////////////////нашел количество записей в текущий момент////////////////

        try {
            FileInputStream fstream = new FileInputStream(dir + f_name + ".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                str1.add(strLine);               //тут надо считывать в массив

            }
            br.close();
            fstream.close();
        } catch (IOException e1) {
            e1.printStackTrace();

        }
        if (str1.size() > 0) {

            ////////////////////////////////// считываем все записи файла в лист/////////////


            String[] n_arr_info = new String[str1.size()];        //преобразуем лист в массив стринг
            str1.toArray(n_arr_info);
            all_info = new String[PC][4];
            //  String[][] all_info = new String[PC][4];         //-1 т.к. PC показывает точно количество записей
            for (i = 0; i < PC; i++) {                             //циклы получения данных из листа в массив
                ind_count = n_arr_info[i].indexOf("____");
                all_info[i][0] = n_arr_info[i].substring(0, ind_count); //вытаскиваю номер страницы

                n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);
                all_info[i][1] = n_arr_info[i].substring(0, 1); //вытаскиваю тип надстройки
                n_arr_info[i] = n_arr_info[i].substring(5);

                ind_count = n_arr_info[i].indexOf("____"); //получаю индекс конца ссылки
                all_info[i][2] = n_arr_info[i].substring(0, ind_count); //записал ссылку
                n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);
                all_info[i][3] = n_arr_info[i]; // получил коментарий создателя

            }

            /// сортировка данных массива по номеру страницы
            for (k = 0; k < PC - 1; k++) {
                for (h = 0; h < PC - k - 1; h++) {
                    if (Integer.parseInt(all_info[h][0]) > Integer.parseInt(all_info[h + 1][0])) {
                        // меняем элементы местами
                        count[0] = all_info[h][0];          //сортировка методом пузырька, дбликаты идут по возрастанию друг за другом, последний дубликат - последние данные
                        count[1] = all_info[h][1];
                        count[2] = all_info[h][2];
                        count[3] = all_info[h][3];
                        all_info[h][0] = all_info[h + 1][0];
                        all_info[h][1] = all_info[h + 1][1];
                        all_info[h][2] = all_info[h + 1][2];
                        all_info[h][3] = all_info[h + 1][3];
                        all_info[h + 1][0] = count[0];
                        all_info[h + 1][1] = count[1];
                        all_info[h + 1][2] = count[2];
                        all_info[h + 1][3] = count[3];
                    }

                }
            }
            for (h = 0; h < PC - 1; h++) {
                if (Integer.parseInt(all_info[h][0]) == Integer.parseInt(all_info[h + 1][0])) {
                    doubles = doubles + 1;             //поиск количества дубликатов

                }
            }
            String end_all_info[][];
            end_all_info = new String[PC - doubles][4]; // финальный массив с последними данными
            j = 0;
            for (h = 0; h < PC - 1; h++) {
                if (Integer.parseInt(all_info[h][0]) != Integer.parseInt(all_info[h + 1][0])) {
                    end_all_info[j][0] = all_info[h][0];        // тут выполняется проверка, если в отсортированном массиве по возрастанию
                    end_all_info[j][1] = all_info[h][1];      // меняется номер страницы, то тогда данные записываются с финальный массив
                    end_all_info[j][2] = all_info[h][2];
                    end_all_info[j][3] = all_info[h][3];
                    j = j + 1;

                }

            }
            end_all_info[PC - doubles - 1][0] = all_info[PC - 1][0];    //перезапись данных последней надстройки
            end_all_info[PC - doubles - 1][1] = all_info[PC - 1][1];
            end_all_info[PC - doubles - 1][2] = all_info[PC - 1][2];
            end_all_info[PC - doubles - 1][3] = all_info[PC - 1][3];

            String del_info[][];

            if (PC - doubles - 1 != 0) {
                del_info = new String[PC - doubles - 1][4]; //массив, в котором не содержится удаляемая надстройка
                h = 0;


                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//        Toast.makeText(
//                SA_1_1.this, end_all_info[0][1] + "   " + Integer.toString(pageNumber),
//                Toast.LENGTH_SHORT)
//                .show();

                for (i = 0; i < PC - doubles; i++) {
                    if (end_all_info[i][0].equals(Integer.toString(pageNumber))) {
                        // пропускаем запись удаляемой надстройки
                    } else {
                        if (h == PC - doubles-1) {     // проверка, если количество данных в обоих массивах совпадает, значит надстройки на этой странице нет
                            /// выходим из цикла и ничего не делаем

                            check = 1; //присваиваем 1, если не нашли нужную надстройку для удаления

                            break;
                        } else {
                            del_info[h][0] = end_all_info[i][0];     //заполнил массив всеми надстройками, кроме надстройки текущей страницы
                            del_info[h][1] = end_all_info[i][1];
                            del_info[h][2] = end_all_info[i][2];
                            del_info[h][3] = end_all_info[i][3];
                            h++;
                        }

                    }
                }

                if (check == 0) {      // если перезапись прошла успешно
                    try {
                        FileWriter writer = new FileWriter(dir + f_name + ".txt", false);

                        for (i = 0; i < PC - doubles - 1; i++) {
                            writer.write(del_info[i][0] + del + del_info[i][1] + del + del_info[i][2] + del + del_info[i][3] + '\n'); // не забывай знак новой строки
                            //  writer.write(a_info.get(0)+'\n');
                        }
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    Toast.makeText(
                            SA_1_1.this, "Со страницы " + Integer.toString(pageNumber + 1) + " удалена надстройка",
                            Toast.LENGTH_SHORT)
                            .show();
                    aa();
                    File file = new File(dir +"arc_z"+f_name + ".txt");
                    file.delete();
                    // del_info[][].clear();
                } else {
                    Toast.makeText(
                            SA_1_1.this, "Надстройки не найдены",
                            Toast.LENGTH_SHORT)
                            .show();
                }

            } else {
                // если в файлах только одна запись

                if (end_all_info[0][0].equals(Integer.toString(pageNumber))) {
                    try {
                        FileWriter writer = new FileWriter(dir + f_name + ".txt", false);

                        for (i = 0; i < PC - doubles - 1; i++) {
                            //   writer.write(del_info[i][0] + del + del_info[i][1] + del + del_info[i][2] + del + del_info[i][3] + '\n'); // не забывай знак новой строки
                            //  writer.write(a_info.get(0)+'\n');
                        }
                        writer.close();
                        File file325 = new File(dir + f_name + ".txt");
                        file325.delete();
                        File file = new File(dir +"arc_z"+f_name + ".txt"); //удаление файла о прогрессе
                        file.delete();
                        // ВОТ СЮДА ВСТАВИТЬ СТРОЧКУ УДАЛЕНИЯ ВСЕГО ФАЙЛА
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    aa();
//                    Toast.makeText(
//                            SA_1_1.this, "Со страницы " + Integer.toString(pageNumber + 1) + " удалена надстройка",
//                            Toast.LENGTH_SHORT)
//                            .show();
                }



            }


        } else {
            Toast.makeText(
                    SA_1_1.this, "Надстройки не найдены",
                    Toast.LENGTH_SHORT)
                    .show();


        }

    }

    else {
        Toast.makeText(
                SA_1_1.this, "Надстройки не найдены",
                Toast.LENGTH_SHORT)
                .show();


    }

}











    @Override
    public void loadComplete(int nbPages) {
               PageCount = nbPages; //всего страниц
        PC = 0;
        str1.clear();
        grn.clear();
        //заполнить массив grn элементами из файла
        //открываем файл
        fileExists(dir + f_name + ".txt"); //проверка существования файла
        if (ch) {

            rd1(); // подсчет количества записей в файле

////////////////////////////////////////////////////нашел количество записей в текущий момент////////////////

            try {
                FileInputStream fstream = new FileInputStream(dir + f_name + ".txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    str1.add(strLine);               //тут надо считывать в массив

                }
                br.close();
                fstream.close();
            } catch (IOException e1) {
                e1.printStackTrace();

            }
            if (str1.size() > 0) {
                ////////////////////////////////// считываем все записи файла в лист/////////////


                String[] n_arr_info = new String[str1.size()];        //преобразуем лист в массив стринг
                str1.toArray(n_arr_info);
                all_info = new String[PC][4];
                //  String[][] all_info = new String[PC][4];         //-1 т.к. PC показывает точно количество записей
                for (i = 0; i < PC; i++) {                             //циклы получения данных из листа в массив
                    ind_count = n_arr_info[i].indexOf("____");
                    all_info[i][0] = n_arr_info[i].substring(0, ind_count); //вытаскиваю номер страницы

                    n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);
                    all_info[i][1] = n_arr_info[i].substring(0, 1); //вытаскиваю тип надстройки
                    n_arr_info[i] = n_arr_info[i].substring(5);

                    ind_count = n_arr_info[i].indexOf("____"); //получаю индекс конца ссылки
                    all_info[i][2] = n_arr_info[i].substring(0, ind_count); //записал ссылку
                    n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);
                    all_info[i][3] = n_arr_info[i]; // получил коментарий создателя

                }

                /// сортировка данных массива по номеру страницы
                for (k = 0; k < PC - 1; k++) {
                    for (h = 0; h < PC - k - 1; h++) {
                        if (Integer.parseInt(all_info[h][0]) > Integer.parseInt(all_info[h + 1][0])) {
                            // меняем элементы местами
                            count[0] = all_info[h][0];          //сортировка методом пузырька, дбликаты идут по возрастанию друг за другом, последний дубликат - последние данные
                            count[1] = all_info[h][1];
                            count[2] = all_info[h][2];
                            count[3] = all_info[h][3];
                            all_info[h][0] = all_info[h + 1][0];
                            all_info[h][1] = all_info[h + 1][1];
                            all_info[h][2] = all_info[h + 1][2];
                            all_info[h][3] = all_info[h + 1][3];
                            all_info[h + 1][0] = count[0];
                            all_info[h + 1][1] = count[1];
                            all_info[h + 1][2] = count[2];
                            all_info[h + 1][3] = count[3];
                        }

                    }
                }
                for (h = 0; h < PC - 1; h++) {
                    if (Integer.parseInt(all_info[h][0]) == Integer.parseInt(all_info[h + 1][0])) {
                        doubles = doubles + 1;             //поиск количества дубликатов

                    }
                }
                String end_all_info[][];
                end_all_info = new String[PC - doubles][4]; // финальный массив с последними данными
                j = 0;
                for (h = 0; h < PC - 1; h++) {
                    if (Integer.parseInt(all_info[h][0]) != Integer.parseInt(all_info[h + 1][0])) {
                        end_all_info[j][0] = all_info[h][0];        // тут выполняется проверка, если в отсортированном массиве по возрастанию
                        end_all_info[j][1] = all_info[h][1];      // меняется номер страницы, то тогда данные записываются с финальный массив
                        end_all_info[j][2] = all_info[h][2];
                        end_all_info[j][3] = all_info[h][3];
                        j = j + 1;

                    }

                }
                end_all_info[PC - doubles - 1][0] = all_info[PC - 1][0];    //перезапись данных последней надстройки
                end_all_info[PC - doubles - 1][1] = all_info[PC - 1][1];
                end_all_info[PC - doubles - 1][2] = all_info[PC - 1][2];
                end_all_info[PC - doubles - 1][3] = all_info[PC - 1][3];



                 String jk,jk2;
                 Integer idx=0;
                for(i=0; i<PC-doubles;i++){
                    if(end_all_info[i][0].equals("-1")){
                        if(end_all_info[i][2].equals("null")) {
                             break;
                        }
                        else{
                            jk = end_all_info[i][2];
//
//                            Toast.makeText(
//                                    SA_1_1.this ,jk ,
//                                    Toast.LENGTH_SHORT)
//                                    .show();


                            do{
                                jk=jk.substring(3);
                                idx = jk.indexOf("|||");
                                if(idx==-1) {
//                                    grn.add(jk);

                                    break;
                                }
                                else {

//                                    Toast.makeText(
//                                            SA_1_1.this ,jk.substring(0,idx) ,
//                                            Toast.LENGTH_SHORT)
//                                            .show();
                                    grn.add(jk.substring(0,idx));
                                    jk = jk.substring(idx); //убрал последнее число

                                }
                            } while (idx!=-1);

                       break;
                        }

                    }
                }


            }
        }




    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page; //текущая страница
        hg2=2;
 //       PageCount = pageCount; //всего страниц
        for(i = 0; i < grn.size(); i++) {           //цикл по всей длине листа
            if (grn.get(i).equals(String.valueOf(pageNumber))) {   //если в листе содержится номер страницы, такой же как текущий

                hg2 = 1;          // если на этой странице должно быть включено
                break;
            }
        }

        if(hg==1){
            if(hg2==1){

            }
            if(hg2==2){
                anm2();
               hg =2;
            }
        }

       else{
            if(hg2==1){
                anm1();
                hg =1;
            }
            if(hg2==2){

            }
        }

        }
public void anm1(){
    ObjectAnimator animation3 = ObjectAnimator.ofFloat(green, "alpha", 0.0f, 1.0f);
    animation3.setDuration(300);
    animation3.setInterpolator(new AccelerateDecelerateInterpolator());
    animation3.start();
}
    public void anm2(){
        ObjectAnimator animation3 = ObjectAnimator.ofFloat(green, "alpha", 1.0f, 0.0f);
        animation3.setDuration(300);
        animation3.setInterpolator(new AccelerateDecelerateInterpolator());
        animation3.start();
    }


    @Override
    public void onPageScrolled(int page, float positionOffset) {
        //  textView.setText(pageNumber);
    }

    @Override
    public boolean onTap(MotionEvent e) {

//             }
        return false;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String cot1 = "";
        String cot = "";
        String last_time = "-1____f____null____13";
        String end1;
        String end2 = "|||";
//        grn.add("arc.help.mobile@gmail.com");
//        grn.add("325325325");
//        grn.remove(0);
//        grn.remove(0);


        ArrayList<String> l_info = new ArrayList<String>(); //массив для записи


        fileExists(dir + f_name + ".txt"); //проверка существования файла
        if (ch) {
            PC = 0;
            rd1(); // подсчет количества записей в файле

            try {
                FileInputStream fstream = new FileInputStream(dir + f_name + ".txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    l_info.add(strLine);               //тут надо считывать в массив

                }
                br.close();
                fstream.close();
            } catch (IOException e1) {
                e1.printStackTrace();

            }

            Integer faith = 0;
            for (i = 0; i < PC; i++) {                 //вытаскиваю время
                cot1 = l_info.get(i).substring(0, 2);
                if (cot1.equals("-1")) {
                    faith = 1;

                }
            }

            if (faith == 1) {
                for (i = 0; i < PC; i++) {                 //вытаскиваю время
                    cot1 = l_info.get(i).substring(0, 2);
                    if (cot1.equals("-1")) {
                        cot = l_info.get(i);

                    }
                }
            String tm;
            cot = cot.substring(11);
            Integer ind = cot.indexOf("____") + 4;
            cot = cot.substring(ind);
            /////////////////////////////
            ind = cot.indexOf("|||");
            tm = cot.substring(0, ind);
            black_time = Integer.valueOf(tm);      //время таймера
            ///вытаскиваю почту
            cot = cot.substring(ind);
            cot = cot.substring(3);
            ind = cot.indexOf("|||");
            mail = cot.substring(0, ind);
            //////////вытаскиваю код доступа
            cot = cot.substring(ind);
            cot = cot.substring(3);
            code = cot;
//
//            Toast.makeText(
//                    SA_1_1.this ,String.valueOf(black_time) + "  " + mail + "  " + code ,
//                    Toast.LENGTH_SHORT)
//                    .show();

        } else  {
                black_time = 13;
                mail = "arc.mobile.help@gmail.com";
                code = "sevatar";

            }


        }














        if (grn.size() != 0) {
            for (i = 0; i < grn.size(); i++) {
                end1 = grn.get(i);
                end2 = end2 + end1 + "|||";
            }
            grn.clear();


            //   last_time = "-1" + del + "f" + del + end2 + del + black_time;
//
//                try {
//                    FileWriter writer = new FileWriter(dir + f_name + ".txt", true);     //работает норм
//                    writer.write(last_time + '\n'); // не забывай знак новой строки
//                    //  writer.write(a_info.get(0)+'\n');
//                    writer.close();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }

                PC = 0;
                doubles = 0;
                check = 0;
                str1.clear();
                fileExists(dir + f_name + ".txt"); //проверка существования файла
                if (ch) {

                    rd1(); // подсчет количества записей в файле

////////////////////////////////////////////////////нашел количество записей в текущий момент////////////////

                    try {
                        FileInputStream fstream = new FileInputStream(dir + f_name + ".txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                        String strLine;
                        while ((strLine = br.readLine()) != null) {
                            str1.add(strLine);               //тут надо считывать в массив

                        }
                        br.close();
                        fstream.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();

                    }
                    if (str1.size() > 0) {

/////////////////////////////////////////////////////// считываем все записи файла в лист/////////////


                        String[] n_arr_info = new String[str1.size()];        //преобразуем лист в массив стринг
                        str1.toArray(n_arr_info);
                        all_info = new String[PC][4];
                        //  String[][] all_info = new String[PC][4];         //-1 т.к. PC показывает точно количество записей
                        for (i = 0; i < PC; i++) {                             //циклы получения данных из листа в массив
                            ind_count = n_arr_info[i].indexOf("____");
                            all_info[i][0] = n_arr_info[i].substring(0, ind_count); //вытаскиваю номер страницы

                            n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);
                            all_info[i][1] = n_arr_info[i].substring(0, 1); //вытаскиваю тип надстройки
                            n_arr_info[i] = n_arr_info[i].substring(5);

                            ind_count = n_arr_info[i].indexOf("____"); //получаю индекс конца ссылки
                            all_info[i][2] = n_arr_info[i].substring(0, ind_count); //записал ссылку
                            n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);
                            all_info[i][3] = n_arr_info[i]; // получил коментарий создателя

                        }

                        /// сортировка данных массива по номеру страницы
                        for (k = 0; k < PC - 1; k++) {
                            for (h = 0; h < PC - k - 1; h++) {
                                if (Integer.parseInt(all_info[h][0]) > Integer.parseInt(all_info[h + 1][0])) {
                                    // меняем элементы местами
                                    count[0] = all_info[h][0];          //сортировка методом пузырька, дбликаты идут по возрастанию друг за другом, последний дубликат - последние данные
                                    count[1] = all_info[h][1];
                                    count[2] = all_info[h][2];
                                    count[3] = all_info[h][3];
                                    all_info[h][0] = all_info[h + 1][0];
                                    all_info[h][1] = all_info[h + 1][1];
                                    all_info[h][2] = all_info[h + 1][2];
                                    all_info[h][3] = all_info[h + 1][3];
                                    all_info[h + 1][0] = count[0];
                                    all_info[h + 1][1] = count[1];
                                    all_info[h + 1][2] = count[2];
                                    all_info[h + 1][3] = count[3];
                                }

                            }
                        }
                        for (h = 0; h < PC - 1; h++) {
                            if (Integer.parseInt(all_info[h][0]) == Integer.parseInt(all_info[h + 1][0])) {
                                doubles = doubles + 1;             //поиск количества дубликатов

                            }
                        }

                        String end_all_info[][];
                        end_all_info = new String[PC - doubles][4]; // финальный массив с последними данными
                        j = 0;
                        for (h = 0; h < PC - 1; h++) {
                            if (Integer.parseInt(all_info[h][0]) != Integer.parseInt(all_info[h + 1][0])) {
                                end_all_info[j][0] = all_info[h][0];        // тут выполняется проверка, если в отсортированном массиве по возрастанию
                                end_all_info[j][1] = all_info[h][1];      // меняется номер страницы, то тогда данные записываются с финальный массив
                                end_all_info[j][2] = all_info[h][2];
                                end_all_info[j][3] = all_info[h][3];
                                j = j + 1;

                            }

                        }
                        end_all_info[PC - doubles - 1][0] = all_info[PC - 1][0];    //перезапись данных последней надстройки
                        end_all_info[PC - doubles - 1][1] = all_info[PC - 1][1];
                        end_all_info[PC - doubles - 1][2] = all_info[PC - 1][2];
                        end_all_info[PC - doubles - 1][3] = all_info[PC - 1][3];

                        String del_info[][];

                        if (PC - doubles > 1) {
                            del_info = new String[PC - doubles][4]; //
                            h = 0;


                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                            for (i = 0; i < PC - doubles; i++) {     //находим старую запись и меняем ее на новую
                                if (end_all_info[i][0].equals("-1")) {

                                    del_info[h][0] = "-1";
                                    del_info[h][1] = "F";
                                    del_info[h][2] = end2;
                                    del_info[h][3] = String.valueOf(black_time);
                                    del_info[h][3] =  del_info[h][3] +"|||"+mail+"|||"+code;
                                    h++;
//                                    Toast.makeText(
//                        SA_1_1.this, del_info[h][0] + del_info[h][1] + del_info[h][2] + del_info[h][3],
//                        Toast.LENGTH_SHORT)
//                        .show();

                                } else {

                                    del_info[h][0] = end_all_info[i][0];     //заполнил массив всеми надстройками, кроме надстройки текущей страницы
                                    del_info[h][1] = end_all_info[i][1];
                                    del_info[h][2] = end_all_info[i][2];
                                    del_info[h][3] = end_all_info[i][3];
                                    h++;
                                }
                            }

                            try {
                                FileWriter writer = new FileWriter(dir + f_name + ".txt", false);

                                for (i = 0; i < PC - doubles; i++) {
                                    writer.write(del_info[i][0] + del + del_info[i][1] + del + del_info[i][2] + del + del_info[i][3] + '\n'); // не забывай знак новой строки
                                    //  writer.write(a_info.get(0)+'\n');
                                }
                                writer.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                        else {   //если в файле только одна запись, то перезаписываем данные
                            try {
                                FileWriter writer = new FileWriter(dir + f_name + ".txt", false);


                                    writer.write( "-1____f____"+end2+"____"+black_time+"|||"+mail+"|||"+code+ '\n'); // не забывай знак новой строки
                                    //  writer.write(a_info.get(0)+'\n');
                                writer.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }

//                } else {
//                    // если в файлах только одна запись
//
//                    if (end_all_info[0][0].equals(Integer.toString(pageNumber))) {
//                        try {
//                            FileWriter writer = new FileWriter(dir + f_name + ".txt", false);
//
//                            for (i = 0; i < PC - doubles - 1; i++) {
//                                //   writer.write(del_info[i][0] + del + del_info[i][1] + del + del_info[i][2] + del + del_info[i][3] + '\n'); // не забывай знак новой строки
//                                //  writer.write(a_info.get(0)+'\n');
//                            }
//                            writer.close();
//                            File file325 = new File(dir + f_name + ".txt");
//                            file325.delete();
//                            // ВОТ СЮДА ВСТАВИТЬ СТРОЧКУ УДАЛЕНИЯ ВСЕГО ФАЙЛА
//                        } catch (IOException e1) {
//                            e1.printStackTrace();
//                        }
//                        aa();
//                    Toast.makeText(
//                            SA_1_1.this, "Со страницы " + Integer.toString(pageNumber + 1) + " удалена надстройка",
//                            Toast.LENGTH_SHORT)
//                            .show();
                       // }


                    }


//            } else {
//                Toast.makeText(
//                        SA_1_1.this, "Надстройки не найдены",
//                        Toast.LENGTH_SHORT)
//                        .show();
//
//
//            }
//
//        }
//
//        else {
//            Toast.makeText(
//                    SA_1_1.this, "Надстройки не найдены",
//                    Toast.LENGTH_SHORT)
//                    .show();
//
//
//        }


                } else {

                    last_time = "-1____f____"+end2+"____"+black_time+"|||"+mail+"|||"+code;
                    try {
                        FileWriter writer = new FileWriter(dir + f_name + ".txt", false);     //работает норм
                        writer.write(last_time + '\n'); // не забывай знак новой строки
                        //  writer.write(a_info.get(0)+'\n');
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }


                }

            } else {            //если  файла с надстройками нет

//
                last_time = "-1____f____null____"+black_time+"|||"+mail+"|||"+code;
                try {
                    FileWriter writer = new FileWriter(dir + f_name + ".txt", true);     //работает норм
                    writer.write(last_time + '\n'); // не забывай знак новой строки
                    //  writer.write(a_info.get(0)+'\n');
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
            //открываем файл
            //считываем все в лист
            //находим надстройки -1
            //вытаскиваем значение таймера

//        } else {
//
//            finish();
//            overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
//            last_time = "-1____f____null____"+black_time;
//
//            try {
//                FileWriter writer = new FileWriter(dir + f_name + ".txt", true);     //работает норм
//                writer.write(last_time + '\n'); // не забывай знак новой строки
//                //  writer.write(a_info.get(0)+'\n');
//                writer.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }

        ////////////////////////////////////перезаписываем данные о времени и важных страницах/////////////////


        Intent Intent1 = new Intent(".SA_1");
        startActivity(Intent1);

        finish();
        overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
    }

}
