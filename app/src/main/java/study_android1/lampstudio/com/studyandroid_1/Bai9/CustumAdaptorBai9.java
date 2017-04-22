package study_android1.lampstudio.com.studyandroid_1.Bai9;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * Created by VS9 X64Bit on 22/04/2017.
 */

public class CustumAdaptorBai9 extends BaseAdapter {
    ArrayList<Bitmap> mData;
    Context mContext;
    LayoutInflater layoutInflater;

    public CustumAdaptorBai9(ArrayList<Bitmap> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.bai9_item,viewGroup);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.iv);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }
    public class ViewHolder{
        ImageView imageView;
    }
}
