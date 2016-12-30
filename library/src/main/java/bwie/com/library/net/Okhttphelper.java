package bwie.com.library.net;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by gaojian on 2016/12/28.
 */

public class Okhttphelper {
    private static Okhttphelper mOkhttphelper;

    private Okhttphelper() {
    }

    public static Okhttphelper getInstance() {
        if (mOkhttphelper == null) {
            mOkhttphelper = OkhttpHolder.instance;
        }
        return mOkhttphelper;
    }

    static class OkhttpHolder {
        static Okhttphelper instance = new Okhttphelper();
    }

    public OkHttpClient getOKHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(3000, TimeUnit.MILLISECONDS).
                writeTimeout(3000, TimeUnit.MILLISECONDS).
                connectTimeout(3000, TimeUnit.MILLISECONDS);
        List<Interceptor> sList = InterceptorManger.getList();
        if (!sList.isEmpty()) {
            for (Interceptor interceptor : sList) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();
    }
}
