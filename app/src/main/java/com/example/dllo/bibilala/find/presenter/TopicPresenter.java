package com.example.dllo.bibilala.find.presenter;
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

import com.example.dllo.bibilala.entity.find.FindEntity;
import com.example.dllo.bibilala.entity.find.TopicEntity;
import com.example.dllo.bibilala.find.view.IFindView;
import com.example.dllo.bibilala.find.view.ITopicView;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.mvp.model.IModel;
import com.example.dllo.bibilala.mvp.model.ModelImpl;

/**
 * Created by dllo on 16/11/14.
 */

public class TopicPresenter {
    ITopicView iFindView;
    private IModel model;

    public TopicPresenter(ITopicView iFindView) {
        this.iFindView = iFindView;
        model = new ModelImpl();
    }
    public <T> void startRequest(String url ,Class<T> clazz){
        model.startRequest(url, clazz, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                iFindView.onResponse((TopicEntity) result);
            }

            @Override
            public void onFailed() {
                iFindView.onError();

            }
        });
    }
}
