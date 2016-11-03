package com.example.dllo.bibilala.entity.search.detail;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchTypeEntity {

    // 搜索Tab分类搜索
    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private int pages;
        private List<ItemsBean> items;

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            private String title;
            private String cover;
            private String uri;
            private String param;
            @SerializedName("goto")
            private String gotoX;
            private int total_count;
            private String desc;
            private OfficialVerifyBean official_verify;
            private String screen_date;
            private String area;
            private String cover_mark;
            private String actors;
            private String staff;
            private int length;
            private int status;
            private int play;
            private int archives;
            private String cat_desc;
            private String newest_cat;
            private String newest_season;
            private String index;
            private int finish;

            public int getPlay() {
                return play;
            }

            public void setPlay(int play) {
                this.play = play;
            }

            public int getArchives() {
                return archives;
            }

            public void setArchives(int archives) {
                this.archives = archives;
            }

            public String getCat_desc() {
                return cat_desc;
            }

            public void setCat_desc(String cat_desc) {
                this.cat_desc = cat_desc;
            }

            public String getNewest_cat() {
                return newest_cat;
            }

            public void setNewest_cat(String newest_cat) {
                this.newest_cat = newest_cat;
            }

            public String getNewest_season() {
                return newest_season;
            }

            public void setNewest_season(String newest_season) {
                this.newest_season = newest_season;
            }

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public int getFinish() {
                return finish;
            }

            public void setFinish(int finish) {
                this.finish = finish;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
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

            public int getTotal_count() {
                return total_count;
            }

            public void setTotal_count(int total_count) {
                this.total_count = total_count;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public OfficialVerifyBean getOfficial_verify() {
                return official_verify;
            }

            public void setOfficial_verify(OfficialVerifyBean official_verify) {
                this.official_verify = official_verify;
            }

            public String getScreen_date() {
                return screen_date;
            }

            public void setScreen_date(String screen_date) {
                this.screen_date = screen_date;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getCover_mark() {
                return cover_mark;
            }

            public void setCover_mark(String cover_mark) {
                this.cover_mark = cover_mark;
            }

            public String getActors() {
                return actors;
            }

            public void setActors(String actors) {
                this.actors = actors;
            }

            public String getStaff() {
                return staff;
            }

            public void setStaff(String staff) {
                this.staff = staff;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public static class OfficialVerifyBean {
                private int type;
                private String desc;

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }
        }
    }
}
