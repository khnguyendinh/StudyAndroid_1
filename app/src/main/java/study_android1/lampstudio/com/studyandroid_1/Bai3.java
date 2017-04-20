package study_android1.lampstudio.com.studyandroid_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

/**
 * Created by VS9 X64Bit on 20/04/2017.
 */

public class Bai3 extends Activity implements CompoundButton.OnCheckedChangeListener,RadioGroup.OnCheckedChangeListener , View.OnClickListener{

    CheckBox android;
    RadioButton ios;
    RadioButton window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3);
        android  = (CheckBox) findViewById(R.id.android);
        ios = (RadioButton) findViewById(R.id.ios);
        window = (RadioButton) findViewById(R.id.windowPhone);
        ios.setChecked(true);
        window.setChecked(true);
        android.setOnCheckedChangeListener(this);
        ios.setOnCheckedChangeListener(this);
        window.setOnCheckedChangeListener(this);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioG);
        radioGroup.setOnCheckedChangeListener(this);
        ImageButton imageButton = (ImageButton) findViewById(R.id.btnImg);
        imageButton.setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("seekbar ","change value "+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("seekbar ","start value "+seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("seekbar ","stop value "+seekBar.getProgress());
            }
        });
//        btn_switch.setOnClickListener(this);

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()){
            case R.id.android:
                if(!isChecked){
                    ios.setChecked(false);
                }
                ios.setChecked(false);
                window.setChecked(false);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int idcheck) {
        switch (idcheck){
            case R.id.ios:
                android.setChecked(true);
                break;
            case R.id.windowPhone:
                android.setChecked(false);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        Log.d("dasd","touch khoand");
        switch (view.getId()){
            case R.id.btnImg:
                Log.d("asdad","touch khoand2");
                ios.setChecked(false);
                window.setChecked(false);
                android.setChecked(false);
                Intent intent =  new Intent(this,DemoScrollView.class);
                startActivity(intent);
                break;

        }
    }
}
