package com.example.dllo.bibilala.entity.bangumentity; /*
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
 * Created by dllo on 16/10/22.
 */
public class ResultEntity {
    private AdEntity ad;
    private List<CartoonEntity> china;
    private PreviousEntity previous;
    private List<CartoonEntity> serializing;

    public AdEntity getAd() {
        return ad;
    }

    public void setAd(AdEntity ad) {
        this.ad = ad;
    }

    public List<CartoonEntity> getChina() {
        return china;
    }

    public void setChina(List<CartoonEntity> china) {
        this.china = china;
    }

    public PreviousEntity getPrevious() {
        return previous;
    }

    public void setPrevious(PreviousEntity previous) {
        this.previous = previous;
    }

    public List<CartoonEntity> getSerializing() {
        return serializing;
    }

    public void setSerializing(List<CartoonEntity> serializing) {
        this.serializing = serializing;
    }
}
