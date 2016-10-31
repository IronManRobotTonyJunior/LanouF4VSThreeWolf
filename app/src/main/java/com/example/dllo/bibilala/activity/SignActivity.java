package com.example.dllo.bibilala.activity;
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

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;

/**
 * Created by dllo on 16/10/29.
 */

public class SignActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mBack, mBlue, mGray, mBlueV, mGrayV, mDeleteSecret, mDeletePhone;
    private EditText mSecret, mPhone;
    private Button button, mButton, btn;
    private TextWatcher mTextWatcher;
    private TextView tvThread, tvThreads, tvPowder, tvGray;
    private Button btnQuestion;

    @Override
    protected int setLayout() {
        return R.layout.sign_activity;
    }

    @Override
    protected void initView() {
        mBack = bindView(R.id.sign_ac_ima_back);
        mSecret = bindView(R.id.sign_secret_et);
        mGray = bindView(R.id.sign_ac_gray_b);
        mBlue = bindView(R.id.sign_ac_blue_b);
        mBlueV = bindView(R.id.sign_ac_blue_z);
        mGrayV = bindView(R.id.sign_ac_gray_z);
        mPhone = bindView(R.id.editText);
        button = bindView(R.id.btn_sign);
        mButton = bindView(R.id.btns);
        btn = bindView(R.id.btn_re);
        mDeleteSecret = bindView(R.id.sign_ima_delete_secret);
        mDeletePhone = bindView(R.id.sign_ima_phone);
        tvThread = bindView(R.id.sign_xian_tv_one);
        tvThreads = bindView(R.id.sign_xian_tv_two);
        tvGray = bindView(R.id.sign_tv_thread_powder);
        tvPowder = bindView(R.id.sign_tv_thread_gray);
        btnQuestion = bindView(R.id.button);


    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mBack.setOnClickListener(this);
        button.setOnClickListener(this);
        btn.setOnClickListener(this);
        btnQuestion.setOnClickListener(this);
        mDeleteSecret.setOnClickListener(this);
        mDeletePhone.setOnClickListener(this);
        mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean singSercret = mSecret.getText().length() > 0;
                boolean singPhone = mPhone.getText().length() > 0;
                if (singSercret & singPhone) {
                    mButton.setVisibility(View.GONE);
                    button.setVisibility(View.VISIBLE);
                } else {
                    mButton.setVisibility(View.VISIBLE);
                    button.setVisibility(View.GONE);

                }
                if (singPhone) {
                    mDeletePhone.setVisibility(View.VISIBLE);
                } else {
                    mDeletePhone.setVisibility(View.GONE);
                }
                if (singSercret) {
                    mDeleteSecret.setVisibility(View.VISIBLE);
                } else {
                    mDeleteSecret.setVisibility(View.GONE);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        mSecret.addTextChangedListener(mTextWatcher);
        mPhone.addTextChangedListener(mTextWatcher);

        mSecret.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mBlueV.setVisibility(View.GONE);
                    mGrayV.setVisibility(View.GONE);
                    mGray.setVisibility(View.VISIBLE);
                    mBlue.setVisibility(View.VISIBLE);
                } else {
                    mGray.setVisibility(View.GONE);
                    mBlue.setVisibility(View.GONE);
                    mBlueV.setVisibility(View.VISIBLE);
                    mGrayV.setVisibility(View.VISIBLE);


                }
            }
        });
        mPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    tvGray.setVisibility(View.VISIBLE);
                    tvPowder.setVisibility(View.GONE);
                    tvThread.setVisibility(View.VISIBLE);
                    tvThreads.setVisibility(View.GONE);


                } else {
                    tvGray.setVisibility(View.GONE);
                    tvPowder.setVisibility(View.VISIBLE);
                    tvThread.setVisibility(View.GONE);
                    tvThreads.setVisibility(View.VISIBLE);

                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_ac_ima_back:
                finish();
                break;
            case R.id.btn_re:
                btn.getResources().getColor(R.color.colors);
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.sign_ima_delete_secret:
                mSecret.setText("");
                break;
            case R.id.sign_ima_phone:
                mPhone.setText("");
                break;
            case R.id.btn_sign:
                Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                Intent intents = new Intent(SignActivity.this,QuestionActivity.class);
                startActivity(intents);
                break;


        }

    }
}
