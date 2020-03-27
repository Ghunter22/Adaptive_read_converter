package com.example.sevatar.pw_pre_alpha;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SA_2_2 extends AppCompatActivity implements OnPageChangeListener,OnLoadCompleteListener,OnPageScrollListener,OnTapListener {
    // private Button btn123;
    //TextView textView;
    public String dir = "storage/emulated/0/Download/";
    Integer pageNumber = 0;
    PDFView pdfView;
    Integer PC = 0;
    Integer hg=2;
    Integer hg2=0;
    Integer doubles = 0;
    Integer jack = -40;
    Integer now_page = 0;
    String f_name;
    String mail = "arc.mobile.help@gmail.com";
    String code = "325325";
    String code2 = "";
    Integer urizen = 0;
    Integer PageCount;
    Integer Pcdoubles;
    Integer m_chk =0;
    Integer s_p_c = 0;
    Integer s_d_c = 0;
    Integer def_page = 0;
    Integer SSDelay = 0;
    Double progress = 0.0;
    Long all_time = 0L;
    ProgressBar pb;
    Double bar = 0.0;
    String fName;
    Integer info_check[][]; // массив для проверки, была ли прочтена страница
    Integer info_check2[][]; // массив для проверки, была ли прочтена надстройка
    Integer save_info_check[][]; // массив для проверки, была ли прочтена страница
    Integer save_info_check2[][]; // массив для проверки, была ли прочтена надстройка
    private ImageView anim2,anim,n1,n2,anim3,anim4,green1,mail325,ppl;
    Integer g = 0;
    Integer i = 0;
    private Timer mTimer, mTimer2,mTimer3,mTimer4;
    private MyTimerTask mMyTimerTask;
    private SA_2_2.MyTimerTask2 m2MyTimerTask;
    private SA_2_2.MyTimerTask3 m3MyTimerTask;
    private SA_2_2.MyTimerTask4 m4MyTimerTask;
    Integer j = 0;
    Integer kor = 5; //отслеживание нажатия на уведомление
    Integer cer = 2; // для проверки положения переключателя
    Integer ind_count = 0;
    ArrayList<String> str1 = new ArrayList<String>();   //массив для считывания
    ArrayList<String> str2 = new ArrayList<String>();
    ArrayList<String> grn = new ArrayList<String>();
    ArrayList<String> save_info = new ArrayList<String>();
    String[][] all_info;
    String[] mail2;
    String count[] = new String[4];
    String[][] end_all_info;
    String[][] end_all_info1;
    Integer k, h;
    Switch swch;
    boolean sw = true;
    boolean ch;

    // необходимо хранить массив info_check, info_check2 и последнюю страницу, а так же прогресс бар
    // формат файла хранения - z_arc_имя файла_.txt
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_2_2);
//        if (swch != null) {
//            swch.setChecked();
//        }


        if (mTimer2 != null) {
            mTimer2.cancel();
            mTimer2 = null;
        }
        mTimer2 = new Timer(); //объявляем новый таймер
        m2MyTimerTask = new SA_2_2.MyTimerTask2(); // новая задача таймера
        mTimer2.schedule(m2MyTimerTask, 1800000,1800000);       // задача, задержка

        if (mTimer2 != null) {
            mTimer2.cancel();
            mTimer2 = null;
        }
        mTimer4 = new Timer(); //объявляем новый таймер
        m4MyTimerTask = new SA_2_2.MyTimerTask4(); // новая задача таймера
        mTimer4.schedule(m4MyTimerTask, 0,1000);






        swch = (Switch) findViewById(R.id.swch1);
        swch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {     //отслеживание переключения режима чтения Автоматическое воспроизведение
                if(cer%2 == 0) {

                    if(cer <5) {
                        Toast.makeText(
                                SA_2_2.this, "Автоматическое воспроизведение",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                    cer++;
                    jack++;
                   // pdfView.setNightMode(true);
                }
                else{
                    if(cer <5) {
                        Toast.makeText(
                                SA_2_2.this, "Уведомления включены",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                    cer++;
                    jack++;
                    if (jack >20) {
                        ppl.setVisibility(View.VISIBLE);
                        ppl.setClickable(true); //чтобы нельзя было случайно нажать, пока не работает анимация

                    }
                   // pdfView.setNightMode(false);
                }
            }
        });
        pb = (ProgressBar) findViewById(R.id.progressBar);
     //   pb.setProgressDrawable(getResources().getDrawable(R.drawable.vp));
        anim = (ImageView) findViewById(R.id.anim);  //изображение
        anim2 = (ImageView) findViewById(R.id.anim2);  //видео
        anim3 = (ImageView) findViewById(R.id.anim3);  // сайт
        anim4 = (ImageView) findViewById(R.id.anim4); //текст
        green1 = (ImageView) findViewById(R.id.green12); //текст
        mail325= (ImageView) findViewById(R.id.mail); //текст
        ppl= (ImageView) findViewById(R.id.imageView24); //текст
        n1 = (ImageView) findViewById(R.id.imageView3);
        n2 = (ImageView) findViewById(R.id.imageView4);
        n1.setClickable(true);
        n2.setClickable(false);
        ObjectAnimator animation21 = ObjectAnimator.ofFloat(n2, "alpha", 1.0f, 0.0f);
        animation21.setDuration(1);
        animation21.setInterpolator(new AccelerateDecelerateInterpolator());
        animation21.start();

        ObjectAnimator animation12 = ObjectAnimator.ofFloat(green1, "alpha", 0f,0f);
        animation12.setDuration(1);
        animation12.setInterpolator(new AccelerateDecelerateInterpolator());
        animation12.start();
//
//        anim.setVisibility(View.GONE);
//        anim.setClickable(false);
        mail325.setVisibility(View.INVISIBLE);
        mail325.setClickable(false);
        anim.setVisibility(View.GONE);
        anim.setClickable(false); //чтобы нельзя было случайно нажать, пока не работает анимация
        anim2.setVisibility(View.GONE);
        anim2.setClickable(false); //чтобы нельзя было случайно нажать, пока не работает анимация
        anim3.setVisibility(View.GONE);
        anim3.setClickable(false); //чтобы нельзя было случайно нажать, пока не работает анимация
        anim4.setVisibility(View.GONE);
        anim4.setClickable(false); //чтобы нельзя было случайно нажать, пока не работает анимация
        ppl.setVisibility(View.GONE);
        ppl.setClickable(false); //чтобы нельзя было случайно нажать, пока не работает анимация


        Intent intent22 = getIntent();

        fName = intent22.getStringExtra("fname2");
        f_name = intent22.getStringExtra("fname3");

        //тут код считывания сохраненной инфы
        fileExists(dir+"arc_z"+f_name+".txt");
        if(ch) {
            info_chcker();
            pb.setProgress(bar.intValue());
            if(bar>=90) {
                mail325.setClickable(true);
                mail325.setVisibility(View.VISIBLE);
            }
        }


        /////////////////////////
        File pdfFileName = new File(dir, fName);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromFile(pdfFileName)
                .scrollHandle(new DefaultScrollHandle(this))
                //   .enableSwipe(true)
                .onLoad(this)
                .defaultPage(def_page)
                .onPageChange(this)
                .onPageScroll(this)
                .onTap(this)
                .load();
        rd1();
        //анимация включения найт мода//////////////////////////////////////////////////
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = n1.getDrawable();
                if (drawable instanceof Animatable){
                    ((Animatable) drawable).start();
                }
                n1.setClickable(false);
                n2.setClickable(true);
                ObjectAnimator animation31 = ObjectAnimator.ofFloat(n1, "alpha", 1.0f, 0.0f);
                animation31.setDuration(1);
                animation31.setRepeatCount(0);
                animation31.setStartDelay(500);
                animation31.setRepeatMode(ObjectAnimator.RESTART);
                animation31.setInterpolator(new AccelerateDecelerateInterpolator());
                animation31.start();

                ObjectAnimator animation41 = ObjectAnimator.ofFloat(n2, "alpha", 0.0f, 1.0f);
                animation41.setDuration(1);
                animation41.setRepeatCount(0);
                animation41.setStartDelay(500);
                animation41.setRepeatMode(ObjectAnimator.RESTART);
                animation41.setInterpolator(new AccelerateDecelerateInterpolator());
                animation41.start();
                pdfView.setNightMode(true);
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = n2.getDrawable();
                if (drawable instanceof Animatable){
                    ((Animatable) drawable).start();
                    n2.setClickable(false);
                    n1.setClickable(true);
                    ObjectAnimator animation31 = ObjectAnimator.ofFloat(n2, "alpha", 1.0f, 0.0f);
                    animation31.setDuration(1);
                    animation31.setRepeatCount(0);
                    animation31.setStartDelay(500);
                    animation31.setRepeatMode(ObjectAnimator.RESTART);
                    animation31.setInterpolator(new AccelerateDecelerateInterpolator());
                    animation31.start();

                    ObjectAnimator animation41 = ObjectAnimator.ofFloat(n1, "alpha", 0.0f, 1.0f);
                    animation41.setDuration(1);
                    animation41.setRepeatCount(0);
                    animation41.setStartDelay(500);
                    animation41.setRepeatMode(ObjectAnimator.RESTART);
                    animation41.setInterpolator(new AccelerateDecelerateInterpolator());
                    animation41.start();
                    pdfView.setNightMode(false);

                }
            }
        });
   /////////////////////////////////////////////////////

        mail325.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_mail();
            }
        });

        ppl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent116 = new Intent(SA_2_2.this, game_menu.class);
                //   intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent116);
                overridePendingTransition(R.anim.alpha_back, R.anim.alpha);


            }
        });
    }

    public void rd1() {
        PC = 0;
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


    @Override
    public void loadComplete(int nbPages) {
        firstanim();

           timerCheck();
        // textView.setText(String.valueOf(pageNumber));
         PC = 0;
          rd1();
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
                doubles = doubles + 1;             //поиск количества дубликатов данных на одну страницу

            }
        }
        Pcdoubles = PC - doubles; //количетсво надстроек, не считая записи о времени срабатывания таймера
        end_all_info = new String[PC - doubles][4]; // массив с последними данными содержащий данные о задержке



        if(Pcdoubles > 1){
            end_all_info1 = new String[Pcdoubles-1][4]; //финальный массив надстроек
        }
        else {
            end_all_info1 = new String[Pcdoubles][4]; //финальный массив надстроек
            end_all_info1[0][0] = "9999";
            end_all_info1[0][1] = "f";
            end_all_info1[0][2] = "doom";
            end_all_info1[0][3] = "doom";
        }


        j = 0;
        for (h = 0; h < PC-1; h++) {
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

        PageCount = nbPages; //всего страниц
        // для системы оценки
        progress = 100.0/(Double.valueOf(PageCount) + (Double.valueOf(Pcdoubles)-1.0)); //количество страниц + количество надстроек


        //////////////////////////////////////////////////

        fileExists(dir+"arc_z"+f_name+".txt");
        if(ch && s_p_c == PageCount) {
            info_check = new Integer[PageCount][2];
            for (i = 0; i < PageCount; i++) {
                info_check[i][0] = save_info_check2[i][0];
                info_check[i][1] = save_info_check2[i][1];
            }


        }
        else {

            info_check = new Integer[PageCount][2];
            for (i = 0; i < PageCount; i++) {
                info_check[i][0] = i;
                info_check[i][1] = 0;
            }
        }
        String fst = "-1";
            // поиск информации о задержке перед тем, как программа посчитает что материал был прочтен
        j = 0;
            for(i = 0; i < PC - doubles   ; i++) {
                if(end_all_info[i][0].equals(fst)){

                    ///////////////////////вытащить время в отдельную переменную////
                     ///////////////////////////////////////////////////
                    //////////////////////////////////////
                    /////////////////////////////////////
                    ///////////////////////////////////////
                    /////////////////////////////////////
                    ////////////////////////////////////
                    Integer ind;
                    String tm,cot;
                    ind = end_all_info[i][3].indexOf("|||");
                    tm = end_all_info[i][3].substring(0,ind);
                    Double lorg = Math.sqrt((Integer.parseInt(tm))*(Integer.parseInt(tm)));
                    SSDelay =1000 *lorg.intValue();  //необходимо, чтобы исключить возможность появления отрицательного времени



                    ///вытаскиваю почту
                    cot = end_all_info[i][3].substring(ind);
                    cot = cot.substring(3);
                    ind = cot.indexOf("|||");
                    mail = cot.substring(0,ind);
                    //////////вытаскиваю код доступа
                    cot = cot.substring(ind);
                    cot = cot.substring(3);
                    code = cot;
//
//                    Toast.makeText(
//                            SA_2_2.this, code + "  " + mail,
//                            Toast.LENGTH_LONG)
//                            .show();

                }
                else {
                   // if(Pcdoubles!=0) {
                        end_all_info1[j][0] = end_all_info[i][0];
                        end_all_info1[j][1] = end_all_info[i][1];
                        end_all_info1[j][2] = end_all_info[i][2];
                        end_all_info1[j][3] = end_all_info[i][3];
                        j++;

//                    Toast.makeText(
//                            SA_2_2.this ,end_all_info[i][0] +"  " +end_all_info[i][1] +"  " +end_all_info[i][2] +"  " +end_all_info[i][3] ,
//                            Toast.LENGTH_SHORT)
//                            .show();
//                   // }

                }



        }


        if(ch && s_d_c == Pcdoubles-1) {
            info_check2 = new Integer[Pcdoubles-1][2];
            for (i = 0; i < Pcdoubles-1; i++) {
                info_check2[i][0] = save_info_check[i][0];
                info_check2[i][1] = save_info_check[i][1];
            }


        }
        else {

            info_check2 = new Integer[Pcdoubles-1][2];  //проверочный массив, содержит все номера страниц, содержащие надстройки и их положение, прочтены или нет
            for ( i = 0; i < Pcdoubles-1; i++){
                info_check2[i][0] = Integer.valueOf(end_all_info1[i][0]);
                info_check2[i][1] = 0;

             }
        }









        //////////////////////////блок, достающий важные страницы///////////////////




        String jk="",jk2;
        Integer idx=0;
//        grn.add("-1");
////        grn.add("-1");
        for(i=0; i<PC-doubles;i++){
            if(end_all_info[i][0].equals("-1")){
                if(end_all_info[i][2].equals("null")) {
                    break;
                }
                else{
                    jk = end_all_info[i][2];


                    do{
                        jk=jk.substring(3);
                        idx = jk.indexOf("|||");
                        if(idx==-1) {
//                                    grn.add(jk);

                            break;
                        }
                        else {

                            grn.add(jk.substring(0,idx));
                            jk = jk.substring(idx); //убрал последнее число

                        }
                    } while (idx!=-1);
                    break;
                }

            }
        }








    }


    @Override
    public void onPageChanged(int page, int pageCount) {



     if(kor==0){     // 0 - нажатие было

         kor=2; // 2- ставится на тот случай, если далее не будет никакой надстройки
}
    if(kor==1){ //1- нажатия не было, увеличиваем g
    g++;
    kor=2;
     }

        pageNumber = page;

/////////////////////////////////////////////////////////////////////////////оценка
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        mTimer = new Timer(); //объявляем новый таймер
        mMyTimerTask = new MyTimerTask(); // новая задача таймера
        mTimer.schedule(mMyTimerTask, SSDelay);       // задача, задержка


////////////////////////////////////////////////////////////////////////////////
        if(g==Pcdoubles-1){
            g = 0;
        }
        if(swch.isChecked()) {
            sw = true;
        }
        else {
            sw = false;
        }

        if(!sw) {                           //если выключатель выключен
//        Toast.makeText(
//                        SA_2_2.this , end_all_info[0][2],
//                        Toast.LENGTH_SHORT)
//                        .show();
            if (Integer.parseInt(end_all_info1[g][0]) == pageNumber) { //если номер страницы совпадает с номер ближайщей надстройки
                if (end_all_info1[g][1].equals("a")) {            //запуск видеонадстройки
                    Intent intent111 = new Intent(SA_2_2.this, SA_1_1_1.class);
//                        String val1 = end_all_info[g][2];
//                        String val2 = end_all_info[g][3];
                    intent111.putExtra("Ws", end_all_info1[g][2]);
                    intent111.putExtra("Com", end_all_info1[g][3]);
               check3();

                    startActivity(intent111);
                    overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                }
                if (end_all_info1[g][1].equals("b")) {          //запуск надстройки-изображения
                    Intent intent112 = new Intent(SA_2_2.this, SA_1_1_2.class);
                    intent112.putExtra("Ws", end_all_info1[g][2]);
                    intent112.putExtra("Com", end_all_info1[g][3]);

                   check3();

                    startActivity(intent112);
                    overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                }

                if (end_all_info1[g][1].equals("c")) {            // запуск надстройки-сайта
                    Intent intent113 = new Intent(SA_2_2.this, SA_1_1_3.class);
                    intent113.putExtra("Ws", end_all_info1[g][2]);
                    intent113.putExtra("Com", end_all_info1[g][3]);

                  check3();

                    startActivity(intent113);
                    overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                }
                if (end_all_info1[g][1].equals("d")) {          //запуск надстройки текста
                    Intent intent114 = new Intent(SA_2_2.this, SA_1_1_4.class);
                    intent114.putExtra("Ws", end_all_info1[g][2]);
                    intent114.putExtra("Com", end_all_info1[g][3]);

                 check3();

                    startActivity(intent114);
                    overridePendingTransition(R.anim.alpha_back, R.anim.alpha);

                }
                g = g + 1;
            }
        }

        else {               //если выключатель включен
            if (Integer.parseInt(end_all_info1[g][0]) == pageNumber) {  //если номер страницы совпадает с номер ближайщей надстройки
                if(g==Pcdoubles-1){   //PC - количество записей в файле, doubles - дубликаты записей, g - номер текущей надстройки
                    g = 0;
                }
                else {
                 //   g++;
//                    if(g!=0) {
//                        g = g + 1;
//                    }
                }

                //anima2();
              //  anima();
                if (mTimer3 != null) {
                    mTimer3.cancel();
                    mTimer3 = null;
                }
                mTimer3 = new Timer(); //объявляем новый таймер
                m3MyTimerTask = new SA_2_2.MyTimerTask3(); // новая задача таймера
                mTimer3.schedule(m3MyTimerTask, 4600);       // задача, задержка // отключение возможности воспроизведения надстройки
                                                                              // через 4.6 сек
                        if (end_all_info1[g][1].equals("a")) {
                                                                       //запуск видеонадстройки
                            anim2.setClickable(true);
                            anima();
                            anim2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    anim2.setClickable(false);

                            Intent intent111 = new Intent(SA_2_2.this, SA_1_1_1.class);
//                        String val1 = end_all_info[g][2];
//                        String val2 = end_all_info[g][3];
                            intent111.putExtra("Ws", end_all_info1[g][2]);
                            intent111.putExtra("Com", end_all_info1[g][3]);
                                 check3();


                                    startActivity(intent111);
                            overridePendingTransition(R.anim.alpha_back, R.anim.alpha);


                            kor = 0;
                            g++;
                        }

                    });


                }

                        if (end_all_info1[g][1].equals("b")) {          //запуск надстройки-изображения

                            anim.setClickable(true);
                            anima2();
                            anim.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    anim.setClickable(false);


                                    Intent intent112 = new Intent(SA_2_2.this, SA_1_1_2.class);
                                    intent112.putExtra("Ws", end_all_info1[g][2]);
                                    intent112.putExtra("Com", end_all_info1[g][3]);

                                  check3();

                                    startActivity(intent112);
                                    overridePendingTransition(R.anim.alpha_back, R.anim.alpha);

                                    kor = 0;
                                    g++;
                                }

                            });


                        }

                        if (end_all_info1[g][1].equals("c")) {            // запуск надстройки-сайта



                            anim3.setClickable(true);
                            anima3();
                            anim3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    anim3.setClickable(false);
                                    Intent intent113 = new Intent(SA_2_2.this, SA_1_1_3.class);
                                    intent113.putExtra("Ws", end_all_info1[g][2]);
                                    intent113.putExtra("Com", end_all_info1[g][3]);

                                 check3();

                                    startActivity(intent113);
                                    overridePendingTransition(R.anim.alpha_back, R.anim.alpha);


                                    kor = 0;
                                    g++;
                                }

                            });


                        }


                        if (end_all_info1[g][1].equals("d")) {          //запуск надстройки текста



                            anim4.setClickable(true);
                            anima4();
                            anim4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    anim4.setClickable(false);
                                    Intent intent114 = new Intent(SA_2_2.this, SA_1_1_4.class);
                                    intent114.putExtra("Ws", end_all_info1[g][2]);
                                    intent114.putExtra("Com", end_all_info1[g][3]);

                                 check3();

                                    startActivity(intent114);
                                    overridePendingTransition(R.anim.alpha_back, R.anim.alpha);


                                    kor = 0;
                                    g++;
                                }

                            });






                        }




           kor=1;
            }
            else {
                anim.setClickable(false);
                anim2.setClickable(false);
                anim3.setClickable(false);
                anim4.setClickable(false);
            }
            }

          /////////////блок, проверяющий, важная ли страница


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

    public void anm2(){
        ObjectAnimator animation3 = ObjectAnimator.ofFloat(green1, "alpha", 1.0f, 0.0f);
        animation3.setDuration(300);
        animation3.setInterpolator(new AccelerateDecelerateInterpolator());
        animation3.start();
   }

    public void anm1(){
        ObjectAnimator animation3 = ObjectAnimator.ofFloat(green1, "alpha", 0.0f, 1.0f);
        animation3.setDuration(300);
        animation3.setInterpolator(new AccelerateDecelerateInterpolator());
        animation3.start();
    }





            public void anima(){      //функция, при вызове которой будет проиграна анимация видео
  //  anim.setVisibility(View.VISIBLE);
    anim2.setVisibility(View.VISIBLE);


                ObjectAnimator player_right = ObjectAnimator.ofFloat(anim2, "translationX", 500); //убираю картинку за экран
                player_right.setDuration(1);
                player_right.setInterpolator(new AccelerateDecelerateInterpolator());
                player_right.start();


                ObjectAnimator player_right1 = ObjectAnimator.ofFloat(anim2, "translationX", -100);
                player_right1.setDuration(1200);
                player_right1.setStartDelay(30);
                player_right1.setInterpolator(new AccelerateDecelerateInterpolator());
                player_right1.start();



                ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(anim2,
                        PropertyValuesHolder.ofFloat("scaleX", 0.8f),
                        PropertyValuesHolder.ofFloat("scaleY", 0.8f));
                scaleDown.setDuration(450);
                scaleDown.setStartDelay(1200);
                scaleDown.start();

                ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(anim2,
                        PropertyValuesHolder.ofFloat("scaleX", 1.0f),
                        PropertyValuesHolder.ofFloat("scaleY", 1.0f));
                scaleDown1.setDuration(450);
                scaleDown1.setStartDelay(1650);
                scaleDown1.start();

                ObjectAnimator animation3 = ObjectAnimator.ofFloat(anim2, "alpha", 1.0f, 0.0f);
                animation3.setDuration(600);
                animation3.setRepeatCount(0);
                animation3.setStartDelay(4000);
                animation3.setRepeatMode(ObjectAnimator.RESTART);
                animation3.setInterpolator(new AccelerateDecelerateInterpolator());
                animation3.start();

                ObjectAnimator player_right2 = ObjectAnimator.ofFloat(anim2, "translationX", 500);
                player_right2.setDuration(1);
                player_right2.setStartDelay(4600);
                player_right2.setInterpolator(new AccelerateDecelerateInterpolator());
                player_right2.start();

                ObjectAnimator animation4 = ObjectAnimator.ofFloat(anim2, "alpha", 0.0f, 1.0f);
                animation4.setDuration(1);
                animation4.setRepeatCount(0);
                animation4.setStartDelay(4604);
                animation4.setRepeatMode(ObjectAnimator.RESTART);
                animation4.setInterpolator(new AccelerateDecelerateInterpolator());
                animation4.start();


            }

    public void anima2(){      //функция, при вызове которой будет проиграна анимация картинки
        anim.setVisibility(View.VISIBLE);



        ObjectAnimator player_right = ObjectAnimator.ofFloat(anim, "translationX", 500); //убираю картинку за экран
        player_right.setDuration(1);
        player_right.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right.start();


        ObjectAnimator player_right1 = ObjectAnimator.ofFloat(anim, "translationX", -100);
        player_right1.setDuration(1200);
        player_right1.setStartDelay(30);
        player_right1.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right1.start();

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(anim,
                PropertyValuesHolder.ofFloat("scaleX", 0.8f),
                PropertyValuesHolder.ofFloat("scaleY", 0.8f));
        scaleDown.setDuration(450);
        scaleDown.setStartDelay(1200);
        scaleDown.start();

        ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(anim,
                PropertyValuesHolder.ofFloat("scaleX", 1.0f),
                PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        scaleDown1.setDuration(450);
        scaleDown1.setStartDelay(1650);
        scaleDown1.start();

        ObjectAnimator animation3 = ObjectAnimator.ofFloat(anim, "alpha", 1.0f, 0.0f);
        animation3.setDuration(600);
        animation3.setRepeatCount(0);
        animation3.setStartDelay(4000);
        animation3.setRepeatMode(ObjectAnimator.RESTART);
        animation3.setInterpolator(new AccelerateDecelerateInterpolator());
        animation3.start();


        ObjectAnimator player_right2 = ObjectAnimator.ofFloat(anim, "translationX", 500);
        player_right2.setDuration(1);
        player_right2.setStartDelay(4600);
        player_right2.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right2.start();


        ObjectAnimator animation4 = ObjectAnimator.ofFloat(anim, "alpha", 0.0f, 1.0f);
        animation4.setDuration(1);
        animation4.setRepeatCount(0);
        animation4.setStartDelay(4604);
        animation4.setRepeatMode(ObjectAnimator.RESTART);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();

    }


    public void anima3(){      //функция, при вызове которой будет проиграна анимация сайта

        ObjectAnimator player_right = ObjectAnimator.ofFloat(anim3, "translationX", 500); //убираю картинку за экран
        player_right.setDuration(1);
        player_right.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right.start();


        ObjectAnimator player_right1 = ObjectAnimator.ofFloat(anim3, "translationX", -100);
        player_right1.setDuration(1200);
        player_right1.setStartDelay(30);
        player_right1.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right1.start();


        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(anim3,
                PropertyValuesHolder.ofFloat("scaleX", 0.8f),
                PropertyValuesHolder.ofFloat("scaleY", 0.8f));
        scaleDown.setDuration(450);
        scaleDown.setStartDelay(1200);
        scaleDown.start();

        ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(anim3,
                PropertyValuesHolder.ofFloat("scaleX", 1.0f),
                PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        scaleDown1.setDuration(450);
        scaleDown1.setStartDelay(1650);
        scaleDown1.start();

        ObjectAnimator animation3 = ObjectAnimator.ofFloat(anim3, "alpha", 1.0f, 0.0f);
        animation3.setDuration(600);
        animation3.setRepeatCount(0);
        animation3.setStartDelay(4000);
        animation3.setRepeatMode(ObjectAnimator.RESTART);
        animation3.setInterpolator(new AccelerateDecelerateInterpolator());
        animation3.start();

        ObjectAnimator player_right2 = ObjectAnimator.ofFloat(anim3, "translationX", 500);
        player_right2.setDuration(1);
        player_right2.setStartDelay(4600);
        player_right2.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right2.start();

        ObjectAnimator animation4 = ObjectAnimator.ofFloat(anim3, "alpha", 0.0f, 1.0f);
        animation4.setDuration(1);
        animation4.setRepeatCount(0);
        animation4.setStartDelay(4604);
        animation4.setRepeatMode(ObjectAnimator.RESTART);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();

        anim3.setVisibility(View.VISIBLE);

    }

    public void anima4(){      //функция, при вызове которой будет проиграна анимация сайта
        anim4.setVisibility(View.VISIBLE);


        ObjectAnimator player_right = ObjectAnimator.ofFloat(anim4, "translationX", 500); //убираю картинку за экран
        player_right.setDuration(1);
        player_right.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right.start();


        ObjectAnimator player_right1 = ObjectAnimator.ofFloat(anim4, "translationX", -100);
        player_right1.setDuration(1200);
        player_right1.setStartDelay(30);
        player_right1.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right1.start();

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(anim4,
                PropertyValuesHolder.ofFloat("scaleX", 0.8f),
                PropertyValuesHolder.ofFloat("scaleY", 0.8f));
        scaleDown.setDuration(450);
        scaleDown.setStartDelay(1200);
        scaleDown.start();

        ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(anim4,
                PropertyValuesHolder.ofFloat("scaleX", 1.0f),
                PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        scaleDown1.setDuration(450);
        scaleDown1.setStartDelay(1650);
        scaleDown1.start();

        ObjectAnimator animation3 = ObjectAnimator.ofFloat(anim4, "alpha", 1.0f, 0.0f);
        animation3.setDuration(600);
        animation3.setRepeatCount(0);
        animation3.setStartDelay(4000);
        animation3.setRepeatMode(ObjectAnimator.RESTART);
        animation3.setInterpolator(new AccelerateDecelerateInterpolator());
        animation3.start();

        ObjectAnimator player_right2 = ObjectAnimator.ofFloat(anim4, "translationX", 500);
        player_right2.setDuration(1);
        player_right2.setStartDelay(4600);
        player_right2.setInterpolator(new AccelerateDecelerateInterpolator());
        player_right2.start();

        ObjectAnimator animation4 = ObjectAnimator.ofFloat(anim4, "alpha", 0.0f, 1.0f);
        animation4.setDuration(1);
        animation4.setRepeatCount(0);
        animation4.setStartDelay(4604);
        animation4.setRepeatMode(ObjectAnimator.RESTART);
        animation4.setInterpolator(new AccelerateDecelerateInterpolator());
        animation4.start();

    }



public  void unclick(){
//    anim.setClickable(false);
//    anim2.setClickable(false);
//    anim3.setClickable(false);
//    anim4.setClickable(false);


}




            @Override
            public void onPageScrolled(int page, float positionOffset) {
                //  textView.setText(pageNumber);
            }

            @Override
            public boolean onTap(MotionEvent e) {

        /////////////////////расшифровка кода //////////////////////////////////
//                char[] alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
//                String sym,swap;
//                Integer ml = 0;
//                Integer id,count,count2;
//                Integer min = 0;
//                //  boolean chk;
//             //   Integer max = mail.length()-1;
//               String[] mail3 = new String[mail.length()];
//
//                for(i=0;i<mail.length();i++){ //цикл записывает по символьно почту в строку
//                    sym = mail.substring(i,i+1);
//                    if (sym.equals("@")||sym.equals(".")){
//                        mail3[i] = "";                          //удаляю лишние символы
//                    }
//                    else{
//                        boolean chk = isDigit(sym);
//                        if(chk){                       //если это цифра
//                            mail3[i] = "";
//                        }
//                        else {
//                            mail3[i] = sym;
//                        }
//
//                    }
//                }
//
//                //преобразование кода/////
//                String[] code3 = new String[code2.length()];
//                for (i = 0; i<code2.length();i++){
//                    code3[i] = code2.substring(i,i+1);
//
//                }
//
//                for(j=0; j < code2.length(); j++) {
//                    for (i = 26; i < 51; i++) {
//                        if(code3[j].equals(String.valueOf(alphabet[i]))){
////                     Toast.makeText(
////                             SA_2_2.this , mail2[j] + "  " + String.valueOf(alphabet[i+3]),
////                             Toast.LENGTH_SHORT)
////                             .show();
//                            code3[j] = String.valueOf(alphabet[i-3]);
//                            break;
//                        }
//                    }
//                }
//                String[] mail4 = new String[code2.length()];
//                j=0;
//                for(i = 0; i<mail.length(); i++){
//                    if(mail3[i].equals("")){
//
//                    }
//                    else
//                    {
//                        mail4[j] = mail3[i];
//                        j++;
//                    }
//                }
//
//
//                for(j=0; j < code2.length(); j++) {              //упорядочиваем символы
//                    for (i = 0; i < code2.length(); i++) {
//                        if(mail4[j].equals(code3[i])){
//                            swap = code3[i];
//                            code3[i] = code3[j];
//                            code3[j] = swap;
//                            break;
//
//                        }
//
//                    }
//                }
//
//                String fin1 = "";
//                String fin2 = "";
//                for(i=0;i<mail.length(); i++){
//                    fin1 =fin1+ mail3[i];
//                }
//
//                for(i=0;i<code2.length(); i++){
//                    fin2 =fin2+ code3[i];
//                }
//                // fin2 = fin2 +"a";
//                if(fin1.equals(fin2)) {
//                    Toast.makeText(
//                            SA_2_2.this ,"Верный код" ,
//                            Toast.LENGTH_SHORT)
//                            .show();
//                }
//                else {
//                    Toast.makeText(
//                            SA_2_2.this ,"Неверный код" ,
//                            Toast.LENGTH_SHORT)
//                            .show();
//                }

                ////////////////////////////////////////////////////////////////

              // mailchck();
//             jack++;
//             if(jack == 3) {
//                 Intent intent116 = new Intent(SA_2_2.this, game_menu.class);
//              //   intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
//                 startActivity(intent116);
//                 overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
//             }

                return false;
            }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mTimer2 != null) {
            mTimer2.cancel();
            mTimer2 = null;
        }
        if (mTimer4 != null) {
            mTimer4.cancel();
            mTimer4 = null;
        }


        //запись инфы
     //   fileExists(dir +"arc_z"+ f_name + ".txt"); //проверка существования файла
        String all_pages = "";
        String all_dop = "";

        for ( i = 0; i < PageCount; i++) {
            all_pages =all_pages+String.valueOf(i) + "_" +  String.valueOf(info_check[i][1]) +"|";
        }
        for ( i = 0; i < Pcdoubles-1; i++){
            all_dop = all_dop + String.valueOf(info_check2[i][0]) + "_" +  String.valueOf(info_check2[i][1]) + "|";

        }
        String g1 = String.valueOf(g);

            try {
                FileWriter writer = new FileWriter(dir +"arc_z"+ f_name + ".txt", false);
                //1 строка - последняя страница
                //2 строка - массив данных о прочитанных страницах    Страница____Положение|||
                //3 строка - массив данных о прочитанных надстройках
                //4 строка - данные прогресс бара

                writer.write(String.valueOf(pageNumber)+'\n');
                writer.write(all_pages+'\n');
                writer.write(all_dop+'\n');
                writer.write(String.valueOf(bar.intValue())+'\n');
                writer.write(g1+'\n');
                writer.write(String.valueOf(all_time)+'\n');

                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        Intent Intent2 = new Intent(".SA_2");
        startActivity(Intent2);

        finish();
        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
    }

class MyTimerTask extends TimerTask { //задача таймера

    @Override
    public void run() {


        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                for(i = 0; i < PageCount ; i++){
                   if(info_check[i][0] == pageNumber){
                       if(info_check[i][1] == 0){
                           info_check[i][1] = 1;
                           bar = bar + progress;
                           pb.setProgress(bar.intValue());
                         mailchck();


                       }
                   }
                }
            }
        });
    }
}



    class MyTimerTask2 extends TimerTask { //задача таймера

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    Toast.makeText(
                            SA_2_2.this ,"Вы читаете уже более 30-ти минут" ,
                            Toast.LENGTH_SHORT)
                            .show();
                    Toast.makeText(
                            SA_2_2.this ,"Вам стоит отдохнуть" ,
                            Toast.LENGTH_SHORT)
                            .show();

                    ppl.setVisibility(View.VISIBLE);
                    ppl.setClickable(true); //чтобы нельзя было случайно нажать, пока не работает анимация

                }
            });
        }
    }


    class MyTimerTask3 extends TimerTask { //задача таймера

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                 unclick();
                }
            });
        }
    }

    class MyTimerTask4 extends TimerTask { //задача таймера

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                  all_time++;
                }
            });
        }
    }

    public  void   mailchck(){
        if(bar>=90&& m_chk ==0){
            mail325.setClickable(true);
            mail325.setVisibility(View.VISIBLE);
            m_chk = 1;
//            Toast.makeText(
//                    SA_2_2.this ,"Сообщите о ваших результатах",
//                    Toast.LENGTH_SHORT)
//                    .show();

            //////////////шифруем данные/////////////
            char[] alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
            String sym,swap;
            Integer ml = 0;
            Integer id,count,count2;
            Integer min = 0;
          //  boolean chk;
            Integer max = mail.length()-1;
            mail2 = new String[mail.length()];

            for(i=0;i<mail.length();i++){ //цикл записывает по символьно почту в строку
                sym = mail.substring(i,i+1);
                if (sym.equals("@")||sym.equals(".")){
                    mail2[i] = "";                          //удаляю лишние символы
                }
                else{
                    boolean chk = isDigit(sym);
                    if(chk){                       //если это цифра
                    mail2[i] = "";
                    }
                    else {
                        mail2[i] = sym;
                    }

                }
            }
            for(j=0;j<mail.length();j++) {
                for (i = 0; i < 26; i++) {
                 if(mail2[j].equals(String.valueOf(alphabet[i]))){
//                     Toast.makeText(
//                             SA_2_2.this , mail2[j] + "  " + String.valueOf(alphabet[i+3]),
//                             Toast.LENGTH_SHORT)
//                             .show();
                     mail2[j] = String.valueOf(alphabet[i+3]);
                           break;
                 }
                }
            }
do {


    for (i = 0; i < mail.length(); i++) {
        Random rnd = new Random(System.currentTimeMillis());
        count = min + rnd.nextInt(max - min + 1);
        swap = mail2[count];
        mail2[count] = mail2[i];
        mail2[i] = swap;

    }
    ml++;

}
while (ml<20);

            for(i=0;i<mail.length();i++){
                code2 = code2 + mail2[i];
            }

//            Toast.makeText(
//                    SA_2_2.this ,code2,
//                    Toast.LENGTH_SHORT)
//                    .show();


            // count = min + rnd.nextInt(max - min + 1);
            ////////////////////////////////

           send_mail();
        }

    }
    public void  send_mail(){
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[] { mail });
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Студент (укажите Ф.И.О.) завершил изучение");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Документ и дополнительная информация "+f_name+".pdf "
                +"были изучены студентом на "+ String.valueOf((bar.intValue())) + "%"  +'\n'
                + '\n'+ '\n'+ '\n'+ '\n'+ '\n'+ '\n'+ '\n'+ '\n'+ '\n'+ '\n'+ '\n'+ '\n'+ '\n'+ '\n' +"Код безопасности создателя: "+ code+ '\n'+ '\n'+ '\n' + "Код безопасности пользователя: " + code2
                + '\n'+ '\n'+ '\n'+ "Затраченное время на изучение "
                +String.valueOf(all_time/60)+" мин"+ '\n');
        SA_2_2.this.startActivity(Intent.createChooser(emailIntent, "Выберите почтовое приложение"));

    }


