package study_android1.lampstudio.com.studyandroid_1.bai8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * Created by VS9 X64Bit on 22/04/2017.
 */

public class CustomAdapterBai8 extends BaseAdapter {
    Context mContext;
    ArrayList<ItemModelBai8> mData;
    LayoutInflater mLayout;

    public CustomAdapterBai8(Context mContext, ArrayList<ItemModelBai8> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mLayout = LayoutInflater.from(mContext);
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
            view = mLayout.inflate(R.layout.bai8_item,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.tv_id = (TextView) view.findViewById(R.id.id);
            viewHolder.tv_mean = (TextView) view.findViewById(R.id.tv_des);
            viewHolder.tv_word = (TextView) view.findViewById(R.id.tv_word);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ItemModelBai8 itemModelBai8 = mData.get(i);
        viewHolder.tv_id.setText(itemModelBai8.getId());
        viewHolder.tv_mean.setText(itemModelBai8.getDescription());
        viewHolder.tv_word.setText(itemModelBai8.getWord());
        return view;
    }
    public class ViewHolder{
        TextView tv_id;
        TextView tv_word;
        TextView tv_mean;
    }
}
