package bwie.com.library.iamgeloader;

import bwie.com.library.iamgeloader.glide.GlideImageLoader;

import static bwie.com.library.iamgeloader.ImageLoaderManger.Type.GLIDE;

/**
 * Created by gaojian on 2016/12/28.
 */

public class ImageLoaderManger {
    private static ImageLoaderManger mLoaderManger;
    private Iimageloader mIimageloader;

    private ImageLoaderManger() {

    }

    public static ImageLoaderManger getInstance() {
        if (mLoaderManger == null) {
            synchronized (ImageLoaderManger.class) {
                if (mLoaderManger == null) {
                    mLoaderManger = new ImageLoaderManger();
                }
            }
        }
        return mLoaderManger;
    }

    public Iimageloader getIimageloader(Type type) {
        if (GLIDE == type) {
            return new GlideImageLoader();
        }
        return new GlideImageLoader();
    }

    public Iimageloader getIimageloader() {
        return getIimageloader(null);
    }

    enum Type {
        GLIDE;
    }
}
