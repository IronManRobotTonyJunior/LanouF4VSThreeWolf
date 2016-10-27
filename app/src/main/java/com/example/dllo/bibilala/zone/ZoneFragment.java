package com.example.dllo.bibilala.zone;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class ZoneFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    List<ZoneEntity> mEntities = new ArrayList<>();
    List<Integer> mImageResouce = new ArrayList<>();
    List<String> mName = new ArrayList<>();

    @Override
    protected int setLayout() {
        return R.layout.fragment_zone;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.zone_recycler);


    }

    @Override
    protected void initData() {
        setData();
        for (int i = 0; i < 15; i++) {
            mEntities.add(new ZoneEntity(mImageResouce.get(i), mName.get(i)));

        }
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        ZoneAdapter adapter = new ZoneAdapter(mContext, R.layout.item_zone, mEntities);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(manager);

    }

    private void setData() {
        mImageResouce.add(R.mipmap.ic_category_live);
        mImageResouce.add(R.mipmap.ic_category_t13);
        mImageResouce.add(R.mipmap.ic_category_t1);
        mImageResouce.add(R.mipmap.ic_category_t3);
        mImageResouce.add(R.mipmap.ic_category_t129);
        mImageResouce.add(R.mipmap.ic_category_t4);
        mImageResouce.add(R.mipmap.ic_category_t36);
        mImageResouce.add(R.mipmap.ic_category_t160);
        mImageResouce.add(R.mipmap.ic_category_t119);
        mImageResouce.add(R.mipmap.ic_category_t155);
        mImageResouce.add(R.mipmap.ic_category_t165);
        mImageResouce.add(R.mipmap.ic_category_t31);
        mImageResouce.add(R.mipmap.ic_category_t23);
        mImageResouce.add(R.mipmap.ic_category_t11);
        mImageResouce.add(R.mipmap.ic_category_game_center);
        mName.add("直播");
        mName.add("番剧");
        mName.add("动画");
        mName.add("音乐");
        mName.add("舞蹈");
        mName.add("游戏");
        mName.add("科技");
        mName.add("生活");
        mName.add("鬼畜");
        mName.add("时尚");
        mName.add("广告");
        mName.add("娱乐");
        mName.add("电影");
        mName.add("电视剧");
        mName.add("游戏中心");


    }
}
