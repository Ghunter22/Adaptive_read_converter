package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class SA_1_1_4 extends AppCompatActivity {
    String Ws, Com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_1_1_4);
        Intent intent113 = getIntent();

        Ws  = intent113.getStringExtra("Ws");
        Com = intent113.getStringExtra("Com");
        String txt = Com;
        TextView textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod()); // для возможности прокрутки текста
        textView.setText(txt);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
    }

}
