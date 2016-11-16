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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.bangum.add.ResultEntity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by dllo on 16/11/10.
 */

public class MoreCrayonAdapter extends CommonAdapter<ResultEntity> {
    private List<ResultEntity> entityList;


    public void setEntityList(List<ResultEntity> entityList) {
        this.entityList = entityList;
    }

    public MoreCrayonAdapter(Context context, int layoutId, List<ResultEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ResultEntity resultEntity, int position) {
        ResultEntity entity = entityList.get(position);
        holder.setText(R.id.item_add_ac_tv_title,entity.getTitle());
        holder.setText(R.id.item_add_ac_tv_new,"更新至第"+entity.getNewest_ep_index()+"话");
        String follow = entity.getFavourites();
        int i = Integer.parseInt(follow);
        double d = i / 10000;
        DecimalFormat df = new java.text.DecimalFormat("#.00");
        String a = df.format(d);
        holder.setText(R.id.item_add_ac_tv_people, a+"万人追番");
        holder.setText(R.id.item_add_crayon_tv_look,entity.getSeason_id()+"在看");
        ImageView imageView = holder.getView(R.id.item_add_crayon_ima);

        Glide.with(mContext).load(entity.getCover()).into(imageView);


    }
}
