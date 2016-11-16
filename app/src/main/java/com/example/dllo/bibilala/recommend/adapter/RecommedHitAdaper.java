package com.example.dllo.bibilala.recommend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.recommend.AllBean;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by 刘城羊 on 16/7/10.
 */
public class RecommedHitAdaper extends BaseAdapter {


    private Context context;
    private AllBean allBean;

    public RecommedHitAdaper(Context context) {
        this.context = context;
    }

    public void setAllBean(AllBean allBean) {
        this.allBean = allBean;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return allBean.getResult().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        HitHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_recommend_hit, viewGroup, false);
            holder = new HitHolder(view);
            view.setTag(holder);
        } else {
            holder = (HitHolder) view.getTag();
        }
        Glide.with(context).load(allBean.getResult().get(2).getBody().get(i).getCover()).into(holder.hit_big_img);
        holder.hit_title_one.setText(allBean.getResult().get(2).getBody().get(i).getTitle());
        holder.hit_slogan.setText(allBean.getResult().get(2).getBody().get(i).getDesc1());


        return view;
    }

    class HitHolder {

        private ImageView hit_big_img;
        private TextView hit_title_one;
        private TextView hit_slogan;

        private HitHolder(View view) {
            hit_big_img = (ImageView) view.findViewById(R.id.hit_big_img);
            hit_title_one = (TextView) view.findViewById(R.id.hit_title_one);
            hit_slogan = (TextView) view.findViewById(R.id.hit_slogan);

        }
    }
}
