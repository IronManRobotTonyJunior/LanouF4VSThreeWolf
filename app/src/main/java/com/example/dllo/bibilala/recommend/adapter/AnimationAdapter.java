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
public class AnimationAdapter extends BaseAdapter {
    private AllBean allBean;
    private Context context;

    public AnimationAdapter(Context context) {
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AllBean.ResultBean.BodyBean bean =allBean.getResult().get(3).getBody().get(i);

        AnimationHolder holder =null;
        if (view ==null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_recommend_music,viewGroup,false);
            holder =new AnimationHolder(view);
            view.setTag(holder);

        }else {
            holder = (AnimationHolder) view.getTag();

        }

        Glide.with(context).load(bean.getCover()).into(holder.music_img);
        holder.music_title.setText(bean.getTitle());
        holder.music_look_person.setText(bean.getPlay());
        holder.music_comments_person.setText(bean.getDanmaku());
        return view;
    }

    public static final  class AnimationHolder{
        private ImageView music_img;
        private TextView music_title, music_look_person, music_comments_person;
        private AnimationHolder(View view){

            music_img = (ImageView) view.findViewById(R.id.music_img);
            music_title = (TextView) view.findViewById(R.id.music_title);
            music_look_person = (TextView) view.findViewById(R.id.music_look_person);
            music_comments_person = (TextView) view.findViewById(R.id.music_comments_person);

        }
    }
}
