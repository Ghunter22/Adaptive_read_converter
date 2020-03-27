package com.example.sevatar.pw_pre_alpha;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class game extends AppCompatActivity {

    private Timer mTimer1;
    private Timer mTimer2;
    private Timer mTimer3;
    private Timer mTimer4;
    private Timer mTimer5;
    private Timer mTimer6;
    private Timer mTimer7;
    private game.MyTimerTask1 m1MyTimerTask;
    private game.MyTimerTask2 m2MyTimerTask;
    private game.MyTimerTask3 m3MyTimerTask;
    private game.MyTimerTask4 m4MyTimerTask;
    private game.MyTimerTask5 m5MyTimerTask;
    private game.MyTimerTask6 m6MyTimerTask;
    private game.MyTimerTask7 m7MyTimerTask;
    private static int SPLASH_TIME_OUT = 1200;
    MediaPlayer player5;

    Float e1_position = 0.0f;
    Float e2_position = 0.0f;
    Float e3_position = 0.0f;
    Float e4_position = 0.0f;
    Float e5_position = 0.0f;
    Integer min_r,max_r,min_r2,max_r2,min_r3,max_r3,min_r4,max_r4,min_r5,max_r5;
    Integer time = 0;
    Integer var = 1;
    Integer dur1 = 3000;
    Integer dur2 = 3000;
    Integer dur3 = 3000;
    Integer dam = 2;
    Integer dur4 = 3000;
    Integer dur5 = 3000;
    Integer Check3 = 2;
    Integer p_position = 0;
    Integer timeDealy = 0;
    Integer min = -8;
    Integer max = 0;
    String record1,record2;
    Long fg = 5L;
    Long damage = 0L;
    Integer wtf = 0;
    Integer count = 0;
    Integer SSDelay = 200;      //расстояник которое они проходят   406x731
    Integer period,ult;
    Integer score =100;  //здоровье
    ImageView right, left, player1, enemy1, enemy2, enemy3, enemy4, enemy5,heart1,timer1,ultimate;
    TextView score1,score2,ulta;

    Integer x1 = 100;     // до 1    шаг 1 = 50 усл ед   //расстояние 600, столкновение на расстояние 100 - 0, 100 усл ед = 0.2 с
    Integer x2 = 200;     // до 2
    Integer x3 = 300;     // до 3
    Integer x4 = 400;     // до 3
    Integer x5 = 500;     // до 3
    Integer player = -3;
    Vibrator vibrator ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent116 = getIntent();

        record1 = intent116.getStringExtra("record1");
        record2 = intent116.getStringExtra("record4");

        if(Integer.valueOf(record1)>=60) {

            max_r = 2;
            min_r = 1;
        }
        else {
            max_r = 1;
            min_r = 1;
        }


        if(Integer.valueOf(record1)>=120) {

            max_r2 = 2;
            min_r2 = 1;
        }
        else {
            max_r2 = 1;
            min_r2 = 1;
        }



        if(Integer.valueOf(record1)>=180) {

            max_r3 = 2;
            min_r3 = 1;
        }
        else {
            max_r3 = 1;
            min_r3 = 1;
        }

        if(Integer.valueOf(record1)>=300) {

            max_r4 = 2;
            min_r4 = 1;
        }
        else {
            max_r4 = 1;
            min_r4 = 1;
        }

        if(Integer.valueOf(record2)>=5000) {

            max_r5 = 2;
            min_r5 = 1;
        }
        else {
            max_r5 = 1;
            min_r5 = 1;
        }
       // player5 = MediaPlayer.create(this, R.raw.arc);
//        player5.setLooping(true); // зацикливаем
//        player5.start();

        right = (ImageView) findViewById(R.id.t_right);
        left = (ImageView) findViewById(R.id.t_left);
        enemy1 = (ImageView) findViewById(R.id.enemy1);
        enemy2 = (ImageView) findViewById(R.id.enemy2);
        enemy3 = (ImageView) findViewById(R.id.enemy3);
        enemy4 = (ImageView) findViewById(R.id.enemy4);
        enemy5 = (ImageView) findViewById(R.id.enemy5);
        heart1 = (ImageView) findViewById(R.id.heart);
        player1 = (ImageView) findViewById(R.id.player);
        ultimate = (ImageView) findViewById(R.id.ultimate);
        score1 = (TextView)  findViewById(R.id.score);
        score2 = (TextView)  findViewById(R.id.score2);
        ulta = (TextView)  findViewById(R.id.ulta);
        timer1 = (ImageView) findViewById(R.id.timer);
        score1.setText(String.valueOf(score));

        vibrator = (Vibrator) getSystemService(game.VIBRATOR_SERVICE);

        ulta.setText("1");
      //  ultimate.setClickable(false);
        ultimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ultimate.setClickable(false);
                ulta.setText("0");
                        ult = player;
                        player = -10;
                        right.setClickable(false);
                        left.setClickable(false);


                ObjectAnimator show_e_1 = ObjectAnimator.ofFloat(player1, "alpha", 1.0f, 0.3f);
                show_e_1.setDuration(200);
                // show_e_1.setStartDelay(20);
                show_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
                show_e_1.start();

                        Drawable drawable = ultimate.getDrawable();
                        if (drawable instanceof Animatable){
                            ((Animatable) drawable).start();
                        }

                    mTimer7 = new Timer(); //объявляем новый таймер
                    m7MyTimerTask = new game.MyTimerTask7(); // новая задача таймера
                    mTimer7.schedule(m7MyTimerTask, 800);       // задача, задержка




            }
        });


        right.setOnClickListener(new View.OnClickListener() {      //нажатие " ВПРАВО"
            @Override
            public void onClick(View v) {
                vibrator.cancel();
                if (player != -5) {
                    player = player - 1;

                    p_position = p_position + 121;
                    ObjectAnimator player_right = ObjectAnimator.ofFloat(player1, "translationX", p_position);
                    player_right.setDuration(300);
                    player_right.setInterpolator(new AccelerateDecelerateInterpolator());
                    player_right.start();




                }
            }
        });

        left.setOnClickListener(new View.OnClickListener() {     // нажатие влево
            @Override
            public void onClick(View v) {

                vibrator.cancel();
                if( player != -1) {
                    player = player + 1;

                    p_position = p_position - 121;
                    ObjectAnimator player_left = ObjectAnimator.ofFloat(player1, "translationX", p_position);
                    player_left.setDuration(300);
                    player_left.setInterpolator(new AccelerateDecelerateInterpolator());
                    player_left.start();
                }
            }
        });

 /////////////////////все что ниже, засунуть в кнопку СТАРТ
        if (mTimer1 != null) {
            mTimer1.cancel();
            mTimer1 = null;
        }
        if (mTimer2 != null) {
            mTimer2.cancel();
            mTimer2 = null;
        }
        if (mTimer3 != null) {
            mTimer3.cancel();
            mTimer3 = null;
        }
        if (mTimer4 != null) {
            mTimer4.cancel();
            mTimer4 = null;
        }
        if (mTimer5 != null) {
            mTimer5.cancel();
            mTimer5 = null;
        }

        if (mTimer6 != null) {
            mTimer6.cancel();
            mTimer6 = null;
        }
        mTimer1 = new Timer(); //объявляем новый таймер
        m1MyTimerTask = new game.MyTimerTask1(); // новая задача таймера
        mTimer1.schedule(m1MyTimerTask, SSDelay+100, 30);       // задача, задержка

        mTimer2 = new Timer(); //объявляем новый таймер
        m2MyTimerTask = new game.MyTimerTask2(); // новая задача таймера
        mTimer2.schedule(m2MyTimerTask, SSDelay-150,30);       // задача, задержка


        mTimer3 = new Timer(); //объявляем новый таймер
        m3MyTimerTask = new game.MyTimerTask3(); // новая задача таймера
        mTimer3.schedule(m3MyTimerTask, SSDelay+500,30);       // задача, задержка

        mTimer4 = new Timer(); //объявляем новый таймер
        m4MyTimerTask = new game.MyTimerTask4(); // новая задача таймера
        mTimer4.schedule(m4MyTimerTask, SSDelay+800,30);       // задача, задержка

        mTimer5 = new Timer(); //объявляем новый таймер
        m5MyTimerTask = new game.MyTimerTask5(); // новая задача таймера
        mTimer5.schedule(m5MyTimerTask, SSDelay+100,30);       // задача, задержка

        mTimer6 = new Timer(); //объявляем новый таймер
        m6MyTimerTask = new game.MyTimerTask6(); // новая задача таймера
        mTimer6.schedule(m6MyTimerTask, 0,1000);       // задача, задержка

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(heart1,
                PropertyValuesHolder.ofFloat("scaleX", 0.8f),
                PropertyValuesHolder.ofFloat("scaleY", 0.8f));
        scaleDown.setDuration(600);
        scaleDown.setRepeatMode(ValueAnimator.REVERSE);
        scaleDown.setRepeatCount(-1);
        scaleDown.setStartDelay(100);
        scaleDown.start();


        Drawable drawable2 = enemy2.getDrawable();
        if (drawable2 instanceof Animatable){
            ((Animatable) drawable2).start();
        }
        Drawable drawable = timer1.getDrawable();
        if (drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }




    }


    class MyTimerTask1 extends TimerTask {  // ТАЙМЕР Х1

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {



//                    ObjectAnimator enemy_1 = ObjectAnimator.ofFloat(enemy1, "translationY", e1_position);
//                    enemy_1.setDuration(1L);
//                    enemy_1.setStartDelay(600);
//                    enemy_1.setInterpolator(new AccelerateDecelerateInterpolator());
//                    enemy_1.start();

                    if(x1 ==100) {

                        ObjectAnimator enemy_1_back = ObjectAnimator.ofFloat(enemy1, "translationY",  0);
                        enemy_1_back.setDuration(1);
                     //   enemy_1_back.setStartDelay(100);
                        enemy_1_back.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_1_back.start();

                        ObjectAnimator show_e_1 = ObjectAnimator.ofFloat(enemy1, "alpha", 0.0f, 1.0f);
                        show_e_1.setDuration(20);
                       // show_e_1.setStartDelay(20);
                        show_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
                        show_e_1.start();

                        ObjectAnimator enemy_1 = ObjectAnimator.ofFloat(enemy1, "translationY", 900.0f);
                        enemy_1.setDuration(dur1*9/10);
                        enemy_1.setStartDelay(100);
                        enemy_1.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_1.start();
                    }
                    x1 = x1 - 1;
                   // e1_position = e1_position +2.0f;

                       if(x1==10) {
                           ObjectAnimator hide_e_1 = ObjectAnimator.ofFloat(enemy1, "alpha", 1.0f, 0.0f);
                        hide_e_1.setDuration(20);
                        hide_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
                        hide_e_1.start();


                       }


//                    if( e1_position == 980f) {
//                        ObjectAnimator hide_e_1 = ObjectAnimator.ofFloat(enemy1, "alpha", 1.0f, 0.0f);
//                        hide_e_1.setDuration(20);
//                        hide_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
//                        hide_e_1.start();
//
//                        ObjectAnimator show_e_1 = ObjectAnimator.ofFloat(enemy1, "alpha", 0.0f, 1.0f);
//                        show_e_1.setDuration(200);
//                        show_e_1.setStartDelay(1100-SSDelay);
//                        show_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
//                        show_e_1.start();
//                    }
//
//                    if( e1_position == 1000f) {
//
//
//                        e1_position = 0f;
//
//                        ObjectAnimator enemy_1_back = ObjectAnimator.ofFloat(enemy1, "translationY",  e1_position);
//                        enemy_1_back.setDuration(40);
//                        enemy_1_back.setInterpolator(new AccelerateDecelerateInterpolator());
//                        enemy_1_back.start();
//
//
//
//                    }
                    if( x1 <=50&& x1 >=36) {
                        if (player == -1) {

                            score = score - dam;
                            score1.setText(String.valueOf(score));

                                break_vbr1();
                        }
                    }
                    if (x1 == 0){



                        score = score +1;
                        score1.setText(String.valueOf(score));
                        x1 = 100;

                        if (mTimer1 != null) {
                            mTimer1.cancel();
                            mTimer1 = null;
                        }


                        Random rnd1 = new Random(System.currentTimeMillis());
                        count = min_r + rnd1.nextInt(max_r - min_r + 1);
                        if(count == 1)
                            enemy1.setImageResource(R.drawable.ic_enemy_1_1);      //1 скин врага
                        if(count == 2)
                            enemy1.setImageResource(R.drawable.ic_enemy111); // 2 скин врага


                        Random rnd = new Random(System.currentTimeMillis());
// Получаем случайное число в диапазоне от min до max (включительно)
                        count = min + rnd.nextInt(max - min + 1);
                        dur1 = 100*(30+count - timeDealy);

                        mTimer1 = new Timer(); //объявляем новый таймер
                        m1MyTimerTask = new MyTimerTask1(); // новая задача таймера
                        mTimer1.schedule(m1MyTimerTask, SSDelay, 30+count-timeDealy);       // задача, задержка


                       // dur1 = 6 + count - timeDealy;
//                        Toast.makeText(
//                                game.this, "Ваш счет " + String.valueOf(score),
//                                Toast.LENGTH_SHORT)
//                                .show();
                    }

                }
            });
        }
    }

    class MyTimerTask2 extends TimerTask { //ТАЙМЕР Х2

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {





                    if( x2==200) {

                        ObjectAnimator enemy_2_back = ObjectAnimator.ofFloat(enemy2, "translationY",  0);
                        enemy_2_back.setDuration(1);
                        enemy_2_back.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_2_back.start();


                        ObjectAnimator show_e_1 = ObjectAnimator.ofFloat(enemy2, "alpha", 0.0f, 1.0f);
                        show_e_1.setDuration(20);
                      //  show_e_1.setStartDelay(500);
                        show_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
                        show_e_1.start();

                        ObjectAnimator enemy_2 = ObjectAnimator.ofFloat(enemy2, "translationY", 900.0f);
                        enemy_2.setDuration(dur2*9/10);
                        enemy_2.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_2.setStartDelay(300);
                        enemy_2.start();

                    }

                    x2 = x2 - 1;

              //      e2_position = e2_position +2.0f;

                         if(x2 ==110){

                             ObjectAnimator hide_e_2 = ObjectAnimator.ofFloat(enemy2, "alpha", 1.0f, 0.0f);
                             hide_e_2.setDuration(20);
                             hide_e_2.setInterpolator(new AccelerateDecelerateInterpolator());
                             hide_e_2.start();


                    }




                    if( x2 <=136 && x2 >=126) {
                        if (player == -2) {

                                score = score - dam - 1;
                                score1.setText(String.valueOf(score));

                                    break_vbr1();

                        }
                    }

                    if (x2 == 100){




                        score +=1;
                        score1.setText(String.valueOf(score));
                        x2 = 200;

                        if (mTimer2 != null) {
                            mTimer2.cancel();
                            mTimer2 = null;
                        }


                        Random rnd1 = new Random(System.currentTimeMillis());
                        count = min_r2 + rnd1.nextInt(max_r2 - min_r2 + 1);
                        if(count == 1)
                            enemy2.setImageResource(R.drawable.anim_enemy2);      //1 скин врага
                        if(count == 2)
                            enemy2.setImageResource(R.drawable.ic_enemy222); // 2 скин врага


                        Random rnd = new Random(System.currentTimeMillis());
// Получаем случайное число в диапазоне от min до max (включительно)
                        count = min + rnd.nextInt(max - min + 1);
                        dur2 = 100*(30+count -timeDealy);
                        mTimer2 = new Timer(); //объявляем новый таймер
                        m2MyTimerTask = new MyTimerTask2(); // новая задача таймера
                        mTimer2.schedule(m2MyTimerTask, SSDelay, 30 + count -timeDealy);

                    }
                }
            });
        }
    }

    class MyTimerTask3 extends TimerTask { //ТАЙМЕР Х3

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {


                    if( x3==300) {

                        ObjectAnimator enemy_2_back = ObjectAnimator.ofFloat(enemy3, "translationY", 0);
                        enemy_2_back.setDuration(1);
                      //  enemy_2_back.setStartDelay(100);
                        enemy_2_back.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_2_back.start();

                        ObjectAnimator show_e_1 = ObjectAnimator.ofFloat(enemy3, "alpha", 0.0f, 1.0f);
                        show_e_1.setDuration(20);
                    //    show_e_1.setStartDelay(20);
                        show_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
                        show_e_1.start();

                        ObjectAnimator enemy_2 = ObjectAnimator.ofFloat(enemy3, "translationY", 900);
                        enemy_2.setDuration(dur3*9/10);
                        enemy_2.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_2.setStartDelay(100);
                        enemy_2.start();



                    }

                    x3 = x3 - 1;

                    if( x3 == 210) {


                        ObjectAnimator hide_e_2 = ObjectAnimator.ofFloat(enemy3, "alpha", 1.0f, 0.0f);
                        hide_e_2.setDuration(20);
                        hide_e_2.setInterpolator(new AccelerateDecelerateInterpolator());
                        hide_e_2.start();






                    }



                    if(x3 <=242 && x3 >=230) {
                        if (player == -3) {



                                score = score - dam -1;
                                score1.setText(String.valueOf(score));

                                    break_vbr1();

                        }
                    }
                    if (x3 == 200){



                        score +=1;
                        score1.setText(String.valueOf(score));

                        x3 = 300;

                        if (mTimer3 != null) {
                            mTimer3.cancel();
                            mTimer3 = null;
                        }

                        Random rnd1 = new Random(System.currentTimeMillis());
                        count = min_r3 + rnd1.nextInt(max_r3 - min_r3 + 1);
                        if(count == 1)
                            enemy3.setImageResource(R.drawable.ic_enemy3_3);      //1 скин врага
                        if(count == 2)
                            enemy3.setImageResource(R.drawable.ic_enemy333); // 2 скин врага

                        Random rnd = new Random(System.currentTimeMillis());
// Получаем случайное число в диапазоне от min до max (включительно)
                        count = min + rnd.nextInt(max - min + 1);

                        dur3 = 100*(30+count-timeDealy);
                        mTimer3 = new Timer(); //объявляем новый таймер
                        m3MyTimerTask = new MyTimerTask3(); // новая задача таймера
                        mTimer3.schedule(m3MyTimerTask, SSDelay, 30 + count - timeDealy);

                    }
                }
            });
        }
    }



    class MyTimerTask4 extends TimerTask { //ТАЙМЕР Х4

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {



                    if( x4==400) {


                        ObjectAnimator enemy_2_back = ObjectAnimator.ofFloat(enemy4, "translationY", 0);
                        enemy_2_back.setDuration(1);
                        enemy_2_back.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_2_back.start();


                        ObjectAnimator enemy_2 = ObjectAnimator.ofFloat(enemy4, "translationY", 900);
                        enemy_2.setDuration(dur4*9/10);
                        enemy_2.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_2.setStartDelay(300);
                        enemy_2.start();



                        ObjectAnimator show_e_1 = ObjectAnimator.ofFloat(enemy4, "alpha", 0.0f, 1.0f);
                        show_e_1.setDuration(20);
                       // show_e_1.setStartDelay(1100- SSDelay);
                        show_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
                        show_e_1.start();
                    }

                    x4 = x4 - 1;
                    if( x4 == 310) {


                        ObjectAnimator hide_e_2 = ObjectAnimator.ofFloat(enemy4, "alpha", 1.0f, 0.0f);
                        hide_e_2.setDuration(20);
                        hide_e_2.setInterpolator(new AccelerateDecelerateInterpolator());
                        hide_e_2.start();





                    }


                    if(x4 <=340 && x4 >=324) {
                        if (player == -4) {
                                score = score - 2;
                                score1.setText(String.valueOf(score));

                                    break_vbr1();

                        }
                    }
                    if (x4 == 300){
                        score +=1;
                        score1.setText(String.valueOf(score));
                        x4 = 400;

                        if (mTimer4 != null) {
                            mTimer4.cancel();
                            mTimer4 = null;
                        }


                        Random rnd1 = new Random(System.currentTimeMillis());
                        count = min_r4 + rnd1.nextInt(max_r4 - min_r4 + 1);
                        if(count == 1)
                            enemy4.setImageResource(R.drawable.ic_enemy4_4);      //1 скин врага
                        if(count == 2)
                            enemy4.setImageResource(R.drawable.ic_enemy444); // 2 скин врага


                        Random rnd = new Random(System.currentTimeMillis());
// Получаем случайное число в диапазоне от min до max (включительно)
                        count = min + rnd.nextInt(max - min + 1);

                           dur4 = 100*(30+count-timeDealy);
                        mTimer4 = new Timer(); //объявляем новый таймер
                        m4MyTimerTask = new MyTimerTask4(); // новая задача таймера
                        mTimer4.schedule(m4MyTimerTask, SSDelay, 30 + count - timeDealy);


                    }
                }
            });
        }
    }


    class MyTimerTask5 extends TimerTask { //ТАЙМЕР Х5

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {




                    if( x5==500) {


                        ObjectAnimator enemy_2_back = ObjectAnimator.ofFloat(enemy5, "translationY", 0);
                        enemy_2_back.setDuration(1);
                        enemy_2_back.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_2_back.start();


                        ObjectAnimator enemy_2 = ObjectAnimator.ofFloat(enemy5, "translationY",900);
                        enemy_2.setDuration(dur5*9/10);
                        enemy_2.setInterpolator(new AccelerateDecelerateInterpolator());
                        enemy_2.setStartDelay(300);
                        enemy_2.start();

                        ObjectAnimator show_e_1 = ObjectAnimator.ofFloat(enemy5, "alpha", 0.0f, 1.0f);
                        show_e_1.setDuration(20);
                       // show_e_1.setStartDelay(1100- SSDelay);
                        show_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
                        show_e_1.start();
                    }

                    x5 = x5 - 1;
                    if( x5==2050) {


                        ObjectAnimator hide_e_2 = ObjectAnimator.ofFloat(enemy5, "alpha", 1.0f, 0.0f);
                        hide_e_2.setDuration(20);
                        hide_e_2.setInterpolator(new AccelerateDecelerateInterpolator());
                        hide_e_2.start();

                    }


                    if(x5 <=440 && x5 >=420) {
                        if (player == -5) {


                                score = score - dam;
                                score1.setText(String.valueOf(score));

                                    break_vbr1();
                        }
                    }
                    if (x5 == 400){
                        score +=1;
                        score1.setText(String.valueOf(score));
                        x5 = 500;

                        if (mTimer5 != null) {
                            mTimer5.cancel();
                            mTimer5 = null;
                        }



                        Random rnd1 = new Random(System.currentTimeMillis());
                        count = min_r5 + rnd1.nextInt(max_r5 - min_r5 + 1);
                        if(count == 1)
                            enemy5.setImageResource(R.drawable.ic_enemy5_5);      //1 скин врага
                        if(count == 2)
                            enemy5.setImageResource(R.drawable.ic_enemy555); // 2 скин врага

                        Random rnd = new Random(System.currentTimeMillis());
// Получаем случайное число в диапазоне от min до max (включительно)
                        count = min + rnd.nextInt(max - min + 1);

                        dur5 = 100*(30+count-timeDealy);
                        mTimer5 = new Timer(); //объявляем новый таймер
                        m5MyTimerTask = new MyTimerTask5(); // новая задача таймера
                        mTimer5.schedule(m5MyTimerTask, SSDelay, 30 + count - timeDealy);

                    }
                }
            });
        }
    }


    class MyTimerTask6 extends TimerTask { //ТАЙМЕР Х6

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    time++;
                     score2.setText(String.valueOf(time));
                     if(time == 20) {
                         timeDealy +=4;
                         SSDelay+=50;
                     }
                    if(time == 60) {
                        timeDealy+=4;
                        SSDelay+=100;
                    }

                    if(time == 100) {
                        timeDealy+=4;
                      dam = dam +2;
                    }
                     if(time%10 ==0) {
                         ultimate.setClickable(true);
                         ulta.setText("1");
                     }



                     if(score <= 0){
                         //vibrator.cancel();

                         if (mTimer1 != null) {
                             mTimer1.cancel();
                             mTimer1 = null;
                         }
                         if (mTimer2 != null) {
                             mTimer2.cancel();
                             mTimer2 = null;
                         }
                         if (mTimer3 != null) {
                             mTimer3.cancel();
                             mTimer3 = null;
                         }
                         if (mTimer4 != null) {
                             mTimer4.cancel();
                             mTimer4 = null;
                         }
                         if (mTimer5 != null) {
                             mTimer5.cancel();
                             mTimer5 = null;
                         }

                         if (mTimer6 != null) {
                             mTimer6.cancel();
                             mTimer6 = null;
                         }

                         Intent intent114 = new Intent(game.this, game2.class);
                         intent114.putExtra("time", String.valueOf(time));
                         startActivity(intent114);
                        // intent114.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                         overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
                        // finishActivity();
                       // player5.stop();
                     finish();
                    }

                    }
            });
        }
    }

    class MyTimerTask7 extends TimerTask { //ТАЙМЕР Х7 ( ульта)

        @Override
        public void run() {


            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    right.setClickable(true);
                    left.setClickable(true);
                    player = ult;

                    ObjectAnimator show_e_1 = ObjectAnimator.ofFloat(player1, "alpha", 0.3f, 1.0f);
                    show_e_1.setDuration(200);
                    // show_e_1.setStartDelay(20);
                    show_e_1.setInterpolator(new AccelerateDecelerateInterpolator());
                    show_e_1.start();

                }
            });
        }
    }



    public void break_vbr1(){
        fg++;
        if(fg%5 ==0) {
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(25);

            }
            Drawable drawable = player1.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    vibrator.cancel();

                }
            }, SPLASH_TIME_OUT);
        }
    }

//
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    private void break_vbr() {
//        // 1000 : Vibrate for 1 sec
//        // VibrationEffect.DEFAULT_AMPLITUDE - would perform vibration at full strength
//        VibrationEffect effect = VibrationEffect.createOneShot(2, VibrationEffect.DEFAULT_AMPLITUDE);
//        vibrator.vibrate(effect);
//    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mTimer1 != null) {
            mTimer1.cancel();
            mTimer1 = null;
        }
        if (mTimer2 != null) {
            mTimer2.cancel();
            mTimer2 = null;
        }
        if (mTimer3 != null) {
            mTimer3.cancel();
            mTimer3 = null;
        }
        if (mTimer4 != null) {
            mTimer4.cancel();
            mTimer4 = null;
        }
        if (mTimer5 != null) {
            mTimer5.cancel();
            mTimer5 = null;
        }

        if (mTimer6 != null) {
            mTimer6.cancel();
            mTimer6 = null;
        }
      // player5.stop();
        finish();
        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
    }
}
