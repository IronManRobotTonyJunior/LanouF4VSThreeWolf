package com.example.dllo.bibilala.live.view;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class LiveActivity extends BaseActivity implements View.OnClickListener {

    private String mPlayUrl;
    private VideoView mVideoView;
    private String mTitle;
    private String mName;
    private int mOnline;
    private int mRoomId;
    private String mIconUrl;
    private ImageView mAnchorIcon;
    private ImageView mLoadImage;

    @Override
    protected int setLayout() {
        return R.layout.activity_live;
    }

    @Override
    protected void initView() {
        mVideoView = bindView(R.id.live_activity_video_view);
        mLoadImage = bindView(R.id.live_loading_anim);
        TextView tvTitle = bindView(R.id.live_activity_title);
        TextView tvName = bindView(R.id.live_anchor_name);
        TextView tvOnline = bindView(R.id.live_audience_number);
        TabLayout tabLayout = bindView(R.id.live_activity_tab);
        ViewPager viewPager = bindView(R.id.live_activity_vp);
        mAnchorIcon = bindView(R.id.live_anchor_icon);
        Intent intent = getIntent();
        mPlayUrl = intent.getStringExtra("playUrl");
        mTitle = intent.getStringExtra("title");
        mName = intent.getStringExtra("name");
        mOnline = intent.getIntExtra("online", 0);
        mRoomId = intent.getIntExtra("roomId", 0);
        mIconUrl = intent.getStringExtra("iconUrl");
        Log.d("LiveActivity", "mOnline:" + mOnline);
        tvTitle.setText(mTitle);
        tvName.setText(mName);
        tvOnline.setText(mOnline + "");
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        Glide.with(this)
                .load(mIconUrl)
                .bitmapTransform(new CropCircleTransformation(this))
                .placeholder(R.mipmap.bili_default_avatar_big)
                .into(mAnchorIcon);
        mVideoView.setVideoPath(mPlayUrl);
        mVideoView.requestFocus();
        mLoadImage.setBackgroundResource(R.drawable.bili_loading_tv_chan);
        final AnimationDrawable anim = (AnimationDrawable) mLoadImage.getBackground();
        mVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what) {
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        mVideoView.pause();
                        anim.start();
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                        anim.stop();
                        mLoadImage.setVisibility(View.GONE);
                        mVideoView.setOnClickListener(LiveActivity.this);
                        mVideoView.start();
                        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                mp.setPlaybackSpeed(1.0f);
                            }
                        });
                        break;
                }
                return false;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.live_activity_video_view:
                break;
        }
    }
}
