package study_android1.lampstudio.com.studyandroid_1.Bai12;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * Created by VS9 X64Bit on 23/04/2017.
 */

public class BoundService extends Service {
    static MediaPlayer mediaPlayer;
    LocalBind localBind = new LocalBind();
    public void playMusic(){
        mediaPlayer = MediaPlayer.create(BoundService.this, R.raw.bonghongthuytinh);
        mediaPlayer.start();
    }
    public void StopMusic(){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }
    public int getTotalTime(){
        return mediaPlayer.getDuration()/1000;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBind;
    }
    public class LocalBind extends Binder {
        public BoundService getInstanceBoundService(){
            return BoundService.this;
        }
    }
}
