package study_android1.lampstudio.com.studyandroid_1.model.Login;

/**
 * Created by VS9 X64Bit on 17/04/2017.
 */

public class ModelLogin{
    ModelReponseToPresenterListener modelReponseToPresenterListener;

    public ModelLogin(ModelReponseToPresenterListener modelReponseToPresenterListener) {
        this.modelReponseToPresenterListener = modelReponseToPresenterListener;
    }

    public void OnLogin(String userName, String pass) {
        if(userName.equals("khoand") && pass.equals("123")){
            modelReponseToPresenterListener.LoginSuccess();
        }else{
            modelReponseToPresenterListener.LoginFail();
        }
    }
}
