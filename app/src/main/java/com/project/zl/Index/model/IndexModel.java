package com.project.zl.Index.model;

import com.project.zl.Index.contract.IndexContract;
import com.project.zl.bean.IndexBean;
import com.project.zl.net.RetrofitClient;

import io.reactivex.Flowable;

public class IndexModel implements IndexContract.Model {
    @Override
    public Flowable<IndexBean> getData() {
        return RetrofitClient.getInstance().getApi().getData();
    }
}
