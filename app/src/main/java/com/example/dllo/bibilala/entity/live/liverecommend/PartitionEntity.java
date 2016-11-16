package com.example.dllo.bibilala.entity.live.liverecommend;


public class PartitionEntity {


    /**
     * id : 0
     * name : 推荐主播
     * area : hot
     * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/-1.png?2016102401","height":"63","width":"63"}
     * count : 3912
     */

    private int id;
    private String name;
    private String area;
    /**
     * src : http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/-1.png?2016102401
     * height : 63
     * width : 63
     */

    private SubIconBean sub_icon;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public SubIconBean getSub_icon() {
        return sub_icon;
    }

    public void setSub_icon(SubIconBean sub_icon) {
        this.sub_icon = sub_icon;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static class SubIconBean {
        private String src;
        private String height;
        private String width;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }
    }
}
