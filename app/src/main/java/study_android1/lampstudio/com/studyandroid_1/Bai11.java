package study_android1.lampstudio.com.studyandroid_1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import study_android1.lampstudio.com.studyandroid_1.Bai111.Dat_cuoc;

public class Bai11 extends Activity {
    TextView textView;
    Button dat_cuoc;

    public final static String ACTION_DAT_CUOC = "study_android1.lampstudio.com.s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai11);
//        RegisterPowerConnected();
        RegisterDC();
        textView = (TextView) findViewById(R.id.tv);
        dat_cuoc = (Button) findViewById(R.id.login_dc);
        dat_cuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bai11.this, Dat_cuoc.class);
                startActivity(intent);
            }
        });
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(Bai11.this, "Connect Power", Toast.LENGTH_LONG);
//            textView.setText("connected power");
            String money = intent.getExtras().getString("money_cuoc");
            textView.setText((1000 - Integer.parseInt(money))+"");
        }
    };

    //    void RegisterPowerConnected(){
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
//        registerReceiver(broadcastReceiver,intentFilter);
//    }
//    void UnRegisterPowerConnected(){
//        unregisterReceiver(broadcastReceiver);
//    }
    void RegisterDC() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_DAT_CUOC);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    void UnRegisterDC() {
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UnRegisterDC();
//        UnRegisterPowerConnected();
    }
}
