package com.project.zl.net;


import com.project.zl.bean.IndexBean;

import io.reactivex.Flowable;
import retrofit2.http.POST;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public interface APIService {

    /**
     * 登陆
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
//    @FormUrlEncoded
//    @POST("user/login")
//    Flowable<BaseObjectBean<IndexBean>> login(@Field("username") String username,
//                                              @Field("password") String password);
    @POST("Index/index")
    Flowable<IndexBean> getData();

}
