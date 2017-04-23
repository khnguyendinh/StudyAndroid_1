package study_android1.lampstudio.com.studyandroid_1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.football.CustomAdapterFB;
import study_android1.lampstudio.com.studyandroid_1.football.InforChampang;
import study_android1.lampstudio.com.studyandroid_1.football.Informatch;
import study_android1.lampstudio.com.studyandroid_1.football.ItemFootBall;

public class FootBall extends AppCompatActivity {
    TabLayout tabLayout1 ;
    ListView listView;
    ArrayList<ItemFootBall> data;
    CustomAdapterFB arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_football);
        tabLayout1 = (TabLayout) findViewById(R.id.tab1_football);
        TabLayout.Tab tabItem1 = tabLayout1.newTab().setText("18/9");
        TabLayout.Tab tabItem2 = tabLayout1.newTab().setText("17/9");
        TabLayout.Tab tabItem3 = tabLayout1.newTab().setText("16/9");
        TabLayout.Tab tabItem4 = tabLayout1.newTab().setText("15/9");
        tabLayout1.addTab(tabItem1);
        tabLayout1.addTab(tabItem2);
        tabLayout1.addTab(tabItem3);
        tabLayout1.addTab(tabItem4);
        listView = (ListView) findViewById(R.id.lv_fb);
        InforChampang c1 = new InforChampang("19-10","C1");
        InforChampang c2 = new InforChampang("19-10","C2");
        InforChampang c3= new InforChampang("19-10","C3");
        data =new ArrayList<>();
        Informatch informatch = new Informatch("a","b",1,2,true,false, Informatch.STATUS.AET);
        ItemFootBall itemFootBall1 = new ItemFootBall(ItemFootBall.TYPE_FB.TITLE,informatch,c1);
        ItemFootBall itemFootBall2 = new ItemFootBall(ItemFootBall.TYPE_FB.TITLE,informatch,c2);
        ItemFootBall itemFootBall3 = new ItemFootBall(ItemFootBall.TYPE_FB.MATCH,informatch,c3);
        ItemFootBall itemFootBall4 = new ItemFootBall(ItemFootBall.TYPE_FB.MATCH,informatch,c3);
        ItemFootBall itemFootBall5 = new ItemFootBall(ItemFootBall.TYPE_FB.MATCH,informatch,c3);
        ItemFootBall itemFootBall6 = new ItemFootBall(ItemFootBall.TYPE_FB.MATCH,informatch,c3);
        ItemFootBall itemFootBall7 = new ItemFootBall(ItemFootBall.TYPE_FB.MATCH,informatch,c3);
        ItemFootBall itemFootBall8 = new ItemFootBall(ItemFootBall.TYPE_FB.MATCH,informatch,c3);
        data.add(itemFootBall1);
        data.add(itemFootBall2);
        data.add(itemFootBall3);
        data.add(itemFootBall4);
        data.add(itemFootBall5);
        data.add(itemFootBall6);
        data.add(itemFootBall7);
        data.add(itemFootBall8);
        arrayAdapter = new CustomAdapterFB(FootBall.this, data);
        listView.setAdapter(arrayAdapter);
    }
}
