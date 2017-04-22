package study_android1.lampstudio.com.studyandroid_1;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.bai8.CustomAdapterBai8;
import study_android1.lampstudio.com.studyandroid_1.bai8.ItemModelBai8;
import study_android1.lampstudio.com.studyandroid_1.bai8.SqliteDatabase;

import static study_android1.lampstudio.com.studyandroid_1.bai8.SqliteDatabase.columMean;
import static study_android1.lampstudio.com.studyandroid_1.bai8.SqliteDatabase.columWord;

/**
 * Created by VS9 X64Bit on 22/04/2017.
 */

public class Bai8 extends AppCompatActivity implements View.OnClickListener{
    SqliteDatabase sqliteDatabase;
    EditText word;
    EditText mean;
    ArrayList<ItemModelBai8> arrayList;
    CustomAdapterBai8 customAdapterBai8;
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai8);
        word = (EditText) findViewById(R.id.word);
        mean = (EditText) findViewById(R.id.mean);
        Button btnAdd = (Button) findViewById(R.id.btn_add);
        Button btnShow = (Button) findViewById(R.id.btn_show);
        listView = (ListView) findViewById(R.id.list_view);
        sqliteDatabase = new SqliteDatabase(Bai8.this);
        btnAdd.setOnClickListener(this);
        btnShow.setOnClickListener(this);
        arrayList = new ArrayList<>();
        ShowData();
    }
    public void ShowData(){

            String sql = "SELECT * FROM "+SqliteDatabase.tableDictionary;
            Cursor cursor = sqliteDatabase.Rawquery(sql);
            if(cursor != null && cursor.moveToFirst()){
                do{
                    int ID = cursor.getInt(cursor.getColumnIndex(SqliteDatabase.columID));
                    String word = cursor.getString(cursor.getColumnIndex(SqliteDatabase.columWord));
                    String mean = cursor.getString(cursor.getColumnIndex(SqliteDatabase.columMean));
                    ItemModelBai8 itemModelBai8 = new ItemModelBai8(String.valueOf(ID),word,mean);
                    arrayList.add(itemModelBai8);
                }
                while(cursor.moveToNext());
            }
        customAdapterBai8 = new CustomAdapterBai8(Bai8.this,arrayList);
        listView.setAdapter(customAdapterBai8);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sqliteDatabase.RemoveRecord(new String[]{String.valueOf(i)});
                arrayList.remove(i);
                customAdapterBai8.notifyDataSetChanged();
//                ((CustomAdapterBai8)listView.getAdapter()).notifyDataSetChanged();
//                ContentValues contentValues = new ContentValues();
//                contentValues.put(SqliteDatabase.columWord,"HI");
//                sqliteDatabase.UpdateRecord(contentValues,new String[]{String.valueOf(1)});
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                String _word = word.getText().toString();
                String _mean = mean.getText().toString();
                if(!_word.equals("") && !_mean.equals("")){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(columWord,_word);
                    contentValues.put(columMean,_mean);
                    sqliteDatabase.InsertRecord(contentValues);
                    ItemModelBai8 item = new ItemModelBai8((arrayList.size()+1)+"",_word,_mean);
                    arrayList.add(item);
                    customAdapterBai8.notifyDataSetChanged();
                }
                break;
            case R.id.btn_show:
                ShowData();
                break;
        }
    }
}
