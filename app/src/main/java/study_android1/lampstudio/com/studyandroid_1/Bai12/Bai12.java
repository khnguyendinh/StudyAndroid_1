package study_android1.lampstudio.com.studyandroid_1.Bai12;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Bai12 extends AppCompatActivity implements View.OnClickListener{
    Button btn_start,btn_stop;
    BoundService boundService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai12);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        Intent intentBoundSevice = new Intent(Bai12.this,BoundService.class);
        bindService(intentBoundSevice, serviceConnection,BIND_AUTO_CREATE);
    }
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BoundService.LocalBind localBind = (BoundService.LocalBind) iBinder;
            boundService = localBind.getInstanceBoundService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
//                boundService.playMusic();
//                Log.d("Bai12","time "+boundService.getTotalTime());
                Intent intentStart = new Intent(Bai12.this,StartedService.class);
                startService(intentStart);

                break;
            case R.id.btn_stop:
//                boundService.StopMusic();
                Intent intentStop = new Intent(Bai12.this,StartedService.class);
                stopService(intentStop);
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
