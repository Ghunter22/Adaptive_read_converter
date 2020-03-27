package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class prog extends AppCompatActivity {
    PDFView inst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst);
        inst = (PDFView) findViewById(R.id.pdfView);
        inst.fromAsset("prog.pdf")
                .scrollHandle(new DefaultScrollHandle(this))
                //   .enableSwipe(true)
                //   .onLoad(this)
                // .defaultPage(def_page)
                //  .onPageChange(this)
                // .onPageScroll(this)
                // .onTap(this)
                .load();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent116 = new Intent(prog.this, Main2Activity.class);
        startActivity(intent116);
        // intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
        overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
        finish();
    }
}
