package com.example.dllo.bibilala.activity.login; /*
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

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by dllo on 16/10/31.
 */

/**
 * 忘记密码界面
 */
public class QuestionActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mImaBack;
    private Button mBtnGray, mBtnPowder;
    private EditText mEtPhone;
    private TextView mTvBlack, mTvPowder;
    private ProgressDialog mProgressDialog;

    @Override
    protected int setLayout() {
        return R.layout.question_ac;
    }

    @Override
    protected void initView() {
        mProgressDialog = createDialog();
        mImaBack = bindView(R.id.question_ima_back);
        mBtnGray = bindView(R.id.btn_obtain_gray);
        mBtnPowder = bindView(R.id.btn_obtain_powder);
        mEtPhone = bindView(R.id.question_et_phone);
        mTvBlack = bindView(R.id.question_tv_black);
        mTvPowder = bindView(R.id.question_tv_powder);

    }

    //点击获取验证码之后会显示
    private ProgressDialog createDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("正在获取...");
        dialog.setProgressStyle(R.style.styleTwo);
        return dialog;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mImaBack.setOnClickListener(this);
        mBtnPowder.setOnClickListener(this);
        mEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    mBtnGray.setVisibility(View.GONE);
                    mBtnPowder.setVisibility(View.VISIBLE);
                }else {
                    mBtnGray.setVisibility(View.VISIBLE);
                    mBtnPowder.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.question_ima_back:
                finish();
                break;
            case R.id.btn_obtain_powder:
                mTvBlack.setVisibility(View.GONE);
                mTvPowder.setVisibility(View.VISIBLE);
                mProgressDialog.show();
                final Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mProgressDialog.dismiss();

                    }
                });
                thread.start();
                break;
        }
    }
}
