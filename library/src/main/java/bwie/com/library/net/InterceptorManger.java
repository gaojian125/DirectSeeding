package bwie.com.library.net;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

/**
 * Created by gaojian on 2016/12/28.
 */

public class InterceptorManger {
    private static List<Interceptor> sList = new ArrayList<>();

    public static void add(Interceptor interceptor) {
        sList.add(interceptor);
    }

    public static List<Interceptor> getList() {
        return sList;

    }
}
