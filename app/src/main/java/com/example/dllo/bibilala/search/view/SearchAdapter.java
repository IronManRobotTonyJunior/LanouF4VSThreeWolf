package com.example.dllo.bibilala.search.view;

import android.content.Context;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.search.term.TagNumEntity;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

public class SearchAdapter extends CommonAdapter<TagNumEntity> {

    public SearchAdapter(Context context, int layoutId, List<TagNumEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder viewHolder, TagNumEntity item, int position) {
        viewHolder.setText(R.id.search_list_name, item.getName());
    }
}
