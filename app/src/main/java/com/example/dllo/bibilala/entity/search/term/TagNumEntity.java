package com.example.dllo.bibilala.entity.search.term;

public class TagNumEntity {

    private String name;
    private String value;
    private double spid;
    private double ref;

    public TagNumEntity() {
    }

    public TagNumEntity(String name, String value, Double spid, Double ref) {
        this.name = name;
        this.value = value;
        this.spid = spid;
        this.ref = ref;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public double getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }
}
