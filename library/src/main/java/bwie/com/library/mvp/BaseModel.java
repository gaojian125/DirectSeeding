package bwie.com.library.mvp;

import bwie.com.library.base.AppApplication;
import bwie.com.library.net.RetrofitHelper;
import retrofit2.Retrofit;

/**
 * Created by gaojian on 2016/12/28.
 */

public abstract class BaseModel implements IBaseModel {
    private Retrofit mRetrofit;

    @Override
    public void onStart() {
        mRetrofit = RetrofitHelper.getRetrofit(AppApplication.getAppApplication().getBaseUrl());
    }

    @Override
    public void onDestroy() {
        mRetrofit = null;
    }
}
