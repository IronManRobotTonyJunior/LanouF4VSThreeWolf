package com.example.dllo.bibilala.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.main.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by 刘城羊 on 16/7/10.
 */
public class WelcomeActivity extends BaseActivity implements View.OnClickListener{
    private TextView textView;
    private ImageView imageView;
    private Timer timer;
    private TimerTask timerTask;
    private int index = 5 ;




    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        textView = (TextView) findViewById(R.id.text_time);
        imageView = (ImageView) findViewById(R.id.image);
        textView.setOnClickListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        //初始化计时器相关类的对象
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {

                handler.sendEmptyMessage(0);
            }
        };


        //开始执行计时器,.每隔1000毫秒都会执行一下TimerTask对象里面的任务
        timer.schedule(timerTask,0,1000);


    }


    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            textView.setText(index-- +"");
            if (index ==0) {
                startNextPage();
            }
            return false;
        }
    });

    //跳转到主界面,并停止计时器/取消图片的下载/关闭自己
    private void startNextPage() {
        startActivity(new Intent(this, MainActivity.class));
        timer.cancel();
        finish();

    }




    @Override
    public void onClick(View v) {
        startNextPage();

    }
}
