package study_android1.lampstudio.com.studyandroid_1.presenter.Login;

import study_android1.lampstudio.com.studyandroid_1.model.Login.ModelLogin;
import study_android1.lampstudio.com.studyandroid_1.model.Login.ModelReponseToPresenterListener;
import study_android1.lampstudio.com.studyandroid_1.view.Login.ViewLogin;

/**
 * Created by VS9 X64Bit on 17/04/2017.
 */

public class PresenterLogin implements ModelReponseToPresenterListener {
    ModelLogin modelLogin;
    ViewLogin viewLogin;
    public PresenterLogin(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
        modelLogin = new ModelLogin(this);
    }

    public void onLogIn(String userName,String pass) {
        modelLogin.OnLogin(userName, pass);
    }

    @Override
    public void LoginSuccess() {
        viewLogin.LoginSuccess();
    }

    @Override
    public void LoginFail() {
        viewLogin.LoginFail();
    }

}
