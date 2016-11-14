package com.example.dllo.bibilala.bangumi.view; /*
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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.bangumi.presenter.SecondBangumPresenter;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.bangumentity.add.AddCrayonEntity;
import com.example.dllo.bibilala.entity.bangumentity.add.QuarterlyEntity;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.CrayonFootEntity;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.ListEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by dllo on 16ews/11/1.
 */
public class CrayonActivity extends BaseActivity implements ICrayonView {
    private RecyclerView mRecyclerView;
    private SecondBangumPresenter mPresenter;
    private CrayonAdapter mAdapter;
    private List<ListEntity> entityList;
    private VideoView mVideoView;
    private String[] video = {
           "http://wvideo.spriteapp.cn/video/2016/1101/58186c621031a_wpd.mp4"

    };


    @Override
    protected int setLayout() {
        return R.layout.crayon_activity;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.crayon_ac_rv);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        Vitamio.isInitialized(this);
        playFunction();
        entityList = new ArrayList<>();
        mPresenter = new SecondBangumPresenter(this);
        Intent intent = getIntent();
        String mUrl = intent.getStringExtra("july");


        mPresenter.startRequest(mUrl, CrayonFootEntity.class);






    }




    @Override
    public void onCrayonFootEntity(CrayonFootEntity crayonFootEntity) {
        entityList = crayonFootEntity.getResult().getList();
        crayonResult();


    }

    @Override
    public void onResponse(AddCrayonEntity entity) {

    }

    @Override
    public void onQuarterlyEntity(QuarterlyEntity entity) {

    }




    private void crayonResult() {
        mAdapter = new CrayonAdapter(this, R.layout.item_crayon_ac, entityList);
        mAdapter.setEntityList(entityList);
        LinearLayoutManager manager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showDialog() {


    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void onError() {

    }
    void playFunction(){
        String path = "";
        path = video[new Random().nextInt(video.length)];
        if (path == "") {
            Toast.makeText(this, "请填写视频的URL", Toast.LENGTH_LONG).show();
            return;
        }
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        mVideoView.setVideoPath(path);   //设置视频网络地址
//      mVideoView.setVideoURI(Uri.parse(path)); //也可以是本地,也可以是网络地址
        mVideoView.setMediaController(new MediaController(this)); //设置媒体控制器
        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);   //设置视频的缩放参数,这里设置为拉伸
        mVideoView.requestFocus();
        //视频播放器的准备,此时播放器已经准备好了,此处可以设置一下播放速度,播放位置等等
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //此处设置播放速度为正常速度1
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
        //当播放完成后,从头开始
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(0);   //转到第一帧
                mediaPlayer.start();     //开始播放
            }
        });

    }
}
