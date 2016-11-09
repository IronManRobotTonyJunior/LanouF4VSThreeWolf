package com.example.dllo.bibilala.live.type.presenter;
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

import com.example.dllo.bibilala.entity.bangumentity.crayonentity.CrayonFootEntity;
import com.example.dllo.bibilala.entity.liveentity.typeentity.AllTypeEntity;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.live.type.view.IAllTypeView;
import com.example.dllo.bibilala.mvp.model.IModel;
import com.example.dllo.bibilala.mvp.model.ModelImpl;

/**
 * Created by dllo on 16/11/8.
 */

public class AllTypePresenter {
    private IAllTypeView allTypeView;
    private IModel model;

    public AllTypePresenter(IAllTypeView allTypeView) {
        this.allTypeView = allTypeView;
        model = new ModelImpl();
    }
    public<T> void startRequest(String url , Class<T>clazz){
        allTypeView.showDialog();
        model.startRequest(url, clazz, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                if (result instanceof AllTypeEntity) {
                    allTypeView.onAllType((AllTypeEntity) result);
                }
                allTypeView.dismissDialog();

            }

            @Override
            public void onFailed() {
                allTypeView.dismissDialog();
                allTypeView.onError();

            }
        });
    }
}
