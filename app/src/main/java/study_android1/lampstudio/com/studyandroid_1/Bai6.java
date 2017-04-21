package study_android1.lampstudio.com.studyandroid_1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.bai6.CustomAdapter;
import study_android1.lampstudio.com.studyandroid_1.bai6.ItemModel;

/**
 * Created by VS9 X64Bit on 20/04/2017.
 */

public class Bai6 extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener{
    EditText name;
    Button btnShow;
    ListView listView;
    ArrayList<ItemModel> data;
    CustomAdapter arrayAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai6);
        name = (EditText) findViewById(R.id.name);
        btnShow = (Button) findViewById(R.id.btnShow);
        listView = (ListView) findViewById(R.id.listView);
        ItemModel itemModel1 = new ItemModel("nguyen van A",R.drawable.icon_camera);
        ItemModel itemModel2 = new ItemModel("nguyen van B",R.drawable.icon_camera);
        ItemModel itemModel3 = new ItemModel("nguyen van C",R.drawable.icon_camera);
        ItemModel itemModel4 = new ItemModel("nguyen van D",R.drawable.icon_camera);
        ItemModel itemModel5 = new ItemModel("nguyen van E",R.drawable.icon_camera);
        data = new ArrayList<>();
        data.add(itemModel1);
        data.add(itemModel2);
        data.add(itemModel3);
        data.add(itemModel4);
        data.add(itemModel5);
        arrayAdapter = new CustomAdapter(Bai6.this, data);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        btnShow.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
//        Log.d("click listview","item "+data.get(pos));
    }

    @Override
    public void onClick(View view) {
//        String inpot = name.getText().toString();
//        ItemModel item = new ItemModel(inpot,R.drawable.icon_camera);
//        data.add(item);
//        arrayAdapter.notifyDataSetChanged();
//        Log.d(TAG, "onClick: "+inpot);
    }

}
