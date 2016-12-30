package bwie.com.library.mvp;

/**
 * Created by gaojian on 2016/12/28.
 */

public abstract class BasePresenter implements IBasePresenter {
    private IBaseView mBaseView;
    private IBaseModel mIBaseModel;

    @Override
    public void attchView(IBaseView view) {
        mBaseView = view;
    }

    @Override
    public void onStart() {
        mIBaseModel = setModel();
    }

    @Override
    public void onDestroy() {
        mBaseView = null;
    }

    public <T extends IBaseView> T getView() {
        return (T) mBaseView;
    }

    public abstract IBaseModel setModel();
}
