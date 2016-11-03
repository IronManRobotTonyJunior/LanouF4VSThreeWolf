package com.example.dllo.bibilala.entity.bangumentity.crayonentity;
 /*
        quu..__
         $$$b  `---.__
          "$$b        `--.                          ___.---uuudP
           `$$b           `.__.------.__     __.---'      $$$$"              .
             "$b          -'            `-.-'            $$$"              .'|
               ".                                       d$"             _.'  |
                 `.   /                              ..."             .'     |
                   `./                           ..::-'            _.'       |
                    /                         .:::-'            .-'         .'
                   :                          ::''\          _.'            |
                  .' .-.             .-.           `.      .'               |
                  : /'$$|           .@"$\           `.   .'              _.-'
                 .'|$u$$|          |$$,$$|           |  <            _.-'
                 | `:$$:'          :$$$$$:           `.  `.       .-'
                 :                  `"--'             |    `-.     \
                :                |                |#'     `..'`..'          `                 \                                   xXX|     /    ./
                  \                                xXXX'|    /   ./
                  /`-.                                  `.  /   /
                 :    `-  ...........,                   | /  .'
                 |         ``:::::::'       .            |<    `.
                 |             ```          |           x| \ `.:``.
                 |                         .'    /'   xXX|  `:`M`M':.
                 |    |                    ;    /:' xXXX'|  -'MMMMM:'
                 `.  .'                   :    /:'       |-'MMMM.-'
                  |  |                   .'   /'        .'MMM.-'
                  `'`'                   :  ,'          |MMM<
                    |                     `'            |tbap\
                     \                                  :MM.-'
                      \                 |              .''
                       \.               `.            /
                        /     .:::::::.. :           /
                       |     .:::::::::::`.         /
                       |   .:::------------\       /
                      /   .''               >::'  /
                      `',:                 :    .'
                                           `:.:'

         
        */

import java.util.List;

/**
 * Created by dllo on 16/11/2.
 */

public class CrayonBean {

    private int code;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String alias;
        private String allow_bp;
        private String allow_download;
        private String area;
        private int arealimit;
        private String bangumi_id;
        private String bangumi_title;
        private String brief;
        private String coins;
        private String copyright;
        private String cover;
        private String danmaku_count;
        private String evaluate;
        private String favorites;
        private String is_finish;
        private String jp_title;
        private LimitInfoBean limit_info;
        private String newest_ep_id;
        private String newest_ep_index;
        private String play_count;
        private String pub_time;
        private RankBean rank;
        private String season_id;
        private int season_status;
        private String season_title;
        private String share_url;
        private String squareCover;
        private String staff;
        private String title;
        private String total_count;
        private UserSeasonBean user_season;
        private int viewRank;
        private int vip_quality;
        private String watchingCount;
        private String weekday;
        private List<ActorBean> actor;
        private List<EpisoderBean> episodes;
        private List<?> related_seasons;
        private List<SeasonsBean> seasons;
        private List<?> tag2s;
        private List<TagsBean> tags;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getAllow_bp() {
            return allow_bp;
        }

        public void setAllow_bp(String allow_bp) {
            this.allow_bp = allow_bp;
        }

        public String getAllow_download() {
            return allow_download;
        }

