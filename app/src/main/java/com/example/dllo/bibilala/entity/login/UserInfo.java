package com.example.dllo.bibilala.entity.login;


import android.graphics.Bitmap;

import cn.bmob.v3.BmobObject;

public class UserInfo extends BmobObject {
    private String telephone;
    private String password;
    private Bitmap userIcon;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bitmap getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(Bitmap userIcon) {
        this.userIcon = userIcon;
    }
}
