package bwie.com.directseeding.view.act;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import bwie.com.directseeding.R;
import bwie.com.library.base.BaseActivity;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class WelcomActivity extends BaseActivity {
    boolean isClose = true;

    @Override
    public int bindLayout() {
        return R.layout.activity_welcom;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        if (isClose)
                            finish();
                    }
                });
    }

    @Override
    public void loadData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isClose = false;
    }
}
