package com.example.dllo.bibilala.entity.recommendentity;

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
public class LBBean {

    /**
     * code : 0
     * data : [{"title":"广告 频道精选","value":"http://www.bilibili.com/blackboard/activity-cm04.html","image":"http://i0.hdslb.com/bfs/archive/127580f4fca86d52716cfb19d844ce43c12f867e.jpg","type":2,"weight":1,"remark":"","hash":"d8cc89416e96a0e3673d499f3233f43f"},{"title":"FGO","value":"61","image":"http://i0.hdslb.com/bfs/archive/517bdceccc3b1bb573cfd4f4090d6506b22bf5e1.jpg","type":1,"weight":2,"remark":"","hash":"fed8d6b42c680d2ec5429c71acf578e3"},{"title":"搞怪小剧场","value":"http://acg.tv/u1Kz","image":"http://i0.hdslb.com/bfs/archive/9253ea0c2fa0b5432d51b8604072f5a7e590876b.jpg","type":2,"weight":3,"remark":"","hash":"0b5ac23437b79a8c6ece8b9514ccd512"},{"title":"搭配擂台","value":"http://www.bilibili.com/blackboard/activity-outfit01.html","image":"http://i0.hdslb.com/bfs/archive/40e8f91b3da411eaec3d981c833a155a8e7b8feb.jpg","type":2,"weight":2,"remark":"","hash":"171b617fcef787c914af8afe02b1795b"},{"title":"V家","value":"http://www.bilibili.com/html/activity-VocaloidCover-m.html","image":"http://i0.hdslb.com/bfs/archive/8d243b540e927956df0a9962ab986cbb79c202de.jpg","type":2,"weight":3,"remark":"","hash":"d7c26640ac54d227f31fca0d54efba94"},{"title":"天马问卷","value":"http://www.bilibili.com/html/bili-research-001-m.html","image":"http://i0.hdslb.com/bfs/archive/27731ddc9f2f9053defbfd2c878b1fd742f904d6.png","type":2,"weight":5,"remark":"","hash":"8f3aaa32ae7169228b515ce2e367aa51"}]
     */

    private int code;
    /**
     * title : 广告 频道精选
     * value : http://www.bilibili.com/blackboard/activity-cm04.html
     * image : http://i0.hdslb.com/bfs/archive/127580f4fca86d52716cfb19d844ce43c12f867e.jpg
     * type : 2
     * weight : 1
     * remark :
     * hash : d8cc89416e96a0e3673d499f3233f43f
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private String value;
        private String image;
        private int type;
        private int weight;
        private String remark;
        private String hash;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }
}
