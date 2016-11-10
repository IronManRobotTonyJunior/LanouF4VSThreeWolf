package com.example.dllo.bibilala.recommend.secondinterface.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.liveentity.livetypeentity.BannerEntity;
import com.example.dllo.bibilala.entity.recommendentity.animationentity.ARecommendEntity;
import com.example.dllo.bibilala.entity.recommendentity.animationentity.DynamicEntity;
import com.example.dllo.bibilala.live.view.LiveAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

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
public class AnimationRecommendAdapter extends CommonAdapter<DynamicEntity.DataBean> {


    public AnimationRecommendAdapter(Context context, int layoutId, List<DynamicEntity.DataBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, DynamicEntity.DataBean dataBean, int position) {
        ImageView imageView = holder.getView(R.id.animation_recommend_img);
        Glide.with(mContext).load(dataBean.getCover()).into(imageView);
        TextView animation_recommend_title = holder.getView(R.id.animation_recommend_title);
        animation_recommend_title.setText(dataBean.getTitle());
        TextView animation_recommend_look_person = holder.getView(R.id.animation_recommend_look_person);
        animation_recommend_look_person.setText(dataBean.getPlay() / 10000 + "万");
        TextView animation_recommend_comments_person = holder.getView(R.id.animation_recommend_comments_person);
        animation_recommend_comments_person.setText(dataBean.getDanmaku() + "");


    }
}
