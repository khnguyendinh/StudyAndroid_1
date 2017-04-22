package study_android1.lampstudio.com.studyandroid_1.bai10;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Bai10 extends Activity implements View.OnClickListener {
    EditText edt_user_name, edt_pass;
    Button btnLogin;
    Button btnIntenExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai10);
        edt_user_name = (EditText) findViewById(R.id.user_name);
        edt_pass = (EditText) findViewById(R.id.pass);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnIntenExample = (Button) findViewById(R.id.btn_intenExample);
        btnLogin.setOnClickListener(this);
        btnIntenExample.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String name = edt_user_name.getText().toString();
                String pass = edt_pass.getText().toString();
                if (pass.equals("abc123")) {
                    Intent intent = new Intent(Bai10.this, Bai10_2.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("user_name",name);
//                    bundle.putInt("tuoi",29);
//                    intent.putExtra("key_bundle",bundle);

//                    intent.putExtra("user_name",name);
//                    intent.putExtra("tuoi","14/01/1988");
                    User user = new User(name, 29);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }
                break;
            case R.id.btn_intenExample:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vnexpress.net/"));
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01111111"));
                Intent intent3 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01111111"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent3);
                break;
        }
    }
}
