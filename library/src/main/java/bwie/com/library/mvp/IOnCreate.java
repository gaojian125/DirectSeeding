package bwie.com.library.mvp;

import android.os.Bundle;

/**
 * 类描述：重载onCreate方法的接口,包括activity、fragment
 * Created by gaojian on 2016/12/29.
 */

public interface IOnCreate {
    /**
     * setContentView方法调用前的一些设置
     */
    void beforeContentView();

    /**
     * 返回layout的布局文件ID
     */
    int bindLayout();

    /**
     * 初始化变量，包括Intent带的数据和Activity内的变量
     */
    void initVariables();

    /**
     * 初始化控件，为控件挂上事件方法
     */
    void initViews(Bundle savedInstanceState);

    /**
     * 调用MobileAPI获取初始化数据 by onResume()
     */
    void loadData();
}
