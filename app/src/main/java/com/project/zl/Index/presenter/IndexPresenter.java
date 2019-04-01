package com.project.zl.Index.presenter;

import com.project.zl.Index.contract.IndexContract;
import com.project.zl.Index.model.IndexModel;
import com.project.zl.base.BasePresenter;
import com.project.zl.bean.IndexBean;
import com.project.zl.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class IndexPresenter extends BasePresenter<IndexContract.View> implements IndexContract.Presenter {
    private IndexContract.Model model;

    public IndexPresenter() {
        model = new IndexModel();
    }

    @Override
    public void getData() {
//View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData().compose(RxScheduler.<IndexBean>Flo_io_main())
                .as(mView.<IndexBean>bindAutoDispose())
                .subscribe(new Consumer<IndexBean>() {
                    @Override
                    public void accept(IndexBean indexBeanBaseObjectBean) throws Exception {
                        mView.onSuccess(indexBeanBaseObjectBean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();

                    }
                });
    }
}
