package com.example.dllo.bibilala.recommendentity.type;

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
 *
 * 没用上
 */
public  final class Types {

    public static final int RECOMMEND_LB=0;
    public static final int RECOMMEND_ONE=1;
    public static final int RECOMMEND_TWO=2;
    public static final int RECOMMEND_THREE =3;
    public static final int RECOMMEND_FOUR =4;
    public static final int RECOMMEND_FIVE =5;
    public static final int RECOMMEND_SIX =6;
    public static final int RECOMMEND_SEVEN=7;
    public static final int RECOMMEND_EIGHT =8;
    public static final int RECOMMEND_NINE  =9;
    public static final int RECOMMEND_TEN =10;
    public static final int RECOMMEND_ELEVEN =11;
    public static final int RECOMMEND_TWELVE =12;
    public static final int RECOMMEND_THIRTEEN =13;
    public static final int RECOMMEND_FOURTEEN =14;
    public static final int RECOMMEND_FIFTEEN =15;
    public static final int RECOMMEND_SIXTEEN =16;
    public static final int RECOMMEND_SEVENTEEN =17;
    public static final int RECOMMEND_EIGHTEEN =18;
    public static final int RECOMMEND_NINETEEN =19;
    public static final int RECOMMEND_TWENTY =20;

    String url;
    int viewType;

    public Types(int viewType, String url) {
        this.viewType = viewType;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
