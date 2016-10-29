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

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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
        button = bindView(R.id.btnsss);
        mButton = bindView(R.id.btns);
        btn = bindView(R.id.btn_re);
        mDeleteSecret = bindView(R.id.sign_ima_delete_secret);
        mDeletePhone = bindView(R.id.sign_ima_phone);


    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mBack.setOnClickListener(this);
        button.setOnClickListener(this);
        btn.setOnClickListener(this);
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
                if (singSercret) {
                    mDeletePhone.setVisibility(View.VISIBLE);
                }
                if (singPhone) {
                    mDeletePhone.setVisibility(View.VISIBLE);
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


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_ac_ima_back:
                finish();
                break;
            case R.id.btn_re:
                btn.getResources().getColor(R.color.colors);
                break;
            case R.id.sign_ima_delete_secret:
                mSecret.setText("");

                break;
            case R.id.sign_ima_phone:
                mPhone.setText("");
                break;

        }

    }
}
