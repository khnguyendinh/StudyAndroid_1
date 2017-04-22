package study_android1.lampstudio.com.studyandroid_1.bai10;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Bai10_2 extends Activity {
    TextView tv_infor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai10_2);
        tv_infor = (TextView) findViewById(R.id.tv_infor);
        Intent intent = getIntent();
        if(intent != null){
//            Bundle bundle = intent.getBundleExtra("key_bundle");
//            String name = bundle.getString("user_name");
//            int age = bundle.getInt("tuoi");

//            String name = intent.getExtras().getString("user_name");
//            String age = intent.getExtras().getString("tuoi");
            User user = (User) intent.getExtras().getSerializable("user");
            String name =user.getUser_name();
            int age = user.getAge();
            tv_infor.setText(name+"-"+age);
        }
    }

}
