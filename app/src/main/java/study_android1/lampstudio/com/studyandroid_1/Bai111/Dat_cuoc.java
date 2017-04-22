package study_android1.lampstudio.com.studyandroid_1.Bai111;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import study_android1.lampstudio.com.studyandroid_1.Bai11;
import study_android1.lampstudio.com.studyandroid_1.R;

public class Dat_cuoc extends Activity {
    EditText dat_money;
    Button btn_dat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_cuoc);
        dat_money = (EditText) findViewById(R.id.dat_cuoc);
        btn_dat = (Button) findViewById(R.id.btn_dc);
        btn_dat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dat_cuoc.this, Bai11.class);
                Intent intentDC= new Intent( Bai11.ACTION_DAT_CUOC);
                intentDC.putExtra("money_cuoc",dat_money.getText().toString());
                sendBroadcast(intentDC);
//                startActivity(intent);
                String cuoc = dat_money.getText().toString();
            }
        });
    }

}
