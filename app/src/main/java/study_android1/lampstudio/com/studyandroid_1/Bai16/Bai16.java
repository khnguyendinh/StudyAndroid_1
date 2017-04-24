package study_android1.lampstudio.com.studyandroid_1.Bai16;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Bai16 extends Activity {
    Button btn_capture,btnsetWallpaper;
    ImageView image;
    Bitmap bitmap;
    Uri uri;
    private static final int REQUEST_CODE = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai16);
        btn_capture = (Button) findViewById(R.id.capture);
        btnsetWallpaper = (Button) findViewById(R.id.btn_setwallpaper);
        image = (ImageView) findViewById(R.id.iamgeView);
        btn_capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = new File("/sdcard/test.png");
                uri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        btnsetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperManager wallpaperManager =  WallpaperManager.getInstance(Bai16.this);
                try {
                    wallpaperManager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//            image.setImageBitmap(bitmap);
            getContentResolver().notifyChange(uri,null);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                image.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
