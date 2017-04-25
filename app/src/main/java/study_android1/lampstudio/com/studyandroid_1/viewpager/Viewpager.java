package study_android1.lampstudio.com.studyandroid_1.viewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Viewpager extends AppCompatActivity {
    TabLayout tabLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewpager);
        TabLayout.Tab tab1 = tabLayout.newTab().setText("layout 1").setIcon(R.drawable.chat_icon);
        TabLayout.Tab tab2 = tabLayout.newTab().setText("layout 2");
        TabLayout.Tab tab3 = tabLayout.newTab().setText("layout 3");
        TabLayout.Tab tab4 = tabLayout.newTab().setText("layout 4");
        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        tabLayout.addTab(tab4);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),Viewpager.this);
        viewpager.setAdapter(viewPagerAdapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("Viewpager", "pos=" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
