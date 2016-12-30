package bwie.com.directseeding.view.act;

import bwie.com.directseeding.R;
import bwie.com.library.mvp.BaseMvpActicity;
import bwie.com.library.mvp.IBasePresenter;
import bwie.com.library.mvp.IBaseView;

public class HomeActivity extends BaseMvpActicity<IBasePresenter> {

    @Override
    protected IBasePresenter createPresenter(IBaseView view) {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void loadData() {

    }
}
