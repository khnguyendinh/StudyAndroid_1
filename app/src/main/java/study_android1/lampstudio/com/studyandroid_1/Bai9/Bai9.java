package study_android1.lampstudio.com.studyandroid_1.Bai9;

import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Bai9 extends Activity implements View.OnClickListener{
    Button btn_contact,btn_music,btn_image;
    ListView listView;
    GridView gridView;
    ArrayList<String> mData;
    ArrayList<Bitmap> mDataB;
    ArrayAdapter<String> adapter;
    CustumAdaptorBai9 adapter9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai9);
        btn_contact = (Button) findViewById(R.id.btn_contact);
        btn_music = (Button) findViewById(R.id.btn_music);
        btn_image = (Button) findViewById(R.id.btn_img);
        listView = (ListView) findViewById(R.id.list_view);
        gridView = (GridView) findViewById(R.id.grid_view);

        btn_contact.setOnClickListener(this);
        btn_music.setOnClickListener(this);
        btn_image.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_contact:
                mData = getContact();
                adapter = new ArrayAdapter<String>(Bai9.this,android.R.layout.simple_list_item_1,mData);
                listView.setAdapter(adapter);
                break;
            case R.id.btn_music:
                mData = getMusic();
                adapter = new ArrayAdapter<String>(Bai9.this,android.R.layout.simple_list_item_1,mData);
                listView.setAdapter(adapter);
                break;
            case R.id.btn_img:
                mDataB = getImage();
                Log.d(Bai9.class.getName(),"count "+mDataB.size());
                adapter9 = new CustumAdaptorBai9(mDataB,Bai9.this);
                gridView.setAdapter(adapter9);
                break;
        }
    }
    public ArrayList<String> getContact(){
        ArrayList<String> data= new ArrayList<>();
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts.DISPLAY_NAME},
                null,null,ContactsContract.Contacts.DISPLAY_NAME+" ASC");
//        CursorLoader cursorLoader = new CursorLoader(Bai9.this,ContactsContract.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts.DISPLAY_NAME},
//                null,null,null);
//        Cursor cursor = cursorLoader.loadInBackground();
        if(cursor != null && cursor.moveToFirst()){
            do {
                String item = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                data.add(item);
            }
            while (cursor.moveToNext());
            Log.d("bai9",data.size()+"");
        }
        return data;
    }
    public ArrayList<String> getMusic() {
        ArrayList<String> data = new ArrayList<>();
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,new String[]{MediaStore.Audio.Media.TITLE},
                null,null,MediaStore.Audio.Media.TITLE+" ASC");
//        CursorLoader cursorLoader = new CursorLoader(Bai9.this,Mus.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts.DISPLAY_NAME},
//                null,null,null);
//        Cursor cursor = cursorLoader.loadInBackground();
        if(cursor != null && cursor.moveToFirst()){
            do {
                String item = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                data.add(item);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public ArrayList<Bitmap> getImage(){
        ArrayList<Bitmap> data = new ArrayList<>();
        CursorLoader cursorLoader = new CursorLoader(Bai9.this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Images.Media._ID},
                null,null,null);
        Cursor cursor = cursorLoader.loadInBackground();
        Log.d(Bai9.class.getName(),"index start ");
        if(cursor != null && cursor.moveToFirst()){
            int count =0 ;
            do {
                int item = cursor.getInt(cursor.getColumnIndex(MediaStore.Images.Media._ID));
                Log.d(Bai9.class.getName(),"index "+item);
                data.add(MediaStore.Images.Thumbnails.getThumbnail(getContentResolver(),item, MediaStore.Images.Thumbnails.MICRO_KIND,
                        null));
                count++;
            }
            while (cursor.moveToNext() && count <= 5);
        }

        return data;
    }
}
