package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //arc.mobile.help@gmail.com
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent116 = new Intent(help.this, Main2Activity.class);
        startActivity(intent116);
        // intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
        overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
        finish();
    }
}
