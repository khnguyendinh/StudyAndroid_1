package study_android1.lampstudio.com.studyandroid_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.bai7.CustomAdapter7;
import study_android1.lampstudio.com.studyandroid_1.bai7.ItemModel7;

public class Bai7 extends AppCompatActivity {
    GridView gridView;
    ArrayList<ItemModel7> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai7);
        gridView = (GridView) findViewById(R.id.grid_view);
        arrayList =new ArrayList<>();
        ItemModel7 itemModel71 = new ItemModel7("nguyen van A",R.drawable.avatar_circle);
        ItemModel7 itemModel72 = new ItemModel7("nguyen van B",R.drawable.avatar_circle);
        ItemModel7 itemModel73 = new ItemModel7("nguyen van C",R.drawable.avatar_circle);;
        ItemModel7 itemModel74 = new ItemModel7("nguyen van D",R.drawable.avatar_circle);
        ItemModel7 itemModel75 = new ItemModel7("nguyen van E",R.drawable.avatar_circle);
        ItemModel7 itemModel76 = new ItemModel7("nguyen van F",R.drawable.avatar_circle);
        arrayList.add(itemModel71);
        arrayList.add(itemModel72);
        arrayList.add(itemModel73);
        arrayList.add(itemModel74);
        arrayList.add(itemModel75);
        arrayList.add(itemModel76);
        CustomAdapter7 adapter = new CustomAdapter7(Bai7.this,arrayList);
        gridView.setAdapter(adapter);

    }
}
