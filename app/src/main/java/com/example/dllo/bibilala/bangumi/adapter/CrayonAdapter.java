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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.bangum.CartoonEntity;

import java.util.List;


/**
 * Created by dllo on 16/10/26.
 */

public class CrayonAdapter extends BaseAdapter {
    private List<CartoonEntity> entity;
    private Context context;

    public void setEntity(List<CartoonEntity> entity) {
        this.entity = entity;
    }

    public CrayonAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return entity.size();
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
        CrayonViewHolder holder = null;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_bangum_fragment_crayon_,parent,false);
            holder = new CrayonViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (CrayonViewHolder) convertView.getTag();
        }
        CartoonEntity cartoonEntity = entity.get(position);
        holder.tvTitle.setText(cartoonEntity.getTitle());
        holder.tvNew.setText("更新至第"+ cartoonEntity.getNewest_ep_index()+"话");
        holder.tvRead.setText(cartoonEntity.getWatching_count()+"人在看");
        Glide.with(context).load(cartoonEntity.getCover()).into(holder.ima);
        return convertView;
    }

    class CrayonViewHolder {
        private TextView tvTitle,tvRead,tvNew;
        private ImageView ima;
        public CrayonViewHolder(View view) {
            tvTitle = (TextView) view.findViewById(R.id.item_crayon_tv_title);
            tvRead = (TextView) view.findViewById(R.id.item_crayon_tv_favourites);
            tvNew = (TextView) view.findViewById(R.id.item_crayon_tv_new);
            ima = (ImageView) view.findViewById(R.id.item_crayon_ima);
        }
    }
}
