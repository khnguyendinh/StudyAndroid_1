package study_android1.lampstudio.com.studyandroid_1.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment {
    private OnShowLogin mCallback;

    public FragmentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_login, container, false);
        // findViewById
        final EditText editTextUserName = (EditText) view.findViewById(R.id.edt_username);
        final EditText editTextPassword = (EditText) view.findViewById(R.id.edt_password);
        Button btnLogin = (Button) view.findViewById(R.id.btn_login);
        // Đăng ký và xử lý sự kiện click button login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy giá trị  người dùng nhập vào
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                // Dùng interface để truyền dữ liệu sang FragmentUserInfo
                mCallback.onShowLogin(userName);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (OnShowLogin) context;
    }

    public interface OnShowLogin {
        void onShowLogin(String userName);
    }
}
