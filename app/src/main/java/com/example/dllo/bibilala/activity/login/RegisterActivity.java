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

import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by dllo on 16/10/31.
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText et;
    private IntentFilter filter2;
    private Handler handler;
    private String strContent;
    private Button btn;
    private String patternCoder = "(?<!--\\d)\\d{6}(?!\\d)";
    private ImageView mImgBack;
    private static final int REQUEST_CODE = 100;


    protected int setLayout() {
        return R.layout.register_ac;
    }

    @Override
    protected void initView() {
        et = bindView(R.id.question_et_phone);
        btn = bindView(R.id.btn_obtain_gray);
        mImgBack = bindView(R.id.question_ima_back);
        mImgBack.setOnClickListener(this);
        btn.setOnClickListener(this);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!et.getText().toString().equals("")) {
                    btn.setEnabled(true);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.question_ima_back:
                finish();
                break;
            case R.id.btn_obtain_gray:
                if (isPhoneNumberValid(et.getText().toString())) {
                    initDialog();
                } else {
                    Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    // 判断是否为电话号码
    private boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;
        /**
         * valid phone number format;
         */
        String expression1 = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{5})$";
        /**
         * valid phone number format;
         */
        String expression2 = "^\\(?(\\d{3})\\)?[- ]?(\\d{4})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern1 = Pattern.compile(expression1);
        Matcher matcher1 = pattern1.matcher(inputStr);

        Pattern pattern2 = Pattern.compile(expression2);
        Matcher matcher2 = pattern2.matcher(inputStr);
        if (matcher1.matches() || matcher2.matches()) {
            isValid = true;
        }
        return isValid;
    }


    private void initDialog() {
        AlertDialog.Builder custom = new AlertDialog.Builder(RegisterActivity.this);
        custom.setTitle("确认手机号码");
        custom.setMessage("我们将发送验证码短信到这个号码:\n+86 " + et.getText());
        custom.setNegativeButton("好", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SMSSDK.getVerificationCode("+86", et.getText().toString().trim(), new OnSendMessageHandler() {
                    @Override
                    public boolean onSendMessage(String s, String s1) {
                        Log.d("RegisterFragment", s);
                        Log.d("RegisterFragment", s1);
                        return false;
                    }
                });
                et.setText("");
                initCheckVerificationCodeDialog();
                Toast.makeText(RegisterActivity.this, "已发送", Toast.LENGTH_SHORT).show();
            }
        });
        custom.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        custom.show();
    }

    private void initCheckVerificationCodeDialog() {
        final AlertDialog.Builder dialogCheck = new AlertDialog.Builder(RegisterActivity.this);
        dialogCheck.setTitle("请输入验证码");
        View v = LayoutInflater.from(this).inflate(R.layout.dialog_verification, null);
        dialogCheck.setView(v);
        final EditText verificationCode = (EditText) v.findViewById(R.id.dialog_verification);
        dialogCheck.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RegisterActivity.this, "验证成功, 玲姐最美", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(RegisterActivity.this, SettingPasswordActivity.class);
//                startActivityForResult(intent, REQUEST_CODE);
                finish();
            }
        });
        dialogCheck.setPositiveButton("取消,我不注册了T.T", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogCheck.show();
    }


}

