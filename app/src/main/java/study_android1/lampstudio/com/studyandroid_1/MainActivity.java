package study_android1.lampstudio.com.studyandroid_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import study_android1.lampstudio.com.studyandroid_1.presenter.Login.PresenterLogin;
import study_android1.lampstudio.com.studyandroid_1.view.Login.ViewLogin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewLogin {
    PresenterLogin presenterLogin;////123
    EditText editTextPas ;
    EditText editTextUserName;
    String user_name, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_linear_layout);
        Button btn = (Button) findViewById(R.id.btnLogin);
        btn.setOnClickListener(this);
        editTextPas = (EditText) findViewById(R.id.et_pass);
        editTextUserName = (EditText) findViewById(R.id.et_userName);
        editTextPas.setOnClickListener(this);
        presenterLogin = new PresenterLogin(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                user_name = editTextUserName.getText().toString();
                pass = editTextPas.getText().toString();
                System.out.println("MainActivity.onClick "+user_name+" pass "+pass);
                presenterLogin.onLogIn(user_name,pass);
                break;
            case R.id.et_pass:
                break;
        }
    }

    @Override
    public void LoginFail() {
        System.out.println("Login failed");
    }

    @Override
    public void LoginSuccess() {
        System.out.println("Login sucess");
    }
}
