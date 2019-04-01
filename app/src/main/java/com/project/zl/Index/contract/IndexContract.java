package com.project.zl.Index.contract;

import com.project.zl.base.BaseView;
import com.project.zl.bean.IndexBean;

import io.reactivex.Flowable;

public interface IndexContract {
    interface Model {
        Flowable<IndexBean> getData();
    }
    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(IndexBean bean);
    }
    interface Presenter {
        /**
         * 请求数据
         *
         * @param username
         * @param password
         */
        void getData();
    }
}
