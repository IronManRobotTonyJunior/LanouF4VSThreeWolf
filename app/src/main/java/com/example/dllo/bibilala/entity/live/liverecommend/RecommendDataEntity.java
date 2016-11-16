package com.example.dllo.bibilala.entity.live.liverecommend;


import java.util.List;

public class RecommendDataEntity {
    private List<LiveEntity> lives;
    private List<LiveEntity> banner_data;
    private PartitionEntity partition;


    public List<LiveEntity> getLives() {
        return lives;
    }

    public void setLives(List<LiveEntity> lives) {
        this.lives = lives;
    }

    public List<LiveEntity> getBanner_data() {
        return banner_data;
    }

    public void setBanner_data(List<LiveEntity> banner_data) {
        this.banner_data = banner_data;
    }

    public PartitionEntity getPartition() {
        return partition;
    }

    public void setPartition(PartitionEntity partition) {
        this.partition = partition;
    }
}
