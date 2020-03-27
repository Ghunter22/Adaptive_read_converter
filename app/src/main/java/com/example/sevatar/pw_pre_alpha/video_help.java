package com.example.sevatar.pw_pre_alpha;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class video_help  extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{ //////////воспроизведение видео
    private WebView web;
    String Ws, Com;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_help);

        Ws  = "UJm0Fniqxd4";
//      //  String videoSource ="android.resource://com.example.sevatar.pw_pre_alpha.views/" + R.raw.inst;
//        VideoView videoView = (VideoView) findViewById(R.id.videoView);
//        videoView.setKeepScreenOn(true);
//        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.inst));
//        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);
//        videoView.requestFocus(0);
//        videoView.start();
//        web = (WebView) findViewById(R.id.webView);           //c использованием сайта
//        WebSettings ws = web.getSettings();
//        ws.setJavaScriptEnabled(true);
//        web.loadUrl(Ws);
//        web.setWebViewClient(new WebViewClient())
//
// ;
        YouTubePlayerView youTubeView = (YouTubePlayerView)
                findViewById(R.id.videoView1);
        youTubeView.initialize(SA_1_1_1.DeveloperKey.DEVELOPER_KEY, this);
    }

    @Override
    public void onBackPressed() {
//        if(web.canGoBack())
//            web.goBack();
//        else
            super.onBackPressed();
        Intent intent116 = new Intent(video_help.this, inst.class);
        startActivity(intent116);
        // intent116.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
        overridePendingTransition(R.anim.alpha_back, R.anim.alpha);
        finish();
    }



    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) player.cueVideo(Ws); // your video to play
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
