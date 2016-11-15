package com.example.dllo.bibilala.activity.login;
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

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;

import java.io.File;

/**
 * Created by dllo on 16/11/14.
 */

public class DownLoadActivity extends BaseActivity {
    private ProgressBar progressBar;
    private TextView tvStorage, tvAvailable;
    private ImageView imaUpdate;
    private Animation animation;


    @Override
    protected int setLayout() {

        return R.layout.activity_down_load;

    }

    @Override
    protected void initView() {
        progressBar = bindView(R.id.ac_down_load_progress_bar);
        tvStorage = bindView(R.id.down_load_tv_all);
        tvAvailable = bindView(R.id.down_load_tv);
        imaUpdate = bindView(R.id.ac_down_load_ima_update);


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        animation = AnimationUtils.loadAnimation(DownLoadActivity.this, R.anim.ima_update);
        imaUpdate.setAnimation(animation);
        imaUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.start();

            }
        });
        progressBar.setProgress(50);
        // 得到文件系统的信息：存储块大小，总的存储块数量，可用存储块数量
// 获取sd卡空间
// 存储设备会被分为若干个区块
// 每个区块的大小 * 区块总数 = 存储设备的总大小
// 每个区块的大小 * 可用区块的数量 = 存储设备可用大小
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize;
        long totalBlocks;
        long availableBlocks;
// 由于API18（Android4.3）以后getBlockSize过时并且改为了getBlockSizeLong
// 因此这里需要根据版本号来使用那一套API
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            blockSize = stat.getBlockSizeLong();
            totalBlocks = stat.getBlockCountLong();
            availableBlocks = stat.getAvailableBlocksLong();
        } else {
            blockSize = stat.getBlockSize();
            totalBlocks = stat.getBlockCount();
            availableBlocks = stat.getAvailableBlocks();
        }
// 利用formatSize函数把字节转换为用户等看懂的大小数值单位

        String totalText = formatSize(blockSize * totalBlocks);
        String availableText = formatSize(blockSize * availableBlocks);
        tvStorage.setText("主存储:" + totalText + " / ");
        tvAvailable.setText("可用:" + availableText);
    }

    //封装Formatter.formatFileSize方法，具体可以参考安卓的API
    private String formatSize(long size) {
        return Formatter.formatFileSize(this, size);


    }
}
