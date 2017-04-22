package study_android1.lampstudio.com.studyandroid_1.bai8;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Bai8_2 extends Activity implements View.OnClickListener{
    EditText word;
    EditText mean;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static String name_pref = Bai8_2.class.getName();
    public static String key_pref = Bai8_2.class.getName()+"Key";
    public static String word_pref = Bai8_2.class.getName()+"Word";
    public static String internal_nam = "Internal";
    public static String external_nam = "External";
    ArrayList<ItemModelBai8> arrayList;
    CustomAdapterBai8 customAdapterBai8;
    ListView listView;
    String _word;
    String _mean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai8_2);
        word = (EditText) findViewById(R.id.word);
        mean = (EditText) findViewById(R.id.mean);
        Button btnAdd = (Button) findViewById(R.id.btn_add);
        Button btnShow = (Button) findViewById(R.id.btn_show);
        listView = (ListView) findViewById(R.id.list_view);
        arrayList = new ArrayList<>();
        sharedPreferences = getSharedPreferences(name_pref,MODE_PRIVATE);
        editor = sharedPreferences.edit();
        _word = word.getText().toString();
        _mean = mean.getText().toString();
        btnAdd.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                _word = word.getText().toString();
                _mean = mean.getText().toString();
                if(!_word.equals("") && !_mean.equals("")){
                    saveSharePreference(_word,_mean);
                    word.setText("");
                    mean.setText("");
                    internalSave(_word,_mean);
                }
                break;
            case R.id.btn_show:
                _word = getWord();
                _mean = getDes();
                word.setText(_word);
                mean.setText(_mean);
                Log.d(Bai8_2.class.getName(),"value "+getInternal_nam());
                break;
        }
    }
    public void saveSharePreference(String word ,String des){

        editor.putString(key_pref,word);
        editor.putString(word_pref,des);
        editor.commit();
    }
    public String getWord(){
        return sharedPreferences.getString(key_pref,"");
    }
    public String getDes(){
        return sharedPreferences.getString(word_pref,"");
    }
    public void internalSave(String word,String des){
        try {
            FileOutputStream fileOutputStream = openFileOutput(internal_nam,MODE_PRIVATE);
            String total = "Word "+word+"des "+des;
            fileOutputStream.write(total.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getInternal_nam(){
        try {
            FileInputStream fileInputStream = openFileInput(internal_nam);
            byte[] buffer = new byte[1024];
            fileInputStream.read(buffer);
            fileInputStream.close();
            String data = new String(buffer);
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
