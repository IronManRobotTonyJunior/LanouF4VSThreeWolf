package com.example.dllo.bibilala.url;
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

/**
 * Created by dllo on 16/10/22.
 */

public final class UrlClass {
    /**
     * 闲杂
     */
    //我
    public static final String URL_ME = "http://app.bilibili.com/x/v2/space?";
    //头像
    public static final String URL_HEADPHOTO = "http://api.bilibili.com/x/v2/reply/emojis";
    //主题
    public static final String URL_THEME = "http://club.bilibili.com/api/query.skin.list.do?access_key=7ae7d856f4eee8afa300f6f17ddcb2fc&actionKey=appkey&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&ts=1476949442000&sign=fbec4640dd2bc75892e7d00f8d3d8629";

    /**
     * 推荐
     */

    //推荐轮播图
    public static final String URL_GHOST_OU = "http://app.bilibili.com/x/banner?plat=4&build=427000&channel=wandoujia";
    //推荐全部 网址打不开

    //    public static final String URL_RECOMMEND = "http://app.bilibili.com/x/show/old?appkey=1d8b6e7d45233436&build=427000&channel=baidu&mobi_app=android&platform=android&screen=xxhdpi&ts=1477357874000&sign=c6af3131948c45cec5b0be0811b11f0e";
    public static final String URL_RECOMMEND = "http://app.bilibili.com/x/show/old?appkey=1d8b6e7d45233436&build=427000&channel=wandoujia&mobi_app=android&platform=android&screen=hdpi&ts=1476969044000&sign=65d2822650aca5561e8a436e1ce36dc2";
    //推荐番剧推荐
    public static final String URL_FAN_DRAM_RECOMMENDATION = "http://bangumi.bilibili.com/api/get_season_by_tag?access_key=7ae7d856f4eee8afa300f6f17ddcb2fc&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&page=1&pagesize=4&platform=android&tag_id=109&ts=1476949442000&sign=c10377a9764dc78802f0896261b952d5";
    //热门推荐
    public static final String URL_HOT_RECOMMEND = "http://app.bilibili.com/x/show/old?access_key=7ae7d856f4eee8afa300f6f17ddcb2fc&appkey=1d8b6e7d45233436&build=427000&channel=wandoujia&mobi_app=android&platform=android&screen=hdpi&ts=1476949442000&sign=8f371fe30585a0c85985afa426832536";


    /**
     * 番剧
     */
    //番剧推荐
    //此接口有上拉加载接口
    public static final String URL_SOME_RECOMMEND = "http://bangumi.bilibili.com/api/bangumi_recommend?appkey=1d8b6e7d45233436&build=427000&cursor=-1&mobi_app=android&pagesize=10&platform=android&ts=1476949442000&sign=bc143d94f849de44056ed1615518a2f8";
    //番剧全部
    public static final String URL_SOME_DRAMA = "http://bangumi.bilibili.com/api/app_index_page_v4_2?access_key=7ae7d856f4eee8afa300f6f17ddcb2fc&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&ts=1476949442000&sign=56dac58b12111b7e63c39b076ef28a49";
    //    番剧二级列表
    //番剧放送表
    public static final String URL_SECOND_GIO = "http://bangumi.bilibili.com/api/timeline_v4?appkey=1d8b6e7d45233436&area_id=1%2C2%2C-1&build=427000&mobi_app=android&platform=android&see_mine=0&ts=1477485131000&sign=7b105fbc60d46fa35e10873dea58e53a";

    //番剧 新番连载 番剧推荐
    public static final String URL_BANGUM_SECOND_NEW_RECOMMEND(int position) {
        int i = position;
        String url = "http://bangumi.bilibili.com/api/season/recommend/" + i + ".json?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&ts=1477988698000&sign=d248d8937975f394541830be7983d44c";
        return url;
    }

    //番剧 Second
    public static final String URL_URL(int position) {
        int i = position;
        String url = "http://bangumi.bilibili.com/api/season_v4?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&season_id=" + i +
                "&ts=1478241659000&type=bangumi&sign=5321478b86e48faeb59134c6a4c0883d";
        return url;
    }


    //番剧 新番连载 番剧界面
    public static final String URL_BGM(int position) {
        String url = "http://bangumi.bilibili.com/api/season_v4?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&season_id=" +
                position + "&ts=1478069660000&type=bangumi&sign=7113480af897a63fb959f47035ec5cd4";
        return url;
    }

    //番剧 新番连载 最热评论
    public static final String URL_HOT(int str) {
        String url = "http://api.bilibili.com/x/v2/reply?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&nohot=1&oid="
                + str +
                "&platform=android&pn=1&ps=3&sort=2&type=1&sign=b943609b062a5e005f39ac4e91ba6f4f";
        return url;
    }

    public static final String URL_HOTS = "http://api.bilibili.com/x/v2/reply?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&nohot=1&oid=6922039&platform=android&pn=1&ps=3&sort=2&type=1&sign=b943609b062a5e005f39ac4e91ba6f4f";


    /**
     * 直播
     */
    //直播标签
    public static final String URL_LIVE_TAAG = "http://live.bilibili.com/AppIndex/areas?_device=android&_hwid=844cebfd4683c8d8&_ulv=5000&access_key=7ae7d856f4eee8afa300f6f17ddcb2fc&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&scale=hdpi&sign=69e138520fa533d03bd4a6de9839d8af";


