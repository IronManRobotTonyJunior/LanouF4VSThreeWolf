package com.example.dllo.bibilala.bangumi.view;
 /*
        quu..__
         $$$b  `---.__
          "$$b        `--.                          ___.---uuudP
           `$$b           `.__.------.__     __.---'      $$$$"              .
             "$b          -'            `-.-'            $$$"              .'|
               ".                                       d$"             _.'  |
                 `.   /                              ..."             .'     |
                   `./                           ..::-'            _.'       |
                    /                         .:::-'            .-'         .'
                   :                          ::''\          _.'            |
                  .' .-.             .-.           `.      .'               |
                  : /'$$|           .@"$\           `.   .'              _.-'
                 .'|$u$$|          |$$,$$|           |  <            _.-'
                 | `:$$:'          :$$$$$:           `.  `.       .-'
                 :                  `"--'             |    `-.     \
                :                |                |#'     `..'`..'          `                 \                                   xXX|     /    ./
                  \                                xXXX'|    /   ./
                  /`-.                                  `.  /   /
                 :    `-  ...........,                   | /  .'
                 |         ``:::::::'       .            |<    `.
                 |             ```          |           x| \ `.:``.
                 |                         .'    /'   xXX|  `:`M`M':.
                 |    |                    ;    /:' xXXX'|  -'MMMMM:'
                 `.  .'                   :    /:'       |-'MMMM.-'
                  |  |                   .'   /'        .'MMM.-'
                  `'`'                   :  ,'          |MMM<
                    |                     `'            |tbap\
                     \                                  :MM.-'
                      \                 |              .''
                       \.               `.            /
                        /     .:::::::.. :           /
                       |     .:::::::::::`.         /
                       |   .:::------------\       /
                      /   .''               >::'  /
                      `',:                 :    .'
                                           `:.:'

         
        */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.bangumentity.add.ListBean;
import com.example.dllo.bibilala.view.FormatTime;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by dllo on 16/11/12.
 */

public class QuarterlyAdapter extends CommonAdapter<ListBean> {

    private List<ListBean> listBeen;
     int moonOne;

    public void setListBeen(List<ListBean> listBeen) {
        this.listBeen = listBeen;
        notifyDataSetChanged();
    }


    public QuarterlyAdapter(Context context, int layoutId, List<ListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ListBean listBean, int position) {
        String follow = listBeen.get(position).getFavourites();
        int i = Integer.parseInt(follow);
        double d = i / 10000;
        DecimalFormat df = new java.text.DecimalFormat("#.#");
        String people = df.format(d);
        ListBean bean = listBeen.get(position);
        String formatTime = FormatTime.formatTime(bean.getPub_time());
//        holder.setText(R.id.item_quartely_tv_year, formatTime);
        holder.setText(R.id.item_quarterly_tv_title, bean.getTitle());
        holder.setText(R.id.item_quarterly_tv_favourites, people + "万人追番");
        ImageView image = holder.getView(R.id.item_quartely_ima);
        ImageView imageView = holder.getView(R.id.item_quarterly_ima);
        Glide.with(mContext).load(listBean.getCover()).into(imageView);
        if (moonOne == 10) {
            image.setImageResource(R.mipmap.qiu);
        } else if (moonOne == 7) {
            image.setImageResource(R.mipmap.xia);

        } else if (moonOne == 4) {
            image.setImageResource(R.mipmap.chun);

        } else if (moonOne == 1) {
            image.setImageResource(R.mipmap.dong);
        }
    }



}
