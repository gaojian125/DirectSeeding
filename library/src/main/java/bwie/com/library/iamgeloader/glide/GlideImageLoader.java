package bwie.com.library.iamgeloader.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import bwie.com.library.iamgeloader.Iimageloader;

/**
 * Created by gaojian on 2016/12/28.
 */

public class GlideImageLoader implements Iimageloader {

    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public boolean isPause() {
        return false;
    }

    @Override
    public void disPlay(String url, ImageView imageView) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @Override
    public void disPlay(int resId, ImageView imageView) {
        Glide.with(imageView.getContext()).load(resId).into(imageView);
    }
}
