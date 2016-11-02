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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.CrayonFootEntity;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.ListEntity;

import java.util.List;

/**
 * Created by dllo on 16/11/1.
 */

public class CrayonAdapter extends BaseAdapter {
    private List<ListEntity> entityList;
    private Context context;

    public CrayonAdapter(Context context) {
        this.context = context;
    }

    public void setEntityList(List<ListEntity> entityList) {
        this.entityList = entityList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return entityList == null ? 0 : entityList.size();
    }

    @Override
    public Object getItem(int position) {
        return entityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CrayonViewHolder holder = null;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_crayon_ac,parent,false);
            holder = new CrayonViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (CrayonViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(entityList.get(position).getTitle());
        holder.tvPeople.setText(entityList.get(position).getFollow()+"人追番");
        Glide.with(context).load(entityList.get(position).getCover()).into(holder.imageView);

        return convertView;
    }
    class CrayonViewHolder{
        private ImageView imageView;
        private TextView tvTitle,tvPeople;
        public CrayonViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.item_crayon_ima_ac);
            tvTitle = (TextView) view.findViewById(R.id.item_crayon_tv_title_ac);
            tvPeople = (TextView) view.findViewById(R.id.item_crayon_tv_favourites_ac);


        }
    }
}
