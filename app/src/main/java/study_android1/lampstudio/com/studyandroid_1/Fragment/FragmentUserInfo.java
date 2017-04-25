package study_android1.lampstudio.com.studyandroid_1.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUserInfo extends Fragment {


    public FragmentUserInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_user_info, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_username);
        Bundle bundle = getArguments();
        if (bundle != null) {
            // Lấy dữ liệu
            String userName = bundle.getString("key_username");
            // Hiển thị dữ liệu lên TextView
            textView.setText(" xin choa " + userName );
        }
        return view;
    }

}
