package com.project.zl.Index;

import android.os.Bundle;
import android.util.Log;

import com.project.zl.Index.contract.IndexContract;
import com.project.zl.Index.presenter.IndexPresenter;
import com.project.zl.R;
import com.project.zl.Utils.GlideImageLoader;
import com.project.zl.Utils.ProgressDialog;
import com.project.zl.base.BaseMvpActivity;
import com.project.zl.bean.IndexBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndexActivity extends BaseMvpActivity<IndexPresenter> implements IndexContract.View {
    @BindView(R.id.banner)
    Banner banner;
    private List<IndexBean.DataBean.BannerBean> list;
    private List<String> mlist=new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_index;
    }

    @Override
    public void initView() {
        /***
         * 一定要绑定
         */
        mPresenter = new IndexPresenter();
        mPresenter.attachView(this);
        mPresenter.getData();
    }

    @Override
    public void onSuccess(IndexBean bean) {
        list=bean.getData().getBanner();
       for (int i=0;i<list.size();i++){
           mlist.add(list.get(i).getUrl());
       }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(mlist);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.start();
    }

    @Override
    public void showLoading() {
        Log.d("tag", "显示进度条");
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        Log.d("tag", "隐藏进度条");
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {
        Log.d("tag", "请求错误"+throwable.getMessage());
    }

}
