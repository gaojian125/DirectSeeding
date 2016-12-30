package bwie.com.library.log;

import com.socks.library.KLog;

/**
 * Created by gaojian on 2016/12/28.
 */

public class Logprint implements Ilog {


    @Override
    public void v(Object object) {
        // BuildConfig.DEBUG;
        KLog.v(object);
    }

    @Override
    public void d(Object object) {
        KLog.d(object);
    }

    @Override
    public void i(Object object) {
        KLog.i(object);
    }

    @Override
    public void w(Object object) {
        KLog.w(object);
    }

    @Override
    public void e(Object object) {
        KLog.e(object);
    }

    @Override
    public void json(String object) {
        KLog.json(object);
    }
}
