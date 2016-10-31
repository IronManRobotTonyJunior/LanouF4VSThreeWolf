package com.example.dllo.bibilala.entity.find;


import java.util.List;

public class FindEntity {

    /**
     * code : 0
     * seid : 8490590676696082647
     * message : success
     * timestamp : 1477306272
     * list : [{"keyword":"法医秦明","status":"keep"},{"keyword":"极乐净土","status":"keep"},{"keyword":"吃货木下","status":"keep"},{"keyword":"ppap","status":"up"},{"keyword":"暴走大事件","status":"up"},{"keyword":"黑镜","status":"down"},{"keyword":"一年生","status":"down"},{"keyword":"不可抗力","status":"keep"},{"keyword":"守望先锋","status":"up"},{"keyword":"主播炸了","status":"up"},{"keyword":"污咚采访间","status":"down"},{"keyword":"twice","status":"keep"},{"keyword":"阴阳师","status":"up"},{"keyword":"蜡笔小新","status":"up"},{"keyword":"主播真会玩","status":"down"},{"keyword":"夏目友人帐","status":"up"},{"keyword":"董力阿拉蕾","status":"up"},{"keyword":"你的名字","status":"up"},{"keyword":"校对女孩河野悦子","status":"down"},{"keyword":"谷阿莫","status":"up"},{"keyword":"镇魂街","status":"down"},{"keyword":"敖厂长","status":"up"},{"keyword":"大胃王密子君","status":"down"},{"keyword":"刺客列传","status":"down"},{"keyword":"日剧","status":"up"},{"keyword":"张继科","status":"keep"},{"keyword":"起小点","status":"up"},{"keyword":"杨洋","status":"down"},{"keyword":"火影忍者","status":"up"},{"keyword":"行尸走肉第七季","status":"up"},{"keyword":"阿拉蕾","status":"up"},{"keyword":"逗鱼时刻","status":"down"},{"keyword":"真正男子汉","status":"up"},{"keyword":"徐老师来巡山","status":"up"},{"keyword":"snh48","status":"up"},{"keyword":"西部世界","status":"up"},{"keyword":"齐木楠雄的灾难","status":"down"},{"keyword":"石原里美","status":"down"},{"keyword":"fate","status":"up"},{"keyword":"张若昀","status":"keep"},{"keyword":"海贼王","status":"up"},{"keyword":"麻雀","status":"up"},{"keyword":"董力","status":"up"},{"keyword":"papi酱","status":"up"},{"keyword":"pdd","status":"up"},{"keyword":"infinite","status":"down"},{"keyword":"釜山行","status":"up"},{"keyword":"抗韩中年人","status":"down"},{"keyword":"错生","status":"down"},{"keyword":"双程","status":"down"}]
     * cost : {"timer":"hotword","total":"0.000142","read file":"0.000085"}
     */

    private int code;
    private String seid;
    private String message;
    private int timestamp;
    /**
     * timer : hotword
     * total : 0.000142
     * read file : 0.000085
     */

    private CostBean cost;
    /**
     * keyword : 法医秦明
     * status : keep
     */

    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public CostBean getCost() {
        return cost;
    }

    public void setCost(CostBean cost) {
        this.cost = cost;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class CostBean {
        private String timer;
        private String total;

        public String getTimer() {
            return timer;
        }

        public void setTimer(String timer) {
            this.timer = timer;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }

    public static class ListBean {
        private String keyword;
        private String status;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
