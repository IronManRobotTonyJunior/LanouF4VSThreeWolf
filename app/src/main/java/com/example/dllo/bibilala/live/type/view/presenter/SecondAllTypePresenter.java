package com.example.dllo.bibilala.live.type.view.presenter;
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

import com.example.dllo.bibilala.entity.live.type.secondtype.SecondAllEntity;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.live.type.view.view.IAllTypeView;
import com.example.dllo.bibilala.mvp.model.IModel;
import com.example.dllo.bibilala.mvp.model.ModelImpl;

/**
 * Created by dllo on 16/11/8.
 */

public class SecondAllTypePresenter {

    private IAllTypeView iAllTypeView;
    private IModel model;

    public SecondAllTypePresenter(IAllTypeView iAllTypeView) {
        this.iAllTypeView = iAllTypeView;
        model = new ModelImpl();
    }
    public <T> void startRequest(String url,Class<T> clazz){
        iAllTypeView.showDialog();
        model.startRequest(url, clazz, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                iAllTypeView.onAllType((SecondAllEntity) result);
            }

            @Override
            public void onFailed() {
                iAllTypeView.showDialog();
                iAllTypeView.onError();

            }
        });
    }
}
