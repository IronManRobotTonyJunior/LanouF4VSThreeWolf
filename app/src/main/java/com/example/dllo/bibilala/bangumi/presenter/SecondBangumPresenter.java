package com.example.dllo.bibilala.bangumi.presenter;
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

import com.example.dllo.bibilala.bangumi.view.ICrayonView;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.CrayonFootEntity;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.mvp.IModel;
import com.example.dllo.bibilala.mvp.ModelImpl;

/**
 * Created by dllo on 16/11/1.
 */

public class SecondBangumPresenter {
    private IModel model;
    private ICrayonView iCrayonView;

    public SecondBangumPresenter(ICrayonView iCrayonView) {
        this.iCrayonView = iCrayonView;
        model = new ModelImpl();
    }
    public<T> void startRequest(String urlStr,Class<T> clazz){
        iCrayonView.showDialog();
        model.startRequest(urlStr, clazz, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                if (result instanceof CrayonFootEntity) {
                    iCrayonView.onCrayonFootEntity((CrayonFootEntity) result);
                }
                iCrayonView.dismissDialog();
            }

            @Override
            public void onFailed() {
                iCrayonView.onError();
                iCrayonView.dismissDialog();

            }
        });

    }
}
