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
import com.example.dllo.bibilala.entity.BangUmiRecommendEntity;

/**
 * Created by dllo on 16/10/22.
 */

public class BangumRecommendAdapter extends BaseAdapter {
    private Context context;
    private BangUmiRecommendEntity entity;

    public void setEntity(BangUmiRecommendEntity entity) {
        this.entity = entity;
        notifyDataSetChanged();
    }

    public BangumRecommendAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return entity == null ? 0 : entity.getResult().size();
    }

    @Override
    public Object getItem(int position) {
        return entity.getResult().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecommendViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_bangum_recommend, null);
            holder = new RecommendViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (RecommendViewHolder) convertView.getTag();
        }
        String desc = entity.getResult().get(position).getDesc();
        switch (desc.length() / 20) {
            case 1:
                holder.textView.setText(desc.subSequence(0, 16) + "\n" + desc.subSequence(16, desc.length() - 1));
                break;
            case 2:
                holder.textView.setText(desc.subSequence(0, 16) + "\n" + desc.subSequence(16, 32) + "\n" + desc.subSequence(32, desc.length() - 1));
                break;
            case 3:
                holder.textView.setText(desc.subSequence(0, 16) + "\n" + desc.subSequence(16, 32) + "\n" + desc.subSequence(32, 48) + "\n" + desc.subSequence(48, desc.length() - 1));
                break;
            case 0:
                holder.textView.setText(desc);
                break;
            case 4:

                break;
            default:
                holder.textView.setText("default");
                break;
        }
        holder.tvTitle.setText(entity.getResult().get(position).getTitle());
        Glide.with(context).load(entity.getResult().get(position).getCover()).into(holder.ima);

        return convertView;
    }

    class RecommendViewHolder {
        private final TextView textView;
        private TextView tvTitle;
        private ImageView ima;

        public RecommendViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.text_test);
            tvTitle = (TextView) view.findViewById(R.id.item_bang_recommend_tv_title);
            ima = (ImageView) view.findViewById(R.id.item_bangum_recommend_ima);
        }
    }
}
