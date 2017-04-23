package study_android1.lampstudio.com.studyandroid_1.Bai12;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.util.Log;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * Created by VS9 X64Bit on 23/04/2017.
 */

public class StartedService extends IntentService {
    MediaPlayer mediaPlayer;
    public StartedService() {
        super(StartedService.class.getName());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(StartedService.class.getName(),"started service");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(StartedService.class.getName(),"onStartCommand service");
        mediaPlayer = MediaPlayer.create(StartedService.this, R.raw.bonghongthuytinh);
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(StartedService.class.getName(),"onHandleIntent service");

    }

    @Override
    public void onDestroy() {
        Log.d(StartedService.class.getName(),"onDestroy service");
        mediaPlayer.stop();
        super.onDestroy();
    }
}
