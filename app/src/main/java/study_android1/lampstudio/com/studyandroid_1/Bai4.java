package study_android1.lampstudio.com.studyandroid_1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

/**
 * Created by VS9 X64Bit on 20/04/2017.
 */

public class Bai4 extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai4);
        Button btnback = (Button) findViewById(R.id.back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itent = new Intent(Bai4.this,DemoScrollView.class);
                startActivity(itent);
            }
        });
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        WebView webView = (WebView) findViewById(R .id.webview);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                progressBar.setVisibility(View.GONE);
            }
        });
        webView.loadUrl("https://vnexpress.net");
        videoView = (VideoView) findViewById(R.id.videoview);
//        String url = "http://zmp3-mp3-mv1-te-zmp3-fpthn-2.zadn.vn/39c933f80dbde4e3bdac/25455058347140322?key=AMB_G_LUkstqYoVwktFssA&expires=1492679206";
//        videoView.setVideoPath(url);
        String path = "android.resource://"+getPackageName()+"/"+R.raw.demo_video;
        videoView.setVideoURI(Uri.parse(path));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                progressBar.setVisibility(View.GONE);
                videoView.start();
            }
        });
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

    }
}
