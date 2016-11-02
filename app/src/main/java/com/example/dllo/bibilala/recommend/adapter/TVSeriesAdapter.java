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
import com.example.dllo.bibilala.entity.recommendentity.AllBean;

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
public class TVSeriesAdapter  extends BaseAdapter{
    private AllBean allBean;
    private Context context;

    public TVSeriesAdapter(Context context) {
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
        AllBean.ResultBean.BodyBean bean = allBean.getResult().get(17).getBody().get(i);
        TVSeriesHolder holder =null;
        if (view ==null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_recommend_music,viewGroup,false);
            holder =new TVSeriesHolder(view);
            view.setTag(holder);
        }else {
            holder = (TVSeriesHolder) view.getTag();
        }
        Glide.with(context).load(bean.getCover()).into(holder.music_img);
        holder.music_title.setText(bean.getTitle());
        holder.music_look_person.setText(bean.getPlay());
        holder.music_comments_person.setText(bean.getDanmaku());
        return view;
    }
    public static final class TVSeriesHolder{
        private ImageView music_img;
        private TextView music_title, music_look_person, music_comments_person;
        private TVSeriesHolder(View view){
            music_img = (ImageView) view.findViewById(R.id.music_img);
            music_title = (TextView) view.findViewById(R.id.music_title);
            music_look_person = (TextView) view.findViewById(R.id.music_look_person);
            music_comments_person = (TextView) view.findViewById(R.id.music_comments_person);

        }
    }
}
