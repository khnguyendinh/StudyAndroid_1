package study_android1.lampstudio.com.studyandroid_1.RecycleView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import study_android1.lampstudio.com.studyandroid_1.R;

/**
 * Created by VS9 X64Bit on 23/04/2017.
 */

public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.ViewHolderX> {
    ArrayList<ItemModelRecycle> arrayList;
    Context mContext;
    LayoutInflater layoutInflater;

    public AdapterRecycle(ArrayList<ItemModelRecycle> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolderX onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_recycleview, parent, false);
        ViewHolderX viewHolderX = new ViewHolderX(view);
        return viewHolderX;

    }

    @Override
    public void onBindViewHolder(ViewHolderX holder, int position) {
        holder.imgv.setImageResource(arrayList.get(position).getId_img());
        holder.textView.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolderX extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imgv;
        public ViewHolderX(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_rc);
            imgv = (ImageView) itemView.findViewById(R.id.imgv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"Clcikc ",Toast.LENGTH_LONG).show();
                    //url:https://login.com
                    //
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("name", "thanglq");
                        jsonObject.put("psass", "thanglq");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
