package com.example.dllo.bibilala.find.view;
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
import com.example.dllo.bibilala.entity.find.ListEntity;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dllo on 16/11/14.
 */

public class TopicAdapter extends BaseAdapter {
    private Context context;

    public void setEntityList(List<ListEntity> entityList) {
        this.entityList = entityList;
    }

    public TopicAdapter(Context context) {

        this.context = context;
    }

    private List<ListEntity> entityList;

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
        TopicHolder holder = null;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_topic_ac,parent,false);
            holder = new TopicHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (TopicHolder) convertView.getTag();
        }
        holder.tvTitle.setText(entityList.get(position).getTitle());
        Glide.with(context).load(entityList.get(position).getCover()).into(holder.ima);
        return convertView;
    }

    class TopicHolder {
        private ImageView ima;
        private TextView tvTitle;
        public TopicHolder(View view) {
            ima = (ImageView) view.findViewById(R.id.item_topic_ima);
            tvTitle = (TextView) view.findViewById(R.id.item_topic_tv_title);
        }
    }
}
