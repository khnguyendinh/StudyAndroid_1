package study_android1.lampstudio.com.studyandroid_1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.RecycleView.AdapterRecycle;
import study_android1.lampstudio.com.studyandroid_1.RecycleView.ItemModelRecycle;

public class RecycleViewCardView extends Activity {
    RecyclerView recyclerView;
    ArrayList<ItemModelRecycle> datas;
    AdapterRecycle adapterRecycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_card_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        datas =  new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemModelRecycle itemModelRecycle = new ItemModelRecycle("name "+i,R.drawable.star);
            datas.add(itemModelRecycle);
        }
        adapterRecycle = new AdapterRecycle(datas,RecycleViewCardView.this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecycleViewCardView.this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(RecycleViewCardView.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRecycle);
    }

}
