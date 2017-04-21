package study_android1.lampstudio.com.studyandroid_1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class FootBall extends AppCompatActivity {
    TabLayout tabLayout1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_football);
        tabLayout1 = (TabLayout) findViewById(R.id.tab1_football);
        TabLayout.Tab tabItem1 = tabLayout1.newTab().setText("18/9");
        TabLayout.Tab tabItem2 = tabLayout1.newTab().setText("17/9");
        TabLayout.Tab tabItem3 = tabLayout1.newTab().setText("16/9");
        TabLayout.Tab tabItem4 = tabLayout1.newTab().setText("15/9");
        tabLayout1.addTab(tabItem1);
        tabLayout1.addTab(tabItem2);
        tabLayout1.addTab(tabItem3);
        tabLayout1.addTab(tabItem4);
    }
}
