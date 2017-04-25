package study_android1.lampstudio.com.studyandroid_1.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Fragment extends AppCompatActivity implements FragmentLogin.OnShowLogin{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentLogin fragmentLogin = new FragmentLogin();
        transaction.replace(R.id.frame_container,fragmentLogin);
        transaction.commit();
    }

    @Override
    public void onShowLogin(String userName) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentUserInfo fragmentUserInfo = new FragmentUserInfo();
        // Khởi tạo đối tượng Bundle và truyền dữ liệu sang FragmentUserInfo
        Bundle bundle = new Bundle();
        bundle.putString("key_username", userName);
        fragmentUserInfo.setArguments(bundle);
        // Thay thế FragmentLogin hiện tại bằng FragmentUserInfo
        transaction.replace(R.id.frame_container, fragmentUserInfo);
        // Hiển thị màn hình login khi nhấn phím back
        transaction.addToBackStack("FragmentLogin");
        transaction.commit();

    }
}
