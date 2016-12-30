package bwie.com.library.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gaojian on 2016/12/28.
 */

public class RetrofitHelper {
    public static Retrofit getRetrofit(String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl).client(Okhttphelper.getInstance().getOKHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return builder.build();
    }

    public <T> T getServer(String baseUrl, Class<T> cls) {
        return getRetrofit(baseUrl).create(cls);
    }
}
