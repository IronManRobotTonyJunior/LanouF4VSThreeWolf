package com.example.dllo.bibilala.bangumi.adapter;
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.bangumentity.CartoonEntity;

import java.util.List;

/**
 * Created by dllo on 16/10/26.
 */

public class BangumChinaAdapter extends BaseAdapter {
    private List<CartoonEntity> entity;
    private Context context;

    public void setEntity(List<CartoonEntity> entity) {
        this.entity = entity;
        notifyDataSetChanged();
    }

    public BangumChinaAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return entity == null ? 0 : entity.size();
    }

    @Override
    public Object getItem(int position) {
        return entity.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BangumChinaViewHolder holder = null;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_bangun_china,parent,false);
            holder = new BangumChinaViewHolder(convertView);
            convertView.setTag(holder);

        }else {
            holder = (BangumChinaViewHolder) convertView.getTag();
        }

        CartoonEntity cartoonEntity = entity.get(position);
        Log.d("国产动画标题", cartoonEntity.getTitle());
        holder.tvTitle.setText(cartoonEntity.getTitle());
//        holder.tvTimer.setText(entity.getResult().getChina().get(position));
        Glide.with(context).load(cartoonEntity.getCover()).into(holder.ima);

        return convertView;
    }

    class BangumChinaViewHolder {
        private TextView tvTimer,tvTitle;
        private ImageView ima;
        public BangumChinaViewHolder(View view) {
            tvTimer = (TextView) view.findViewById(R.id.item_china_tv_favourites);
            tvTitle = (TextView) view.findViewById(R.id.item_china_tv_title);
            ima = (ImageView) view.findViewById(R.id.item_china_ima);
        }
    }
}
