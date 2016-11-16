package com.example.dllo.bibilala.live.view;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;

import java.util.TimerTask;

import io.vov.vitamio.MediaPlayer;
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
    private ImageView mImgBackground;
    private static final int SHOW_TIME = 5000;
    private static final int VOLUME_SHOW_TIME = 3000;
    private static final int MAX_VOLUME = 100;
    private CheckBox mCbPlay;
    private ImageView mVideoBack;
    private TextView mAnchorRoom;
    private AudioManager mAudioManager;
    private FrameLayout mVideoBackLayout;
    private ImageView mPlay;
    private int mLastY;
    private ProgressBar mProgressBarVolume;
    private LinearLayout mLlVolume;
    private TextView mTvVolume;

    @Override
    protected int setLayout() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_live;
    }

    @Override
    protected void initView() {
        mLlVolume = bindView(R.id.volume_set_ll);
        mTvVolume = bindView(R.id.progress_rate);
        mProgressBarVolume = bindView(R.id.live_progress);
        mProgressBarVolume.setMax(MAX_VOLUME);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mPlay = bindView(R.id.ic_tv_play);
        mVideoBackLayout = bindView(R.id.center_layout);
        mVideoView = bindView(R.id.live_activity_video_view);
        mLoadImage = bindView(R.id.live_loading_anim);
        mVideoBack = bindView(R.id.video_img_back);
        mCbPlay = bindView(R.id.cb_play);
        mAnchorRoom = bindView(R.id.anchor_room_name);
        TextView tvTitle = bindView(R.id.live_activity_title);
        TextView tvName = bindView(R.id.live_anchor_name);
        TextView tvOnline = bindView(R.id.live_audience_number);
        mImgBackground = bindView(R.id.live_img_background);
        TabLayout tabLayout = bindView(R.id.live_activity_tab);
        ViewPager viewPager = bindView(R.id.live_activity_vp);
        LiveFragmentAdapter adapter = new LiveFragmentAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
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
        mAnchorRoom.setText(tvName.getText().toString() + "的直播间");
        mCbPlay.setOnClickListener(this);
        mVideoBack.setOnClickListener(this);
        mPlay.setOnClickListener(this);

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

        // 配置VideoView的信息
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
                        mImgBackground.setVisibility(View.GONE);
                        mLoadImage.setVisibility(View.GONE);
                        mVideoView.start();

                        // 配置手势滑动
                        mVideoView.setOnTouchListener(new View.OnTouchListener() {
                            private TimerTask mTaskVolume = new TimerTask() {
                                @Override
                                public void run() {
                                    if (mLlVolume.getVisibility() == View.VISIBLE) {
                                        mLlVolume.setVisibility(View.GONE);
                                    }
                                }
                            };
                            private boolean mContinueShow = false;
                            private int dy;
                            private int sumY;
                            private Handler handler = new Handler();

                            // 上次改变的Y值 控制是否收缩状态栏

                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                int y = (int) event.getY();
                                switch (event.getAction()) {
                                    case MotionEvent.ACTION_MOVE:
                                        mTaskVolume.cancel();
                                        dy = y - mLastY;
                                        sumY += -dy / 8;
                                        mLlVolume.setVisibility(View.VISIBLE);
                                        mProgressBarVolume.setProgress(sumY);
                                        mTvVolume.setText(mProgressBarVolume.getProgress() + "%");
                                        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, mProgressBarVolume.getProgress(), 0);
                                        handler.postDelayed(mTaskVolume, VOLUME_SHOW_TIME);
                                        break;
                                    case MotionEvent.ACTION_DOWN:
                                        if (Math.abs(mLastY - y) < 1) {
                                            dy = 0;
                                        }
                                        if (Math.abs(dy) < 1) {
                                            TimerTask task = new TimerTask() {
                                                @Override
                                                public void run() {
                                                    if (mContinueShow) {
                                                        mContinueShow = false;
                                                        dismissTitle();
                                                    }
                                                }
                                            };
                                            if (!mContinueShow) {
                                                showTitle(task, handler);
                                                mContinueShow = true;
                                            } else {
                                                mContinueShow = false;
                                                task.cancel();
                                                dismissTitle();
                                            }
                                        }
                                        break;
                                    case MotionEvent.ACTION_UP:
                                        break;

                                }
                                mLastY = y;
                                return true;
                            }

                        });
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

    private void dismissTitle() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mCbPlay.setVisibility(View.GONE);
        mVideoBack.setVisibility(View.GONE);
        mAnchorRoom.setVisibility(View.GONE);
    }

    private void showTitle(TimerTask task, Handler handler) {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        handler.postDelayed(task, SHOW_TIME);
        mCbPlay.setVisibility(View.VISIBLE);
        mVideoBack.setVisibility(View.VISIBLE);
        mAnchorRoom.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_img_back:
                mVideoView.pause();
                finish();
                break;
            case R.id.cb_play:
                if (mCbPlay.isChecked()) {
                    mVideoView.pause();
                    mPlay.setVisibility(View.VISIBLE);
                } else {
                    mVideoView.start();
                    mPlay.setVisibility(View.GONE);
                }
                break;
            case R.id.ic_tv_play:
                mVideoView.start();
                mPlay.setVisibility(View.GONE);
                mCbPlay.setChecked(false);
                break;
            default:
                break;
        }
    }
}
