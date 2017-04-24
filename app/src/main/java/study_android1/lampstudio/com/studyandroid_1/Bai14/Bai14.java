package study_android1.lampstudio.com.studyandroid_1.Bai14;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Bai14 extends Activity implements View.OnClickListener {
    Button btn_toast, btn_noti, btn_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai14);
        btn_dialog = (Button) findViewById(R.id.btn_dialog);
        btn_noti = (Button) findViewById(R.id.btn_noti);
        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_dialog.setOnClickListener(this);
        btn_noti.setOnClickListener(this);
        btn_toast.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toast:
//                Toast.makeText(Bai14.this, "Show toast", Toast.LENGTH_LONG).show();
                showToast();
                break;
            case R.id.btn_noti:
                showNotification();
                break;
            case R.id.btn_dialog:
//                showDialog();
//                alertErrorNetwork();
//                showDialogList();
                showCustomDialog();
                break;
        }
    }

    private void showToast() {
        LayoutInflater layoutInflater = LayoutInflater.from(Bai14.this);
        View view = layoutInflater.inflate(R.layout.custom_toast, null);
        Toast toast = new Toast(Bai14.this);
        toast.setView(view);
        toast.show();
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
    }
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Bai14.this);
        builder.setMessage("Xin chao");
        builder.setPositiveButton("Closed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create();
        builder.show();

    }
    private void alertErrorNetwork(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Bai14.this);
        builder.setTitle("Khogn co mang");
        builder.setMessage("Ban muon thiet lap mang khong");
        builder.setNegativeButton("Closed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent itent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(itent);
            }
        });
        builder.create();
        builder.show();
    }
    private void showDialogList(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Bai14.this);
        builder.setTitle("dialog lít");
        String[] os = new String[]{"android ","ios ","window phone"};
        builder.setItems(os, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create();
        builder.show();
    }
    public void showCustomDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(Bai14.this);
        View view = layoutInflater.inflate(R.layout.custom_dialog,null);
        Dialog dialog = new Dialog(Bai14.this);
        dialog.setContentView(view);
        dialog.show();
    }
    private void showNotification(){
        NotificationManager notificationManager = (NotificationManager)  getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(Bai14.this);
        builder.setContentTitle("Demo Notification");
        builder.setContentText("day la notification");
        builder.setSmallIcon(R.drawable.chat_icon);
        builder.setAutoCancel(true);
        Intent intent = new Intent(Bai14.this,Notification_activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(Bai14.this,0,intent,0);
        builder.setContentIntent(pendingIntent);
        notificationManager.notify(0,builder.build());
    }
}
