package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class code_check extends AppCompatActivity {
    String f_name,mail,code;
    boolean ch;
    Integer black_time = 13;
    private EditText edt4;
    String code2 = "";
    public    String dir = "storage/emulated/0/Download/";
    Integer PC=0, i =0, j= 0;
    private Button btnOk;

    public void addListenerOnButton() {
        btnOk = (Button) findViewById(R.id.butOk5);
        btnOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        code2 = edt4.getText().toString();
                         checker();
                    }
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_check);
        Intent intent52 = getIntent();
        String page_count = intent52.getStringExtra("page_count");
        f_name = intent52.getStringExtra("f_name");
        edt4 = (EditText) findViewById(R.id.editText10);
        String cot1 = "";
        String cot = "";
        String last_time = "-1____f____null____13";
        String end1;
        String end2 = "|||";
//        grn.add("arc.help.mobile@gmail.com");
//        grn.add("325325325");
//        grn.remove(0);
//        grn.remove(0);
        addListenerOnButton();

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
            tm = cot.substring(0,ind);
            black_time = Integer.valueOf(tm);      //время таймера
            ///вытаскиваю почту
            cot = cot.substring(ind);
            cot = cot.substring(3);
            ind = cot.indexOf("|||");
            mail = cot.substring(0,ind);
            //////////вытаскиваю код доступа
            cot = cot.substring(ind);
            cot = cot.substring(3);
            code = cot;


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
public void checker(){
    char[] alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
    String sym,swap;
    Integer ml = 0;
    Integer id,count,count2;
    Integer min = 0;
    //  boolean chk;
    //   Integer max = mail.length()-1;
    String[] mail3 = new String[mail.length()];

    for(i=0;i<mail.length();i++){ //цикл записывает по символьно почту в строку
        sym = mail.substring(i,i+1);
        if (sym.equals("@")||sym.equals(".")){
            mail3[i] = "";                          //удаляю лишние символы
        }
        else{
            boolean chk = isDigit(sym);
            if(chk){                       //если это цифра
                mail3[i] = "";
            }
            else {
                mail3[i] = sym;
            }

        }
    }

    //преобразование кода/////
    String[] code3 = new String[code2.length()];
    for (i = 0; i<code2.length();i++){
        code3[i] = code2.substring(i,i+1);

    }

    for(j=0; j < code2.length(); j++) {
        for (i = 26; i < 51; i++) {
            if(code3[j].equals(String.valueOf(alphabet[i]))){
//                     Toast.makeText(
//                             SA_2_2.this , mail2[j] + "  " + String.valueOf(alphabet[i+3]),
//                             Toast.LENGTH_SHORT)
//                             .show();
                code3[j] = String.valueOf(alphabet[i-3]);      //расшифровка исходных символов
                break;
            }
        }
    }
    String[] mail4 = new String[code2.length()];
    ArrayList<String> lenght = new ArrayList<String>();
    for(i = 0; i<mail.length(); i++){
        if(mail3[i].equals("")){

        }
        else
        {
           lenght.add(mail3[i]);
           // j++;
        }
    }

    if(lenght.size()!=code3.length){
        Toast.makeText(
                code_check.this, "Неверный код",
                Toast.LENGTH_SHORT)
                .show();
    }
    else {

        j = 0;
        for (i = 0; i < mail.length(); i++) {
            if (mail3[i].equals("")) {

            } else {
                mail4[j] = mail3[i];           //по символьно записанная исходная почта без знаков разделения
                j++;
            }
        }

                        //code2.length()
        Integer joker =0;
        for (j = 0; j < code2.length(); j++) {              //упорядочиваем символы
            for (i = joker; i < code2.length(); i++) {
                if (mail4[j].equals(code3[i])) {
                    swap = code3[i];
                    code3[i] = code3[j];
                    code3[j] = swap;
                    joker++;
                    break;

                }

            }
        }

        String fin1 = "";
        String fin2 = "";
        for (i = 0; i < mail.length(); i++) {
            fin1 = fin1 + mail3[i];
        }

        for (i = 0; i < code2.length(); i++) {
            fin2 = fin2 + code3[i];
        }
        // fin2 = fin2 +"a";
        if (fin1.equals(fin2)) {
            Toast.makeText(
                    code_check.this, "Верный код",
                    Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(
                    code_check.this, "Неверный код",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
    ////////////////////////////////////////////////////////////////
}
private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
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
        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
    }
}
