package study_android1.lampstudio.com.studyandroid_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by VS9 X64Bit on 17/04/2017.
 */

public class UI2 extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui2);
        Button btn = (Button) findViewById(R.id.back);
        btn.setOnClickListener(this);
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
