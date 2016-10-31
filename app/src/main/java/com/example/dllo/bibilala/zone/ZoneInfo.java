package com.example.dllo.bibilala.zone;


import com.example.dllo.bibilala.R;

import java.util.ArrayList;
import java.util.List;

class ZoneInfo {
    public static List<ZoneEntity> getData() {
        List<ZoneEntity> infos = new ArrayList<>();
        infos.add(new ZoneEntity(R.mipmap.ic_category_live, "直播"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t13, "番剧"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t1, "动画"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t3, "音乐"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t129, "舞蹈"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t4, "游戏"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t36, "科技"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t160, "生活"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t119, "鬼畜"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t155, "时尚"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t165, "广告"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t31, "娱乐"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t23, "电影"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_t11, "电视剧"));
        infos.add(new ZoneEntity(R.mipmap.ic_category_game, "游戏中心"));
        return infos;
    }

}
