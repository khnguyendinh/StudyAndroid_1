package study_android1.lampstudio.com.studyandroid_1.viewpager;


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
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fragment_blank1);
        Bundle bundle = getArguments();
        int pos = bundle.getInt("position");
        switch (pos){
            case 0:
                textView.setText(getString(R.string.hello_blank_fragment1));
                break;
            case 1:
                textView.setText(getString(R.string.hello_blank_fragment2));
                break;
            case 2:
                textView.setText(getString(R.string.hello_blank_fragment3));
                break;
            case 3:
                textView.setText(getString(R.string.hello_blank_fragment4));
                break;
        }
        // Inflate the layout for this fragment
        return view;
    }

}
