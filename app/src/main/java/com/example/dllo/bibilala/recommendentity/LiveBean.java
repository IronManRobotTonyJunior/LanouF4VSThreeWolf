package com.example.dllo.bibilala.recommendentity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by 刘城羊 on 16/7/10.
 */
public class LiveBean {


    /**
     * type : live
     * head : {"param":"","goto":"live","style":"gm_av","title":"热门直播","count":5136}
     * body : [{"title":"测试 无内容","style":"gm_live","cover":"http://i0.hdslb.com/bfs/live/002b995ff7ab49c3cc11b56133c8fb9eb43499a1.jpg","param":"48743","goto":"live","width":580,"height":364,"up_face":"http://i0.hdslb.com/bfs/face/8d581e002b2f554c7c45be4ec57edf2028d0c92a.jpg","up":"hanser","online":4567,"area":"生活娱乐","area_id":6},{"title":"唱歌。","style":"gm_live","cover":"http://i0.hdslb.com/bfs/live/df479e9606e9da849cc7815acc8fabd9a783f06d.jpg","param":"155068","goto":"live","width":580,"height":364,"up_face":"http://i2.hdslb.com/bfs/face/d75be7ee77b5355adfe0f62cb0c24942fc56894e.jpg","up":"易世樊花","online":6606,"area":"唱见舞见","area_id":10},{"title":"10月26日 狮子生日快乐","style":"gm_live","cover":"http://i0.hdslb.com/bfs/live/6a76f608605f14c1c46c5af04bb9370df2a9335b.jpg","param":"14382","goto":"live","width":580,"height":364,"up_face":"http://i2.hdslb.com/bfs/face/43d4fa2e46400cd9a4c7731352e212b60ab70b53.jpg","up":"天使菌_","online":23,"area":"生活娱乐","area_id":6},{"title":"声优！后宫好难！！！橙光","style":"gm_live","cover":"http://i0.hdslb.com/bfs/live/c06c16e218d4dc3b9c5aabbb6d9e48e13270064d.jpg","param":"1015793","goto":"live","width":580,"height":364,"up_face":"http://i2.hdslb.com/bfs/face/8ce4d98be02a3bce9e3bc5ebf77d8b5f09fe8ad7.jpg","up":"刘明月阿","online":1545,"area":"御宅文化","area_id":2}]
     */

    private String type;
    /**
     * param :
     * goto : live
     * style : gm_av
     * title : 热门直播
     * count : 5136
     */

    private HeadBean head;
    /**
     * title : 测试 无内容
     * style : gm_live
     * cover : http://i0.hdslb.com/bfs/live/002b995ff7ab49c3cc11b56133c8fb9eb43499a1.jpg
     * param : 48743
     * goto : live
     * width : 580
     * height : 364
     * up_face : http://i0.hdslb.com/bfs/face/8d581e002b2f554c7c45be4ec57edf2028d0c92a.jpg
     * up : hanser
     * online : 4567
     * area : 生活娱乐
     * area_id : 6
     */

    private List<BodyBean> body;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class HeadBean {
        private String param;
        @SerializedName("goto")
        private String gotoX;
        private String style;
        private String title;
        private int count;

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class BodyBean {
        private String title;
        private String style;
        private String cover;
        private String param;
        @SerializedName("goto")
        private String gotoX;
        private int width;
        private int height;
        private String up_face;
        private String up;
        private int online;
        private String area;
        private int area_id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUp_face() {
            return up_face;
        }

        public void setUp_face(String up_face) {
            this.up_face = up_face;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }
    }
}
