package study_android1.lampstudio.com.studyandroid_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by VS9 X64Bit on 17/04/2017.
 */

public class UI7 extends AppCompatActivity implements View.OnClickListener{
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui7);
        Button btnBack = (Button) findViewById(R.id.back);
        btnBack.setOnClickListener(this);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        TabLayout.Tab tab1 = tabLayout.newTab().setText("Trang chủ").setIcon(R.drawable.setting_icon);
        TabLayout.Tab tab2 = tabLayout.newTab().setText("Phân loại").setIcon(R.drawable.chat_icon);
        TabLayout.Tab tab3 = tabLayout.newTab().setText("Khám phá ").setIcon(R.drawable.chat_icon);
        TabLayout.Tab tab4 = tabLayout.newTab().setText("Đăng nhập").setIcon(R.drawable.chat_icon);
        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        tabLayout.addTab(tab4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                Intent intent = new Intent(this,DemoScrollView.class);
                startActivity(intent);
                break;
        }
    }
}
