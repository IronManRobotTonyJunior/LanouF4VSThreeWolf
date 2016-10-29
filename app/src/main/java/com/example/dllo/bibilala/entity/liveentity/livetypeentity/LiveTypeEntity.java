package com.example.dllo.bibilala.entity.liveentity.livetypeentity;


public class LiveTypeEntity {
    int code;
    String message;
    DataTypeEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataTypeEntity getData() {
        return data;
    }

    public void setData(DataTypeEntity data) {
        this.data = data;
    }
}
