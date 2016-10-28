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
public class RecommedVideoAdapter  extends BaseAdapter{
    private Context context;
    private AllBean allBean;

    public RecommedVideoAdapter(Context context) {
        this.context = context;
    }

    public void setAllBean(AllBean allBean) {
        this.allBean = allBean;
    }

    @Override
    public int getCount() {
        return  4;
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
        AllBean.ResultBean.BodyBean bodyBeen =allBean.getResult().get(0).getBody().get(i);

        VideoHolder holder =null;
        if (view==null) {
            view = LayoutInflater.from(context).inflate(R.layout.hot_recommended_video,viewGroup,false);
            holder =new VideoHolder(view);
            view.setTag(holder);

        }else {
            holder = (VideoHolder) view.getTag();
        }
        holder.video_litle.setText(bodyBeen.getTitle());
        holder.hot_look_person.setText(bodyBeen.getPlay());
        holder.hot_comments_person.setText(bodyBeen.getDanmaku());
        Glide.with(context).load(bodyBeen.getCover()).into(holder.video_img);






        return view;
    }
    public class VideoHolder{
        private ImageView video_img;
        private TextView video_litle;
        private TextView hot_look_person;
        private TextView hot_comments_person;


        private VideoHolder(View view){
            video_img = (ImageView) view.findViewById(R.id.video_img);
            video_litle = (TextView) view.findViewById(R.id.video_title);
            hot_look_person = (TextView) view.findViewById(R.id.hot_look_person);
            hot_comments_person = (TextView) view.findViewById(R.id.hot_comments_person);


        }
    }
}
