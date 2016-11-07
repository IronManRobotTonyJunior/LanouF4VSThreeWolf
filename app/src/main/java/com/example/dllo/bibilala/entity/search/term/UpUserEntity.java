package com.example.dllo.bibilala.entity.search.term;

import com.google.gson.annotations.SerializedName;

public class UpUserEntity {
    @SerializedName("0")
    ZeroUpUserEntity zero;

    public ZeroUpUserEntity getZero() {
        return zero;
    }

    public void setZero(ZeroUpUserEntity zero) {
        this.zero = zero;
    }
}
