package com.project.zl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.project.zl.Index.IndexActivity;
import com.project.zl.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.login)
    Button login;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }


    @OnClick(R.id.login)
    public void onViewClicked() {
        Log.d("tag","点击");
        toClass(this,IndexActivity.class);
    }
}
