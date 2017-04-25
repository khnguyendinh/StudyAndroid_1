package study_android1.lampstudio.com.studyandroid_1.AsyntaskDemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import study_android1.lampstudio.com.studyandroid_1.R;

public class AsyncTaskDemo extends Activity {
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_demo);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        new InerClassDemo().execute();
    }
    class InerClassDemo extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {//1
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String aVoid) {//3
            super.onPostExecute(aVoid);
            Toast.makeText(AsyncTaskDemo.this, aVoid, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {//3neu co cap nhat ui
            super.onProgressUpdate(values);
            seekBar.setProgress(values[0]);
        }

        @Override
        protected String doInBackground(String... voids) {//2
            for (int i = 0; i < 100; i++) {
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "1";
        }
    }
}
