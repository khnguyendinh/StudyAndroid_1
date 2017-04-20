package study_android1.lampstudio.com.studyandroid_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by VS9 X64Bit on 17/04/2017.
 */

public class UI2 extends Activity implements View.OnClickListener{
    LinearLayout list_red;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui2);
        Button btn = (Button) findViewById(R.id.back);
        btn.setOnClickListener(this);
        list_red = (LinearLayout) findViewById(R.id.list_red);
        layoutInflater = LayoutInflater.from(UI2.this);
//        View view = layoutInflater.inflate(R.layout.item_red,null);
        for (int i = 0; i < 5; i++) {
            View view = layoutInflater.inflate(R.layout.item_red,null);
            list_red.addView(view);
        }
        for (int i = 0; i < list_red.getChildCount(); i++) {
            View view = list_red.getChildAt(i);
            if(i == 0){
                view.setVisibility(View.INVISIBLE);
            }
        }
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
