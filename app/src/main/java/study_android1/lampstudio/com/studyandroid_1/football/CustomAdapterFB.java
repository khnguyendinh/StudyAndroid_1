package study_android1.lampstudio.com.studyandroid_1.football;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * Created by VS9 X64Bit on 21/04/2017.
 */

public class CustomAdapterFB extends BaseAdapter {
    Context context;
    ArrayList<ItemFootBall> itemFootBalls;
    LayoutInflater layoutInflater;

    public CustomAdapterFB(Context context, ArrayList<ItemFootBall> itemFootBalls) {
        this.context = context;
        this.itemFootBalls = itemFootBalls;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemFootBalls.size();
    }

    @Override
    public Object getItem(int i) {
        return itemFootBalls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            if(itemFootBalls.get(i).type_fb == ItemFootBall.TYPE_FB.TITLE){
                view = layoutInflater.inflate(R.layout.fb_title, viewGroup, false);
                TextView textView = (TextView) view.findViewById(R.id.tv_time);
                textView.setText(itemFootBalls.get(i).getInforChampang().getDate());
                TextView nameCP = (TextView) view.findViewById(R.id.tv_name_tour);
                nameCP.setText(itemFootBalls.get(i).getInforChampang().getName());
            }else {
                view = layoutInflater.inflate(R.layout.fb_item, viewGroup, false);
                TextView status = (TextView) view.findViewById(R.id.status);
                status.setText(itemFootBalls.get(i).getInformatch().getStatus().toString());
                TextView rs1 = (TextView) view.findViewById(R.id.rs1);
                TextView rs2 = (TextView) view.findViewById(R.id.rs2);
                TextView fb1 = (TextView) view.findViewById(R.id.fb1);
                TextView fb2 = (TextView) view.findViewById(R.id.fb2);
                Button btnKeo = (Button) view.findViewById(R.id.co_keo);
                rs1.setText(itemFootBalls.get(i).getInformatch().getRs1()+"");
                rs2.setText(itemFootBalls.get(i).getInformatch().getRs2()+"");
                fb1.setText(itemFootBalls.get(i).getInformatch().getFb1()+"");
                fb2.setText(itemFootBalls.get(i).getInformatch().getFb2()+"");
                if(itemFootBalls.get(i).getInformatch().isCo_keo()){
                    btnKeo.setVisibility(View.VISIBLE);
                }else {
                    btnKeo.setVisibility(View.INVISIBLE);
                }
            }
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)view.getTag();
        }
        return view;
    }

    private static class ViewHolder {
        ItemFootBall.TYPE_FB type_fb;
        boolean co_keo,ykcg;
        InforChampang inforChampang;
        Informatch informatch;
    }
}
