package study_android1.lampstudio.com.studyandroid_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import study_android1.lampstudio.com.studyandroid_1.Bai9.Bai9;
import study_android1.lampstudio.com.studyandroid_1.bai8.Bai8_2;

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
        }
    }
}
