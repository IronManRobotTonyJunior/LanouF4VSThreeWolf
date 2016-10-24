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
public class AllBean {


    /**
     * type : recommend
     * head : {"param":"","goto":"","style":"gm_av","title":"热门焦点"}
     * body : [{"title":"【小林幸子】Sachiko San Sachiko San【改词】","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/adbfba894c223b1bc4c7d9399c709ba27a12bec1.png","param":"6752990","goto":"av","width":350,"height":219,"play":"1.6万","danmaku":"404"},{"title":"【A☆K哀豆初】Carry Me Off【带我飞！（笑）】","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/084a6884152f843d39447aca327a922276ce92c6.png","param":"6781174","goto":"av","width":350,"height":219,"play":"2.3万","danmaku":"249"},{"title":"【某某阳】落地算我输！岛田DJ艾兴瓦尔德一日游","style":"gm_av","cover":"http://i1.hdslb.com/bfs/archive/23ca2d0c73895052d4af4366e2de54a029f94985.jpg_320x200.jpg","param":"6766564","goto":"av","width":350,"height":219,"play":"37.0万","danmaku":"1425"},{"title":"【C菌】采访育碧《看门狗2》制作团队! 附完整版游玩录像！","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/94cab2ca8191bf1b379de61246f355ce5a4f77ff.png","param":"6775166","goto":"av","width":350,"height":219,"play":"32.7万","danmaku":"1.0万"}]
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String type;
        /**
         * param :
         * goto :
         * style : gm_av
         * title : 热门焦点
         */

        private HeadBean head;
        /**
         * title : 【小林幸子】Sachiko San Sachiko San【改词】
         * style : gm_av
         * cover : http://i0.hdslb.com/bfs/archive/adbfba894c223b1bc4c7d9399c709ba27a12bec1.png
         * param : 6752990
         * goto : av
         * width : 350
         * height : 219
         * play : 1.6万
         * danmaku : 404
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
            private String play;
            private String danmaku;

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

            public String getPlay() {
                return play;
            }

            public void setPlay(String play) {
                this.play = play;
            }

            public String getDanmaku() {
                return danmaku;
            }

            public void setDanmaku(String danmaku) {
                this.danmaku = danmaku;
            }
        }
    }
}
