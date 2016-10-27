package com.example.dllo.bibilala.zone;


public class ZoneEntity {
    int mImageViewResource;
    String name;

    public ZoneEntity(int imageViewResource, String name) {
        mImageViewResource = imageViewResource;
        this.name = name;
    }

    public ZoneEntity() {
    }

    public int getImageViewResource() {
        return mImageViewResource;
    }

    public void setImageViewResource(int imageViewResource) {
        mImageViewResource = imageViewResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
