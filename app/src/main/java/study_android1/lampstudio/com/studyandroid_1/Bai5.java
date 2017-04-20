package study_android1.lampstudio.com.studyandroid_1;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by VS9 X64Bit on 20/04/2017.
 */

public class Bai5 extends Activity implements View.OnClickListener{
    TextView textView;
    DatePicker datePicker;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai5);
        textView = (TextView) findViewById(R.id.tv_date_time);
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        datePicker.init(year,month+1,day,onDateChangedListener);
        Button btnback = (Button) findViewById(R.id.back);
        Button btndIALOG = (Button) findViewById(R.id.dialog_pick);
        Button btnTime_dIALOG = (Button) findViewById(R.id.time_dialog);
        TimePicker timePicker = (TimePicker) findViewById(R.id.time_picker);
        btnback.setOnClickListener(this);
        btndIALOG.setOnClickListener(this);
        btnTime_dIALOG.setOnClickListener(this);
        timePicker.setIs24HourView(true);
//        timePicker.setHour(calendar.get(Calendar.HOUR));
//        timePicker.setMinute(calendar.get(Calendar.MINUTE));
        timePicker.setOnTimeChangedListener(timeChangedListener);
    }
    TimePicker.OnTimeChangedListener timeChangedListener = new TimePicker.OnTimeChangedListener() {
        @Override
        public void onTimeChanged(TimePicker timePicker, int houre, int minute) {
            textView.setText(" "+houre+" - "+(minute));
        }
    };
    TimePickerDialog.OnTimeSetListener  onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker,int houre, int minute) {
            textView.setText(" "+houre+" - "+(minute));
        }
    };
    DatePicker.OnDateChangedListener onDateChangedListener = new DatePicker.OnDateChangedListener(){
        @Override
        public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
            textView.setText(" "+day+" - "+(month+1)+" - "+year );
        }
    };
    DatePickerDialog.OnDateSetListener datePickerDialog = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker datePicker, int y, int m, int date) {
            textView.setText(" "+date+" - "+(m+1)+" - "+y );
        }
    };
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                Intent intent = new Intent(this,DemoScrollView.class);
                startActivity(intent);
                break;
            case R.id.dialog_pick:
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DATE);
                new DatePickerDialog(Bai5.this,datePickerDialog,year,month+1,day).show();
                break;
            case R.id.time_dialog:
                calendar = Calendar.getInstance();
                new TimePickerDialog(this,onTimeSetListener,calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),false).show();
                break;
        }
    }
}
