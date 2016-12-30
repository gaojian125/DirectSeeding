package bwie.com.library.iamgeloader;

import android.widget.ImageView;

/**
 * Created by gaojian on 2016/12/28.
 */

public interface Iimageloader {
    void start();

    void pause();

    void destroy();

    boolean isPause();

    void disPlay(String url, ImageView imageView);

    void disPlay(int resId, ImageView imageView);

}
