package com.example.dllo.bibilala.zone;


import android.content.Context;

import com.example.dllo.bibilala.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class ZoneAdapter extends CommonAdapter<ZoneEntity> {


    public ZoneAdapter(Context context, int layoutId, List<ZoneEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ZoneEntity entity, int position) {
        holder.setText(R.id.item_zone_tv, entity.getName());
        holder.setImageResource(R.id.item_zone_img, entity.getImageViewResource());
    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
