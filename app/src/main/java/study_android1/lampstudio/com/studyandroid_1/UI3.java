package study_android1.lampstudio.com.studyandroid_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by VS9 X64Bit on 17/04/2017.
 */

public class UI3 extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui3);
        Button btnback = (Button) findViewById(R.id.back);
        btnback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                Intent itent = new Intent(this,DemoScrollView.class);
                startActivity(itent);
                break;
        }
    }
}
