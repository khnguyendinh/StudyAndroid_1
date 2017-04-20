package study_android1.lampstudio.com.studyandroid_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by VS9 X64Bit on 17/04/2017.
 */

public class UI3 extends AppCompatActivity implements View.OnClickListener{
    LinearLayout btn_switch;
    TextView tv_on,tv_off;
    TabLayout tabLayout;
    private static final String TAG = UI3.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui3);
        Button btnback = (Button) findViewById(R.id.back);
        btnback.setOnClickListener(this);
        View view = findViewById(R.id.btn_switch);
        btn_switch = (LinearLayout) view.findViewById(R.id.btn_switch);
        tv_on = (TextView) btn_switch.findViewById(R.id.tv_on);
        tv_off = (TextView) btn_switch.findViewById(R.id.tv_off);
        tv_on.setOnClickListener(this);
        tv_off.setOnClickListener(this);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        TabLayout.Tab tab1 = tabLayout.newTab().setText("aaa");
        TabLayout.Tab tab2 = tabLayout.newTab().setText("bbb");
        TabLayout.Tab tab3 = tabLayout.newTab().setText("ccc");
        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                Intent itent = new Intent(this,DemoScrollView.class);
                startActivity(itent);
                break;
            case R.id.tv_off:
                Log.d(TAG,"touch tv_off");
                tv_on.setVisibility(View.VISIBLE);
                tv_off.setVisibility(View.INVISIBLE);
                break;
            case R.id.tv_on:
                Log.d(TAG,"touch tv_on");
                tv_off.setVisibility(View.VISIBLE);
                tv_on.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
