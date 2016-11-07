package com.example.dllo.bibilala.bangumi.adapter; /*
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
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.bangumentity.BangUmiRecommendEntity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by dllo on 16/10/22.
 */
public class BangumAdapter extends CommonAdapter<BangUmiRecommendEntity.ResultBean> {
    private onRecyclerViewItemListener listener;

    public void setListener(onRecyclerViewItemListener listener) {
        this.listener = listener;
    }

    public BangumAdapter(Context context, int layoutId, List<BangUmiRecommendEntity.ResultBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(final ViewHolder holder, BangUmiRecommendEntity.ResultBean entity, int position) {
        holder.setText(R.id.item_bang_recommend_tv_title,entity.getTitle());
        holder.setText(R.id.text_test,entity.getDesc());
        ImageView ima = holder.getView(R.id.item_bangum_recommend_ima);
        Glide.with(mContext).load(entity.getCover()).into(ima);
        if (listener!=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position  = holder.getAdapterPosition();
                    listener.ItemClick(holder,position,v);
                }
            });
        }

    }
    public interface onRecyclerViewItemListener{
        void ItemClick(RecyclerView.ViewHolder holder,int position,View view);
    }
}

