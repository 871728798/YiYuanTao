package com.qianfeng.yiyuantao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.yiyuantao.R;

/**
 * Created by Administrator on 2015/11/25 0025.
 */
public class SearchActivity extends Activity implements View.OnClickListener, TextWatcher {

    private EditText editText;
    private TextView textView;
    private boolean isNull = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        editText = (EditText) findViewById(R.id.et_search_key);
        editText.addTextChangedListener(this);

        textView = (TextView) findViewById(R.id.tv_exit);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_exit:
                if(isNull){
                    this.finish();
                }else{
                    Intent intent = new Intent(this, SearchResultActivity.class);
                    intent.putExtra("key", editText.getText().toString());
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if("".equals(editable.toString()) || editable == null){
            textView.setText("取消");
            isNull = true;
        }else{
            textView.setText("搜索");
            isNull = false;
        }

    }
}
