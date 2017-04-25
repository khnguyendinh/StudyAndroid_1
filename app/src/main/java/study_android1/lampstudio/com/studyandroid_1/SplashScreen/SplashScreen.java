package study_android1.lampstudio.com.studyandroid_1.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicBoolean;

import study_android1.lampstudio.com.studyandroid_1.R;

public class SplashScreen extends AppCompatActivity {
    AtomicBoolean atomic = null;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String number_Button = msg.obj.toString();
                Toast.makeText(SplashScreen.this, "number_Button "+number_Button, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SplashScreen.this, MainSlashScreen.class);
                startActivity(intent);
                finish();
            }
        };
        drawActor();

    }
    private void drawActor() {
        atomic = new AtomicBoolean(false);
        final int numberButton = 5;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberButton && atomic.get(); i++) {
                    //nghỉ 200 mili second
                    SystemClock.sleep(200);
                    //lấy message từ Main Thread
                    if(i == numberButton -1){
                        Message msg = handler.obtainMessage();
                        // gán dữ liệu cho msg Mainthread, lưu vào biến obj
                        //chú ý ta có thể lưu bất kỳ kiểu dữ liệu nào vào obj
                        msg.obj = "Actor  thứ "+i;
                        //gửi trả lại message cho Mainthread
                        handler.sendMessage(msg);
                    }

                }
            }
        });
        atomic.set(true);
        //start thread
        thread.start();
    }


}
