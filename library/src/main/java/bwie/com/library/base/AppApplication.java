package bwie.com.library.base;

import android.app.Application;
import android.content.Context;

import bwie.com.library.net.InterceptorManger;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by gaojian on 2016/12/28.
 */

public class AppApplication extends Application {
    private String baseUrl = "";
    private static AppApplication sAppApplication;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppApplication=this;
        sContext=this;
        inintOkHttp();
    }

    private void inintOkHttp() {
        HttpLoggingInterceptor httpInterceptor = new HttpLoggingInterceptor();
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        InterceptorManger.add(httpInterceptor);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static AppApplication getAppApplication() {
        return sAppApplication;
    }

    public static Context getContext() {
        return sContext;
    }
}
