package study_android1.lampstudio.com.studyandroid_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import study_android1.lampstudio.com.studyandroid_1.AsyntaskDemo.AsyncTaskDemo;
import study_android1.lampstudio.com.studyandroid_1.Bai12.Bai12;
import study_android1.lampstudio.com.studyandroid_1.Bai13.Bai13;
import study_android1.lampstudio.com.studyandroid_1.Bai14.Bai14;
import study_android1.lampstudio.com.studyandroid_1.Bai15.Bai15;
import study_android1.lampstudio.com.studyandroid_1.Bai16.Bai16;
import study_android1.lampstudio.com.studyandroid_1.Bai9.Bai9;
import study_android1.lampstudio.com.studyandroid_1.Fragment.Fragment;
import study_android1.lampstudio.com.studyandroid_1.Handler.ThreadHandlerDemo;
import study_android1.lampstudio.com.studyandroid_1.SplashScreen.SplashScreen;
import study_android1.lampstudio.com.studyandroid_1.bai10.Bai10;
import study_android1.lampstudio.com.studyandroid_1.bai8.Bai8_2;
import study_android1.lampstudio.com.studyandroid_1.viewpager.Viewpager;
import study_android1.lampstudio.com.studyandroid_1.volley.VolleyDemo;

/**
 * Created by VS9 X64Bit on 19/04/2017.
 */

