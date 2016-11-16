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
import com.example.dllo.bibilala.entity.bangum.crayon.ListEntity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by dllo on 16/11/1.
 */

public class CrayonAdapter extends CommonAdapter<ListEntity> {

    private List<ListEntity> entityList;

    public void setEntityList(List<ListEntity> entityList) {
        this.entityList = entityList;
    }

    public CrayonAdapter(Context context, int layoutId, List<ListEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ListEntity listEntity, int position) {
        ImageView imageView = holder.getView(R.id.item_crayon_ima_ac);
        String cover = entityList.get(position).getCover();
        Glide.with(mContext).load(cover).into(imageView);
        holder.setText(R.id.item_crayon_tv_title_ac,entityList.get(position).getTitle());
        String follow = entityList.get(position).getFollow();
        int i = Integer.parseInt(follow);
        double d = i / 10000;
        DecimalFormat df = new java.text.DecimalFormat("#.0");
        String a = df.format(d);
        holder.setText(R.id.item_crayon_tv_favourites_ac,a + "万人追番");
        holder.setText(R.id.item_crayon_tv_favourites_ac,entityList.get(position).getTitle());

    }




}