        public void setAllow_download(String allow_download) {
            this.allow_download = allow_download;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArealimit() {
            return arealimit;
        }

        public void setArealimit(int arealimit) {
            this.arealimit = arealimit;
        }

        public String getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(String bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBangumi_title() {
            return bangumi_title;
        }

        public void setBangumi_title(String bangumi_title) {
            this.bangumi_title = bangumi_title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getCoins() {
            return coins;
        }

        public void setCoins(String coins) {
            this.coins = coins;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(String danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public String getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(String evaluate) {
            this.evaluate = evaluate;
        }

        public String getFavorites() {
            return favorites;
        }

        public void setFavorites(String favorites) {
            this.favorites = favorites;
        }

        public String getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(String is_finish) {
            this.is_finish = is_finish;
        }

        public String getJp_title() {
            return jp_title;
        }

        public void setJp_title(String jp_title) {
            this.jp_title = jp_title;
        }

        public LimitInfoBean getLimit_info() {
            return limit_info;
        }

        public void setLimit_info(LimitInfoBean limit_info) {
            this.limit_info = limit_info;
        }

        public String getNewest_ep_id() {
            return newest_ep_id;
        }

        public void setNewest_ep_id(String newest_ep_id) {
            this.newest_ep_id = newest_ep_id;
        }

        public String getNewest_ep_index() {
            return newest_ep_index;
        }

        public void setNewest_ep_index(String newest_ep_index) {
            this.newest_ep_index = newest_ep_index;
        }

        public String getPlay_count() {
            return play_count;
        }

        public void setPlay_count(String play_count) {
            this.play_count = play_count;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public RankBean getRank() {
            return rank;
        }

        public void setRank(RankBean rank) {
            this.rank = rank;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSeason_status() {
            return season_status;
        }

        public void setSeason_status(int season_status) {
            this.season_status = season_status;
        }

        public String getSeason_title() {
            return season_title;
        }

        public void setSeason_title(String season_title) {
            this.season_title = season_title;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getSquareCover() {
            return squareCover;
        }

        public void setSquareCover(String squareCover) {
            this.squareCover = squareCover;
        }

        public String getStaff() {
            return staff;
        }

        public void setStaff(String staff) {
            this.staff = staff;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public UserSeasonBean getUser_season() {
            return user_season;
        }

        public void setUser_season(UserSeasonBean user_season) {
            this.user_season = user_season;
        }

        public int getViewRank() {
            return viewRank;
        }

        public void setViewRank(int viewRank) {
            this.viewRank = viewRank;
        }

        public int getVip_quality() {
            return vip_quality;
        }

        public void setVip_quality(int vip_quality) {
            this.vip_quality = vip_quality;
        }

        public String getWatchingCount() {
            return watchingCount;
        }

        public void setWatchingCount(String watchingCount) {
            this.watchingCount = watchingCount;
        }

        public String getWeekday() {
            return weekday;
        }

        public void setWeekday(String weekday) {
            this.weekday = weekday;
        }

        public List<ActorBean> getActor() {
            return actor;
        }

        public void setActor(List<ActorBean> actor) {
            this.actor = actor;
        }

        public List<EpisoderBean> getEpisodes() {
            return episodes;
        }

        public void setEpisodes(List<EpisoderBean> episodes) {
            this.episodes = episodes;
        }

        public List<?> getRelated_seasons() {
            return related_seasons;
        }

        public void setRelated_seasons(List<?> related_seasons) {
            this.related_seasons = related_seasons;
        }

        public List<SeasonsBean> getSeasons() {
            return seasons;
        }

        public void setSeasons(List<SeasonsBean> seasons) {
            this.seasons = seasons;
        }

        public List<?> getTag2s() {
            return tag2s;
        }

        public void setTag2s(List<?> tag2s) {
            this.tag2s = tag2s;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class LimitInfoBean {
            private int code;
            /**
             * down : 0
             * play : 2
             */

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
                private int down;
                private int play;

                public int getDown() {
                    return down;
                }

                public void setDown(int down) {
                    this.down = down;
                }

                public int getPlay() {
                    return play;
                }

                public void setPlay(int play) {
                    this.play = play;
                }
            }
        }

        public static class RankBean {
            private int total_bp_count;
            private int week_bp_count;
            /**
             * face : http://i0.hdslb.com/bfs/face/f541b46138aae3e608710814f3546b9d8aca6d88.jpg
             * uid : 1898028
             * uname : 农民作家
             */

            private List<ListBean> list;

            public int getTotal_bp_count() {
                return total_bp_count;
            }

            public void setTotal_bp_count(int total_bp_count) {
                this.total_bp_count = total_bp_count;
            }

            public int getWeek_bp_count() {
                return week_bp_count;
            }

            public void setWeek_bp_count(int week_bp_count) {
                this.week_bp_count = week_bp_count;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String face;
                private String uid;
                private String uname;

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public String getUname() {
                    return uname;
                }

                public void setUname(String uname) {
                    this.uname = uname;
                }
            }
        }

        public static class UserSeasonBean {
            private String attention;
            private int bp;
            private String last_ep_index;
            private String last_time;

            public String getAttention() {
                return attention;
            }

            public void setAttention(String attention) {
                this.attention = attention;
            }

            public int getBp() {
                return bp;
            }

            public void setBp(int bp) {
                this.bp = bp;
            }

            public String getLast_ep_index() {
                return last_ep_index;
            }

            public void setLast_ep_index(String last_ep_index) {
                this.last_ep_index = last_ep_index;
            }

            public String getLast_time() {
                return last_time;
            }

            public void setLast_time(String last_time) {
                this.last_time = last_time;
            }
        }

        public static class ActorBean {
            private String actor;
            private int actor_id;
            private String role;

            public String getActor() {
                return actor;
            }

            public void setActor(String actor) {
                this.actor = actor;
            }

            public int getActor_id() {
                return actor_id;
            }

            public void setActor_id(int actor_id) {
                this.actor_id = actor_id;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }



        public static class SeasonsBean {
            private String bangumi_id;
            private String cover;
            private String is_finish;
            private String newest_ep_id;
            private String newest_ep_index;
            private String season_id;
            private int season_status;
            private String title;
            private String total_count;

            public String getBangumi_id() {
                return bangumi_id;
            }

            public void setBangumi_id(String bangumi_id) {
                this.bangumi_id = bangumi_id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getIs_finish() {
                return is_finish;
            }

            public void setIs_finish(String is_finish) {
                this.is_finish = is_finish;
            }

            public String getNewest_ep_id() {
                return newest_ep_id;
            }

            public void setNewest_ep_id(String newest_ep_id) {
                this.newest_ep_id = newest_ep_id;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public String getSeason_id() {
                return season_id;
            }

            public void setSeason_id(String season_id) {
                this.season_id = season_id;
            }

            public int getSeason_status() {
                return season_status;
            }

            public void setSeason_status(int season_status) {
                this.season_status = season_status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }
        }

        public static class TagsBean {
            private String cover;
            private String tag_id;
            private String tag_name;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getTag_id() {
                return tag_id;
            }

            public void setTag_id(String tag_id) {
                this.tag_id = tag_id;
            }

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }
        }
    }
}
