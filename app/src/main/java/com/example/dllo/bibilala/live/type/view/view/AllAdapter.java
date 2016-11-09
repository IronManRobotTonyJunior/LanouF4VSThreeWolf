package com.example.dllo.bibilala.live.type.view.view;
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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.liveentity.typeentity.secondtype.DataEntity;
import com.example.dllo.bibilala.entity.liveentity.typeentity.secondtype.SecondAllEntity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/8.
 */

public class AllAdapter extends CommonAdapter<DataEntity> {
    private List<DataEntity> entityList;

    public void setEntityList(List<DataEntity> entityLists) {
        entityList = new ArrayList<>();
        entityList.addAll(entityLists);
        notifyDataSetChanged();
    }


    public AllAdapter(Context context, int layoutId, List<DataEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, DataEntity dataEntity, int position) {
        String title = entityList.get(position).getTitle();
        holder.setText(R.id.item_live_body_title_type,title);
        String name = entityList.get(position).getOwner().getName();
        holder.setText(R.id.item_live_body_author,name);

        int follow = entityList.get(position).getOnline();
        if (follow>10000){
            double d = follow / 10000;
            DecimalFormat df = new java.text.DecimalFormat("#.0");
            String a = df.format(d);
            holder.setText(R.id.item_live_body_audience,a+"万");
        }else {
            holder.setText(R.id.item_live_body_audience,follow+"");
        }

        ImageView imageView = holder.getView(R.id.item_live_body_img);
        String src = entityList.get(position).getCover().getSrc();
        Glide.with(mContext).load(src).into(imageView);

    }
}
