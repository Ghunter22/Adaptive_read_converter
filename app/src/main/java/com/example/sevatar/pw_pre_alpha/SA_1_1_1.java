package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;          /// AIzaSyC50ivW-1OEerFcGAmRrXufpUW_todRp6c
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class SA_1_1_1 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{ //////////воспроизведение видео
    private WebView web;
    String Ws, Com;
    Integer ind = 0;
    String find ="";
    Integer dlina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_1_1_1);
        Intent intent111 = getIntent();

       Ws  = intent111.getStringExtra("Ws");
       Com = intent111.getStringExtra("Com");

        dlina = Ws.length();
         find = Ws.substring(dlina-11);
//        web = (WebView) findViewById(R.id.webView);           //c использованием сайта  PO090-xTmyQ
//
//Ещё
//        WebSettings ws = web.getSettings();
//        ws.setJavaScriptEnabled(true);
//        web.loadUrl(Ws);
//        web.setWebViewClient(new WebViewClient());

//        final VideoView mVideoView = (VideoView) findViewById(R.id.videoView1);
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(mVideoView);
//        mVideoView.setMediaController(mediaController);
//        mVideoView.setVideoPath("https://http://www.youtube.com/watch?v=XSMOykMIO3c");
//        mVideoView.requestFocus();
//        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            public void onPrepared(MediaPlayer mp) {
//                mVideoView.start();
//            }});

        YouTubePlayerView youTubeView = (YouTubePlayerView)
                findViewById(R.id.videoView1);
        youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);


                Toast.makeText(
                        SA_1_1_1.this , Com,
                        Toast.LENGTH_LONG)
                        .show();

    }

    @Override
    public void onBackPressed() {
//        if(web.canGoBack())
//            web.goBack();
//        else
        super.onBackPressed();
        finish();
            overridePendingTransition(R.anim.alpha_back,R.anim.alpha);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) player.cueVideo(find); // your video to play
    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider arg0,
                                        YouTubeInitializationResult arg1){
    }


    public class DeveloperKey {
        /**
         * Please replace this with a valid API key which is enabled for the
         * YouTube Data API v3 service. Go to the
         * <a href=”https://code.google.com/apis/console/“>Google APIs Console</a> to
         * register a new developer key.
         */
        public static final String DEVELOPER_KEY = "AIzaSyC50ivW-1OEerFcGAmRrXufpUW_todRp6c";
    }
}