public void check3(){
    for ( i = 0; i < PC - doubles-1;i++){   // цикл, проверяющий, была ли прочтена надстройка
        if(info_check2[i][0] == Integer.valueOf(end_all_info1[g][0])){
            if(info_check2[i][1] == 0) {
                info_check2[i][1] = 1;
                bar = bar + progress;
                pb.setProgress(bar.intValue());
                mailchck();
            }

        }

    }
}

public  void  firstanim() {
    ObjectAnimator player_right = ObjectAnimator.ofFloat(anim4, "translationX", 500); //убираю картинку за экран
    player_right.setDuration(1);
    player_right.setInterpolator(new AccelerateDecelerateInterpolator());
    player_right.start();
    ObjectAnimator player_right1 = ObjectAnimator.ofFloat(anim3, "translationX", 500); //убираю картинку за экран
    player_right1.setDuration(1);
    player_right1.setInterpolator(new AccelerateDecelerateInterpolator());
    player_right1.start();

    ObjectAnimator player_right2 = ObjectAnimator.ofFloat(anim, "translationX", 500); //убираю картинку за экран
    player_right2.setDuration(1);
    player_right2.setInterpolator(new AccelerateDecelerateInterpolator());
    player_right2.start();

    ObjectAnimator player_right3 = ObjectAnimator.ofFloat(anim2, "translationX", 500); //убираю картинку за экран
    player_right3.setDuration(1);
    player_right3.setInterpolator(new AccelerateDecelerateInterpolator());
    player_right3.start();

}
    public void timerCheck(){

       str2.clear();


        try {
            FileInputStream fstream1 = new FileInputStream(dir  + f_name + ".txt");
            BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
            String strLine;
            while ((strLine = br1.readLine()) != null) {
                str2.add(strLine);               //тут надо считывать в массив

            }
            br1.close();
            fstream1.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }



        String[] n_arr_info = new String[str2.size()];        //преобразуем лист в массив стринг
        str2.toArray(n_arr_info);
       String[][] all_info1 = new String[PC][4];
        //  String[][] all_info = new String[PC][4];         //PC показывает точно количество записей
        for (i = 0; i < PC; i++) {                             //циклы получения данных из листа в массив
            ind_count = n_arr_info[i].indexOf("____");
            all_info1[i][0] = n_arr_info[i].substring(0, ind_count); //вытаскиваю номер страницы

            n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);
            all_info1[i][1] = n_arr_info[i].substring(0, 1); //вытаскиваю тип надстройки
            n_arr_info[i] = n_arr_info[i].substring(5);

            ind_count = n_arr_info[i].indexOf("____"); //получаю индекс конца ссылки
            all_info1[i][2] = n_arr_info[i].substring(0, ind_count); //записал ссылку
            n_arr_info[i] = n_arr_info[i].substring(ind_count + 4);
            all_info1[i][3] = n_arr_info[i]; // получил коментарий создателя

        }
        for(i = 0; i < PC; i++) {
            if(all_info1[i][0].equals("-1")){     //проверка, есть ли хотя бы одна запись с таймером
                urizen = 1;
            }

        }

        if(urizen == 0) {           //если нет, допишем стандартную
            try {
                FileWriter writer1 = new FileWriter( dir +f_name+".txt", true);     //работает норм
                writer1.write("-1____f____null____13|||arc.mobile.help@gmail.com|||325325"+'\n'); // не забывай знак новой строки
                //  writer.write(a_info.get(0)+'\n');
                writer1.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

//        if(PC == 1 && urizen==1) { //если есть только одна записьи это запись таймера
//            try {
//                FileWriter writer1 = new FileWriter( dir +f_name+".txt", true);     //работает норм
//                writer1.write("-1____f____null____13"+'\n'); // не забывай знак новой строки
//                //  writer.write(a_info.get(0)+'\n');
//                writer1.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }



    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


  public void info_chcker(){
        //считывает инфу
      try {
          FileInputStream fstream = new FileInputStream(dir +"arc_z"+f_name + ".txt");
          BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
          String strLine;
          while ((strLine = br.readLine()) != null) {
            save_info.add(strLine);                     //количество строк в файле содержащем данные надстройки

          }

          br.close();
          fstream.close();
      } catch (IOException e1) {
          e1.printStackTrace();
      }

      def_page = Integer.valueOf(save_info.get(0));
      Integer idx=0;
      String test_str = save_info.get(2);
      String test_str2 = save_info.get(1);

      do {
       idx = test_str.indexOf("|");
       if (idx!=-1) {
           test_str = test_str.substring(idx+1);
           s_d_c++;
       }
       else {
           break;
       }
      }
      while (idx!=-1);


      do {
          idx = test_str2.indexOf("|");
          if (idx!=-1) {
              test_str2 = test_str2.substring(idx+1);
              s_p_c++;
          }
          else {
              break;
          }
      }
      while (idx!=-1);

      save_info_check = new Integer[s_d_c][2];
      save_info_check2 = new Integer[s_p_c][2];
      idx =0;
      test_str  = save_info.get(2); //надстройки
      test_str2 = save_info.get(1); //cтраницы
       String vb;
      for (i = 0; i < s_p_c;i++){
          idx = test_str2.indexOf("_");
          vb = test_str2.substring(0,idx);
          save_info_check2[i][0] = Integer.valueOf(vb);
          idx = test_str2.indexOf("|");
          vb = test_str2.substring(idx-1, idx);
          save_info_check2[i][1] = Integer.valueOf(vb);
          test_str2 = test_str2.substring(idx+1);
//          Toast.makeText(
//                  SA_2_2.this , test_str2,
//                  Toast.LENGTH_SHORT)
//                  .show();
//          Toast.makeText(
//                  SA_2_2.this , String.valueOf(save_info_check2[i][0]) + "  " + String.valueOf( save_info_check2[i][1]),
//                  Toast.LENGTH_SHORT)
//                  .show();
      }

      for (i = 0; i < s_d_c;i++) {
          idx = test_str.indexOf("_");
          vb = test_str.substring(0, idx);
          save_info_check[i][0] = Integer.valueOf(vb);
          idx = test_str.indexOf("|");
          vb = test_str.substring(idx - 1, idx);
          save_info_check[i][1] = Integer.valueOf(vb);
          test_str = test_str.substring(idx + 1);


      }

      bar = Double.valueOf(save_info.get(3));
      g = Integer.valueOf(save_info.get(4));
      all_time = Long.valueOf(save_info.get(5));

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


    }
