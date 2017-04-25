package study_android1.lampstudio.com.studyandroid_1.Handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import java.util.concurrent.atomic.AtomicBoolean;

import study_android1.lampstudio.com.studyandroid_1.R;

public class ThreadHandlerDemo extends AppCompatActivity {

    Button btnDrawBtutton;
    Handler handler;
    EditText edtNumberButton;
    AtomicBoolean atomic = null;
    LinearLayout lnListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_handler_demo);

        btnDrawBtutton = (Button) findViewById(R.id.btnDraw);
        lnListButton = (LinearLayout) findViewById(R.id.lnListButton);
        edtNumberButton = (EditText) findViewById(R.id.edtNumber);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //Nhận nhãn của Button được gửi về từ tiến trình con
                String number_Button = msg.obj.toString();
                //Khởi tạo 1 Button
                Button button = new Button(ThreadHandlerDemo.this);
                //Thiết lập text cho Button
                button.setText(number_Button);
                //thiết lập kiểu Layout : Width, Height
                LayoutParams params = new
                        LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
                //thiết lập layout cho Button
                button.setLayoutParams(params);
                //đưa Button vào layoutdevebutton
                lnListButton.addView(button);
            }
        };

        btnDrawBtutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawActor();
            }
        });

    }

    private void drawActor() {
        atomic = new AtomicBoolean(false);
        final int numberButton = Integer.parseInt(edtNumberButton.getText().toString());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberButton && atomic.get(); i++) {
                    //nghỉ 200 mili second
                    SystemClock.sleep(200);
                    //lấy message từ Main Thread
                    Message msg = handler.obtainMessage();
                    // gán dữ liệu cho msg Mainthread, lưu vào biến obj
                    //chú ý ta có thể lưu bất kỳ kiểu dữ liệu nào vào obj
                    msg.obj = "Actor  thứ "+i;
                    //gửi trả lại message cho Mainthread
                    handler.sendMessage(msg);
                }
            }
        });
        atomic.set(true);
        //start thread
        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}