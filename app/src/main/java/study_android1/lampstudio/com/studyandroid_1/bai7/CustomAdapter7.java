package study_android1.lampstudio.com.studyandroid_1.bai7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * Created by VS9 X64Bit on 21/04/2017.
 */

public class CustomAdapter7 extends BaseAdapter {
    Context mcontext;
    ArrayList<ItemModel7> mData;
    LayoutInflater layoutInflater;

    public CustomAdapter7(Context mcontext, ArrayList<ItemModel7> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
        layoutInflater = LayoutInflater.from(mcontext);
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
            view = layoutInflater.inflate(R.layout.gridview_item,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.iv);
            viewHolder.textView = (TextView) view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        ItemModel7 itemModel7 = mData.get(i);
        viewHolder.textView.setText(itemModel7.getName());
        viewHolder.imageView.setImageResource(itemModel7.getId());
        return view;
    }
    public class ViewHolder{
        ImageView imageView;
        TextView textView;

    }
}
