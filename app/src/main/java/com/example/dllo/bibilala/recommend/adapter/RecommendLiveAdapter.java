package com.example.dllo.bibilala.recommend.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.recommendentity.AllBean;

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
public class RecommendLiveAdapter extends BaseAdapter {
    private AllBean allBean;
    private Context context;
    private String one;
    private String two;

    public RecommendLiveAdapter(Context context) {
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

        List<AllBean.ResultBean.BodyBean> bodyBeen = allBean.getResult().get(1).getBody();


        LiveHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_recommend_live, viewGroup, false);
            holder = new LiveHolder(view);
            view.setTag(holder);
        } else {
            holder = (LiveHolder) view.getTag();
        }


        AllBean.ResultBean.BodyBean bodyBean = bodyBeen.get(i);
        Glide.with(context).load(bodyBean.getCover()).into(holder.live_big_img);

        one = bodyBean.getArea();
        two = bodyBean.getTitle();


        holder.spannableString.setSpan(new TextAppearanceSpan(context, R.style.styleOne), 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.spannableString.setSpan(new TextAppearanceSpan(context, R.style.styleTwo), 6, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        holder.live_title_one.setText("#" + one + "#" + two);
        holder.live_slogan.setText(bodyBean.getUp());
        holder.live_look_person.setText(bodyBean.getOnline() + "");


        holder.live_title_one.setText(holder.spannableString, TextView.BufferType.SPANNABLE);
        return view;
    }

    class LiveHolder {

        private ImageView live_big_img;
        private TextView live_title_one, live_slogan, live_look_person;
        private SpannableString spannableString;
        private LinearLayout live_linear_layout;


        private LiveHolder(View view) {

            live_big_img = (ImageView) view.findViewById(R.id.live_big_img);
            live_title_one = (TextView) view.findViewById(R.id.live_title_one);
            live_slogan = (TextView) view.findViewById(R.id.live_slogan);
            live_look_person = (TextView) view.findViewById(R.id.live_look_person);
            spannableString = new SpannableString("#" + one + "#" + two);


        }
    }
}
