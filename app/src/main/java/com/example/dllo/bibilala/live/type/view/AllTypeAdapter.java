package com.example.dllo.bibilala.live.type.view;
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
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.live.type.DataEntity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by dllo on 16/11/7.
 */

public class AllTypeAdapter extends CommonAdapter<DataEntity> {
    private List<DataEntity> entityList;
    private onRecyclerViewCLickListener listener;

    public void setListener(onRecyclerViewCLickListener listener) {
        this.listener = listener;
    }

    public AllTypeAdapter(Context context, int layoutId, List<DataEntity> datas) {
        super(context, layoutId, datas);
    }

    public void setEntityList(List<DataEntity> entityList) {
        this.entityList = entityList;
    }

    @Override
    protected void convert(final ViewHolder holder, DataEntity dataEntity, int position) {

        holder.setText(R.id.item_all_type_tv,entityList.get(position).getName());
        ImageView imageView = holder.getView(R.id.item_all_type_ima);
        Glide.with(mContext).load(entityList.get(position).getEntrance_icon().getSrc()).into(imageView);

        if (listener!=null){
          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  int position = holder.getAdapterPosition();
                  listener.ItemClick(holder,position,v);
              }
          });
        }
    }
    public interface onRecyclerViewCLickListener{
        void ItemClick(RecyclerView.ViewHolder holder, int position, View view);
    }
}
