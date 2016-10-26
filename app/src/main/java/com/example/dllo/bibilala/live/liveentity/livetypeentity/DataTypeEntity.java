package com.example.dllo.bibilala.live.liveentity.livetypeentity;

import com.example.dllo.bibilala.live.liveentity.liverecommendentity.RecommendDataEntity;

import java.util.List;

public class DataTypeEntity {
    List<BannerEntity> banner;
    List<EntranceIconsEntity> entranceIcons;
    List<RecommendDataEntity> partitions;

    public List<BannerEntity> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerEntity> banner) {
        this.banner = banner;
    }

    public List<EntranceIconsEntity> getEntranceIcons() {
        return entranceIcons;
    }

    public void setEntranceIcons(List<EntranceIconsEntity> entranceIcons) {
        this.entranceIcons = entranceIcons;
    }

    public List<RecommendDataEntity> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<RecommendDataEntity> partitions) {
        this.partitions = partitions;
    }
}
