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
import com.example.dllo.bibilala.entity.BangUmiEntity;
import com.example.dllo.bibilala.entity.ListsEntity;
import com.example.dllo.bibilala.entity.PreviousEntity;

import java.util.List;

/**
 * Created by dllo on 16/10/24.
 */

public class JulyToLoveAdapter extends BaseAdapter {
    private List<ListsEntity> entity;
    private Context context;

    public void setEntity(List<ListsEntity> entity) {
        this.entity = entity;
    }

    public JulyToLoveAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
//        Log.d("JulyToLoveAdapter", "entity.getList().size():" + entity.getList().size());
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_july_fragment, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ListsEntity listsEntity = entity.get(position);
        Log.d("七月推荐观战人数", listsEntity.getFavourites());
        if (Integer.parseInt(listsEntity.getFavourites())>10000){
//            Integer.parseInt(entity.getResult().getPrevious().getList().get(position).getFavourites())%10000

        }
        holder.tvFavourites.setText(listsEntity.getFavourites()+"人追番"+"");
        holder.tvTitle.setText(listsEntity.getTitle());
        Glide.with(context).load(listsEntity.getCover()).into(holder.ima);

        return convertView;
    }

    class ViewHolder {
        private TextView tvFavourites, tvTitle;
        private ImageView ima;

        public ViewHolder(View view) {
            tvFavourites = (TextView) view.findViewById(R.id.item_july_tv_favourites);
            tvTitle = (TextView) view.findViewById(R.id.item_july_tv_title);
            ima = (ImageView) view.findViewById(R.id.item_july_ima);
        }
    }
}
