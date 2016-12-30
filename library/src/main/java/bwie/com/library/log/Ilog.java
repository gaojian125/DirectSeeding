package bwie.com.library.log;

/**
 * Created by gaojian on 2016/12/28.
 */

public interface Ilog {

    void v(Object object);

    void d(Object object);

    void i(Object object);

    void w(Object object);

    void e(Object object);

    void json(String object);

}
