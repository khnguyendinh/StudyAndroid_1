package study_android1.lampstudio.com.studyandroid_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by VS9 X64Bit on 17/04/2017.
 */

public class UI1 extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui1);
        Button btnBack = (Button) findViewById(R.id.back);
        btnBack.setOnClickListener(this);
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
