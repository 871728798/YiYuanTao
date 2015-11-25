package com.qianfeng.yiyuantao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.yiyuantao.R;

/**
 * Created by LXL on 2015/11/25.
 */
public class RegisterActivity extends Activity{
    private ImageView reg_ico_return;
    private EditText regist_phonenum;
    private EditText regist_password;
    private Button bt_regist;
    private TextView tv_fastregist;
    private TextView tv_findpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerlayout);
        initView();

        /**
         * 按返回键返回
         */
        reg_ico_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                finish();
            }
        });
    }



    private void initView() {
        reg_ico_return = (ImageView) findViewById(R.id.reg_ico_return);
        regist_phonenum = (EditText) findViewById(R.id.regist_phonenum);
        regist_password = (EditText) findViewById(R.id.regist_password);
        bt_regist = (Button) findViewById(R.id.bt_regist);
        tv_fastregist = (TextView) findViewById(R.id.tv_fastregist);
        tv_findpassword = (TextView) findViewById(R.id.tv_findpassword);
    }
    /**
     * 登录按钮监听事件
     */
    public void regist(View view) {
        String phonenum = regist_phonenum.getText().toString().trim();
        String password = regist_password.getText().toString().trim();
        if(phonenum!=null&&password!=null&&!phonenum.equals("")&&!password.equals("")){
            Toast.makeText(RegisterActivity.this,"已登录。。。",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(RegisterActivity.this,"请完整填写。。。",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 快速登录
     */
    public void fastRegist(View view){
        Toast.makeText(RegisterActivity.this,"fast。。。",Toast.LENGTH_SHORT).show();
    }
    /**
     * 找回密码
     */
    public void findPassword(View view){
        Toast.makeText(RegisterActivity.this,"find。。。",Toast.LENGTH_SHORT).show();
    }

}