public class DemoScrollView extends AppCompatActivity implements View.OnClickListener{
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_scroll_view);
        Button btnUi1 = (Button) findViewById(R.id.ui1);
        Button btnUi2 = (Button) findViewById(R.id.ui2);
        Button btnUi3 = (Button) findViewById(R.id.ui3);
        Button btnUi4 = (Button) findViewById(R.id.ui4);
        Button btnUi5 = (Button) findViewById(R.id.ui5);
        Button btnUi6 = (Button) findViewById(R.id.ui6);
        Button btnUi7 = (Button) findViewById(R.id.ui7);
        Button btnBai3 = (Button) findViewById(R.id.bai3);
        Button btnHorizontall = (Button) findViewById(R.id.horizoltal);
        Button btnBai4 = (Button) findViewById(R.id.bai4);
        Button btnBai5 = (Button) findViewById(R.id.bai5);
        Button btnBai6 = (Button) findViewById(R.id.bai6);
        Button btnDV = (Button) findViewById(R.id.ui_datve);
        Button btnFB = (Button) findViewById(R.id.ui_football);
        Button btnBai7 = (Button) findViewById(R.id.bai7);
        Button btnBai8 = (Button) findViewById(R.id.bai8);
        Button btnBai8_2 = (Button) findViewById(R.id.bai8_2);
        Button btnBai9 = (Button) findViewById(R.id.bai9);
        Button btnBai10 = (Button) findViewById(R.id.bai10);
        Button btnBai11 = (Button) findViewById(R.id.bai11);
        Button btnBai12 = (Button) findViewById(R.id.bai12);
        Button btnBai13 = (Button) findViewById(R.id.bai_13);
        Button btnBai14 = (Button) findViewById(R.id.bai_14);
        Button btnBai15 = (Button) findViewById(R.id.bai_15);
        Button btnBai16 = (Button) findViewById(R.id.bai_16);
        Button btnFragMent = (Button) findViewById(R.id.fragment);
        Button btnAsyntask = (Button) findViewById(R.id.asyntask);
        Button btnHanler = (Button) findViewById(R.id.handler);
        Button btnViewpage = (Button) findViewById(R.id.viewpager);
        Button btnBaiRecycle = (Button) findViewById(R.id.bai_recycle_view);
        Button btnSlashScreen = (Button) findViewById(R.id.slashhscreen);
        Button btnVolley = (Button) findViewById(R.id.volleyDemo);
        btnUi1.setOnClickListener(this);
        btnUi2.setOnClickListener(this);
        btnUi3.setOnClickListener(this);
        btnUi4.setOnClickListener(this);
        btnUi5.setOnClickListener(this);
        btnUi6.setOnClickListener(this);
        btnUi7.setOnClickListener(this);
        btnHorizontall.setOnClickListener(this);
        btnBai3.setOnClickListener(this);
        btnBai4.setOnClickListener(this);
        btnBai5.setOnClickListener(this);
        btnBai6.setOnClickListener(this);
        btnDV.setOnClickListener(this);
        btnFB.setOnClickListener(this);
        btnBai7.setOnClickListener(this);
        btnBai8.setOnClickListener(this);
        btnBai8_2.setOnClickListener(this);
        btnBai9.setOnClickListener(this);
        btnBai10.setOnClickListener(this);
        btnBai11.setOnClickListener(this);
        btnBai12.setOnClickListener(this);
        btnBaiRecycle.setOnClickListener(this);
        btnBai13.setOnClickListener(this);
        btnBai14.setOnClickListener(this);
        btnBai15.setOnClickListener(this);
        btnBai16.setOnClickListener(this);
        btnFragMent.setOnClickListener(this);
        btnViewpage.setOnClickListener(this);
        btnAsyntask.setOnClickListener(this);
        btnHanler.setOnClickListener(this);
        btnSlashScreen.setOnClickListener(this);
        btnVolley.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ui1:
                intent = new Intent(this,UI1.class);
                startActivity(intent);
                break;
            case R.id.ui2:
                intent = new Intent(this,UI2.class);
                startActivity(intent);
                break;
            case R.id.ui3:
                intent = new Intent(this,UI3.class);
                startActivity(intent);
                break;
            case R.id.ui4:
                intent = new Intent(this,UI4.class);
                startActivity(intent);
                break;
            case R.id.ui5:
                intent = new Intent(this,UI5.class);
                startActivity(intent);
                break;
            case R.id.ui6:
                intent = new Intent(this,UI6.class);
                startActivity(intent);
                break;
            case R.id.ui7:
                intent = new Intent(this,UI7.class);
                startActivity(intent);
                break;
            case R.id.horizoltal:
                intent = new Intent(this,HorizontalScrollview.class);
                startActivity(intent);
                break;
            case R.id.bai3:
                intent = new Intent(this,Bai3.class);
                startActivity(intent);
                break;
            case R.id.bai4:
                intent = new Intent(this,Bai4.class);
                startActivity(intent);
                break;
            case R.id.bai5:
                intent = new Intent(this,Bai5.class);
                startActivity(intent);
                break;
            case R.id.bai6:
                intent = new Intent(this,Bai6.class);
                startActivity(intent);
                break;
            case R.id.ui_datve:
                intent = new Intent(this,UI_dat_ve.class);
                startActivity(intent);
                break;
            case R.id.ui_football:
                intent = new Intent(this,FootBall.class);
                startActivity(intent);
                break;
            case R.id.bai7:
                intent = new Intent(this,Bai7.class);
                startActivity(intent);
                break;
            case R.id.bai8:
                intent = new Intent(this,Bai8.class);
                startActivity(intent);
                break;
            case R.id.bai8_2:
                intent = new Intent(this,Bai8_2.class);
                startActivity(intent);
                break;
            case R.id.bai9:
                intent = new Intent(this,Bai9.class);
                startActivity(intent);
                break;
            case R.id.bai10:
                intent = new Intent(this,Bai10.class);
                startActivity(intent);
                break;
            case R.id.bai11:
                intent = new Intent(this,Bai11.class);
                startActivity(intent);
                break;
            case R.id.bai12:
                intent = new Intent(this,Bai12.class);
                startActivity(intent);
                break;
            case R.id.bai_recycle_view:
                intent = new Intent(this,RecycleViewCardView.class);
                startActivity(intent);
                break;
            case R.id.bai_13:
                intent = new Intent(this,Bai13.class);
                startActivity(intent);
                break;
            case R.id.bai_14:
                intent = new Intent(this,Bai14.class);
                startActivity(intent);
                break;
            case R.id.bai_15:
                intent = new Intent(this,Bai15.class);
                startActivity(intent);
                break;
            case R.id.bai_16:
                intent = new Intent(this,Bai16.class);
                startActivity(intent);
                break;
            case R.id.fragment:
                intent = new Intent(this,Fragment.class);
                startActivity(intent);
                break;
            case R.id.viewpager:
                intent = new Intent(this,Viewpager.class);
                startActivity(intent);
                break;
            case R.id.asyntask:
                intent = new Intent(this,AsyncTaskDemo.class);
                startActivity(intent);
                break;
            case R.id.handler:
                intent = new Intent(this,ThreadHandlerDemo.class);
                startActivity(intent);
                break;
            case R.id.slashhscreen:
                intent = new Intent(this,SplashScreen.class);
                startActivity(intent);
                break;
            case R.id.volleyDemo:
                intent = new Intent(this,VolleyDemo.class);
                startActivity(intent);
                break;
        }
    }
}
