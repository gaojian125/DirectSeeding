package bwie.com.library.mvp;

/**
 * Created by gaojian on 2016/12/28.
 */

public interface IBaseView {
    /**
     * 打开等待界面
     */
    void showLoading();

    /**
     * 关闭等待界面
     */
    void hideLoading();

}
