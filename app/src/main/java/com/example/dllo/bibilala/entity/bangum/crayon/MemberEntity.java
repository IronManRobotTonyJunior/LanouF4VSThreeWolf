package com.example.dllo.bibilala.entity.bangum.crayon;
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
 * Created by dllo on 16/11/2.
 */

public class MemberEntity {

    private String mid;
    private String uname;
    private String sex;
    private String sign;
    private String avatar;
    private String rank;
    private String DisplayRank;
    private LevelInfoEntity level_info;
    private PendantEntity pendant;
    private NameplateEntity nameplate;
    private OfficialVerifyEntity official_verify;
    private VipEntity vip;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDisplayRank() {
        return DisplayRank;
    }

    public void setDisplayRank(String displayRank) {
        DisplayRank = displayRank;
    }

    public LevelInfoEntity getLevel_info() {
        return level_info;
    }

    public void setLevel_info(LevelInfoEntity level_info) {
        this.level_info = level_info;
    }

    public PendantEntity getPendant() {
        return pendant;
    }

    public void setPendant(PendantEntity pendant) {
        this.pendant = pendant;
    }

    public NameplateEntity getNameplate() {
        return nameplate;
    }

    public void setNameplate(NameplateEntity nameplate) {
        this.nameplate = nameplate;
    }

    public OfficialVerifyEntity getOfficial_verify() {
        return official_verify;
    }

    public void setOfficial_verify(OfficialVerifyEntity official_verify) {
        this.official_verify = official_verify;
    }

    public VipEntity getVip() {
        return vip;
    }

    public void setVip(VipEntity vip) {
        this.vip = vip;
    }
}

