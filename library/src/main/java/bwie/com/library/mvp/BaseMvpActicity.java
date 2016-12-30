package bwie.com.library.mvp;

import android.app.Dialog;
import android.os.Bundle;

import bwie.com.library.base.BaseActivity;

/**
 * Created by gaojian on 2016/12/28.
 */

public abstract class BaseMvpActicity<P extends IBasePresenter> extends BaseActivity
        implements IBaseView {

    private Dialog mLoadingDialog;
    private P mPresenter;

    protected abstract P createPresenter(IBaseView view);

    @Override
    public void initViews(Bundle savedInstanceState) {
        mPresenter = createPresenter(this);
        mLoadingDialog = getLoadingDialog();
        if (mPresenter == null) {
            throw new RuntimeException("presenter muse be in createPresenter");
        }
    }

    public P getPresenter() {
        return mPresenter;
    }

    protected Dialog getLoadingDialog() {
        return new Dialog(this);
    }

    @Override
    public void showLoading() {
        if (mLoadingDialog != null && !mLoadingDialog.isShowing())
            mLoadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing())
            mLoadingDialog.dismiss();
    }


}
