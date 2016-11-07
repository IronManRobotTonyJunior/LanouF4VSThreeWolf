package com.example.dllo.bibilala.entity.search.term;

import com.google.gson.annotations.SerializedName;

public class BangUmiEntity {
    @SerializedName("0")
    ZeroBangUmiEntity zero;

    public ZeroBangUmiEntity getZero() {
        return zero;
    }

    public void setZero(ZeroBangUmiEntity zero) {
        this.zero = zero;
    }
}