    /**
     * 发现
     */
    //发现标签
    public static final String URL_FIND_LABEL = "http://s.search.bilibili.com/main/hotword?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&sign=4231accec4b6af800d407ef49b2720b9";


    /**
     * 直播
     */
    //直播
    public static final String URL_LIVE = "http://live.bilibili.com/AppNewIndex/common?_device=android&platform=android&scale=hdpi";
    //推荐主播
    public static final String URL_RECOMMEND_ANCHOR = "http://live.bilibili.com/AppNewIndex/recommend?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&scale=xxhdpi&sign=1b4296df47d20aaae498eb0f7f733671";
    //红叶祭
    public static final String URL_Red_AUTUMAL = "http://live.bilibili.com/AppRoom/opTop?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&room_id=101526&scale=xxhdpi&type=redleaf&sign=88ea07a52af21295063cd1851438a186";
    //互动
    public static final String URL_INTERACTION = "http://live.bilibili.com/AppRoom/msg?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&room_id=101526&sign=481515e7ecb1457cde2f67955ccfdc30";
    //礼物
    public static final String URL_GIFT = "http://live.bilibili.com/AppIndex/getAllItem?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&scale=xxhdpi&sign=1b4296df47d20aaae498eb0f7f733671";
    //发现 话题中心
    public static final String URL_FIND_TOPIC = "http://api.bilibili.com/topic/getlist?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&page=1&pagesize=20&platform=android&ts=1476963186000&sign=694d2d0347acb35ace274ca7f078d0f9";
    //发现 活动中心
    public static final String URL_ACTIVYTY = "http://api.bilibili.com/event/getlist?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&page=1&pagesize=20&platform=android&ts=1476963423000&sign=8d5430554f327a26efd2aeabafbd44d3";


    //全部直播拼接
    //最热hottest  最新latest
    public static final String URL_NEW_HOT_DIRECT(String TYPE) {

        String url = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=1&platform=android&sort=" + TYPE + "&sign=0716c77afd0ee861116de3a551248e7b";

        return url;

    }

    //绘画专区
    public static final String URL_PAINTING = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&tag=%E7%BB%98%E7%94%BB&sign=39c1070d48939806ba0500e8b4dd5891";

    //绘画专区 加载
    public static final String URL_PAINTING_LOAD(int position) {
        int i = position;
        String url = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=" + i + "&platform=android&sort=hottest&tag=%E7%BB%98%E7%94%BB&sign=39c1070d48939806ba0500e8b4dd5891";
        return url;
    }

    //绘画专区 大触
    public static final String URL_BIG_CONTACT = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&tag=%E5%A4%A7%E8%A7%A6&sign=6e680070b787eda88fd3db3e41094c78";

    //绘画专区 大触 加载
    public static final String URL_BIG_CONTACT_LOAD(int position) {
        int i = position;
        String url = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=" + i + "&platform=android&sort=hottest&tag=%E5%A4%A7%E8%A7%A6&sign=6e680070b787eda88fd3db3e41094c78";
        return url;
    }

    //绘画专区 手绘
    public static final String URL_FREE_HAND = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&tag=%E6%89%8B%E7%BB%98&sign=a44312b929321694381e30d5aa0f019d";

    //绘画专区 手绘 加载
    public static final String URL_FREE_HAND_LOAD(int position) {
        int i = position;
        String url = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=" + i + "&platform=android&sort=hottest&tag=%E6%89%8B%E7%BB%98&sign=a44312b929321694381e30d5aa0f019d";
        return url;
    }

    //绘画专区 板绘
    public static final String URL_UBEE = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&tag=%E6%9D%BF%E7%BB%98&sign=42e2c551e8f14d8d2f4aa1dfd1b70e71";

    //绘画专区 板绘 加载
    public static final String URL_UBEE_LOAD(int position) {
        int i = position;
        String url = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=" + i + "&platform=android&sort=hottest&tag=%E6%9D%BF%E7%BB%98&sign=42e2c551e8f14d8d2f4aa1dfd1b70e71 ";
        return url;
    }

    //绘画专区 素描
    public static final String URL_SKETCH = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&tag=%E7%B4%A0%E6%8F%8F&sign=7892117ef3b11d4642c4bedf34c007b4";

    //绘画专区 素描 加载
    public static final String URL_SKETCH_LOAD(int position) {
        int i = position;
        String url = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=" + i + "&platform=android&sort=hottest&tag=%E7%B4%A0%E6%8F%8F&sign=7892117ef3b11d4642c4bedf34c007b4";
        return url;
    }

    // 绘画专区 钢笔画
    public static final String URL_PEN_DRAWING = "";

    //绘画专区 钢笔画 加载
    public static final String URL_PEN_DRAWING_LOAD(int position) {
        int i = position;
        String url = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=7b0828c551fedbab&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=" + i + "&platform=android&sort=hottest&tag=%E9%92%A2%E7%AC%94%E7%94%BB&sign=7d1c4d50a25b207245abea53cc6e825f";
        return url;
    }


}
