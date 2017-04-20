package study_android1.lampstudio.com.studyandroid_1.bai6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.R;

import static study_android1.lampstudio.com.studyandroid_1.R.id.img;

/**
 * Created by VS9 X64Bit on 20/04/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<ItemModel> itemModels;
    LayoutInflater layoutInflater;

    public CustomAdapter(Context context, ArrayList<ItemModel> itemModels) {
        this.context = context;
        this.itemModels = itemModels;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemModels.size();
    }

    @Override
    public Object getItem(int i) {
        return itemModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        Log.d("makeview ","id "+i);
//        view = layoutInflater.inflate(R.layout.bai6_item_list,viewGroup,false);
//        TextView tv = (TextView)view.findViewById(R.id.tv_name);
//        ImageView img = (ImageView) view.findViewById(R.id.img);
//        ItemModel itemModel = itemModels.get(i);
//        tv.setText(itemModel.getName());
//        img.setImageResource(itemModel.getImg());
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.bai6_item_list, viewGroup, false);
            viewHolder.tv = (TextView) view.findViewById(R.id.tv_name);
            viewHolder.imgView = (ImageView) view.findViewById(img);
            view.setTag(viewHolder);

        }
        else {
            viewHolder = (ViewHolder)view.getTag();
        }
        return view;
    }

    private static class ViewHolder {
        ImageView imgView;
        TextView tv;

    }
}
