package study_android1.lampstudio.com.studyandroid_1.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * Created by VS9 X64Bit on 24/04/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;
    String [] title;
    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        title = new String [] {mContext.getString(R.string.hello_blank_fragment1),
                mContext.getString(R.string.hello_blank_fragment2), mContext.getString(R.string.hello_blank_fragment3),
                mContext.getString(R.string.hello_blank_fragment4)};
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        fragment.setArguments(bundle);
//        switch (position){
//            case 0:
//
//                break;
//        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
