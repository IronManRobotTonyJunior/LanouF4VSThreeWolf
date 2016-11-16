package com.example.dllo.bibilala.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.login.User;

import cn.bmob.v3.listener.SaveListener;

public class SettingPasswordActivity extends BaseActivity {
    private TextInputLayout etPasswordLayout;
    private EditText etPassword;
    private ImageView imgInputDeletePassword;
    private TextInputLayout etCheckedLayout;
    private EditText etChecked;
    private ImageView imgInputDeleteChecked;
    //    private CheckBox cbEyePassword;
    //    private CheckBox cbEyeChecked;
    private Button mBtn;
    private User mUser;
    private String mTelephone;

    @Override
    protected int setLayout() {
        return R.layout.activity_setting_password;
    }

    @Override
    protected void initView() {
        ImageView imgBack = bindView(R.id.setting_ima_back);
        RelativeLayout linearLayoutPassword = bindView(R.id.password_setting);
        RelativeLayout linearLayoutChecked = bindView(R.id.password_checked);
        etPasswordLayout = (TextInputLayout) linearLayoutPassword.findViewById(R.id.login_til);
        etCheckedLayout = (TextInputLayout) linearLayoutChecked.findViewById(R.id.login_til);
        etPassword = (EditText) linearLayoutPassword.findViewById(R.id.login_et);
        etChecked = (EditText) linearLayoutChecked.findViewById(R.id.login_et);
        imgInputDeletePassword = (ImageView) linearLayoutPassword.findViewById(R.id.login_img_delete_input);
        imgInputDeleteChecked = (ImageView) linearLayoutChecked.findViewById(R.id.login_img_delete_input);
        mUser = new User();
        Intent intent = getIntent();
        mTelephone = intent.getStringExtra("telephone");
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        cbEyePassword = (CheckBox) linearLayoutPassword.findViewById(R.id.login_cb_eye);
//        cbEyeChecked = (CheckBox) linearLayoutChecked.findViewById(R.id.login_cb_eye);

        // 设置验证码不隐藏

    }


    @Override
    protected void initData(Bundle savedInstanceState) {
        // 三个EditText的删除文本键
        imgInputDeletePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPassword.setText("");
            }
        });
        imgInputDeleteChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etChecked.setText("");
            }
        });

        //设置隐藏字符
        etPasswordLayout.setHint("密码(长度6-16位,支持数字,字母,字符)");
        etCheckedLayout.setHint("输入密码");


        mBtn = bindView(R.id.complete_regist);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etChecked.getText().toString().equals(etPassword.getText().toString())) {
                    mUser.setPassword(etPassword.getText().toString());
                    mUser.setTelephone(mTelephone);
                    mUser.save(SettingPasswordActivity.this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Log.d("SettingPasswordActivity", "插入成功");
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Log.d("SettingPasswordActivity", "失败");
                            Log.d("SettingPasswordActivity", "i:" + i);
                            Log.d("SettingPasswordActivity", s);
                        }
                    });
                    Toast.makeText(SettingPasswordActivity.this, "已成功注册", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    etCheckedLayout.setError("两次密码输入不相同");
                    etCheckedLayout.setErrorEnabled(true);
                }

            }
        });
        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    cbEyePassword.setVisibility(View.VISIBLE);
//                    cbEyeChecked.setVisibility(View.GONE);
//                } else {
//                    cbEyePassword.setVisibility(View.GONE);
//                    cbEyeChecked.setVisibility(View.VISIBLE);
//                }
            }
        });
//        cbEyePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//                    etPassword.setSelection(etPassword.getText().length());
//                } else {
//                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    etPassword.setSelection(etPassword.getText().length());
//
//                }
//            }
//        });
//        cbEyeChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    etChecked.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//                    etChecked.setSelection(etChecked.getText().length());
//                } else {
//                    etChecked.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    etChecked.setSelection(etChecked.getText().length());
//                }
//            }
//        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setVisibility(s, imgInputDeletePassword);
            }
        });
        etChecked.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setVisibility(s, imgInputDeleteChecked);
            }
        });

    }

    private void setVisibility(Editable s, ImageView currentImg) {
        if (s.length() > 0) {
            currentImg.setVisibility(View.VISIBLE);
            if (etPassword.getText().length() > 5 && etChecked.getText().length() > 5) {
                mBtn.setEnabled(true);
            } else {
                mBtn.setEnabled(false);
            }
        } else {
            currentImg.setVisibility(View.GONE);
            mBtn.setEnabled(false);
        }
    }
}
