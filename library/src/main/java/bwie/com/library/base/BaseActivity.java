package bwie.com.library.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import bwie.com.library.log.Logprint;
import bwie.com.library.mvp.IOnCreate;
import bwie.com.library.utils.AppManager;

/**
 * Created by gaojian on 2016/12/28.
 */

public abstract class BaseActivity extends AppCompatActivity implements IOnCreate {
    private View mView;
    private Logprint mLogprint;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);//添加activity到任务栈中
        if (bindLayout() != 0) {
            mView = View.inflate(this, bindLayout(), null);
            setContentView(mView);
            beforeContentView();
            ButterKnife.bind(this);
            initViews(savedInstanceState);
            initVariables();
            loadData();
            mLogprint = new Logprint();

        } else {
            mLogprint.e("Layout is null");
        }
    }

    public void startAct(Class<? extends BaseActivity> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void startAct(Class<? extends BaseActivity> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 专门针对返回写的
     *
     * @param toolbar
     * @param title
     */
    protected void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * Build.VERSION.SDK_INT进行版本判断
     * Build.VERSION_CODES.KITKAT      4.4版
     * Google从Android kitkat(Android 4.4)开始,给我们开发者提供了一套能透明的系统ui样式给状态栏和导航栏，
     * 这样的话就不用向以前那样每天面对着黑乎乎的上下两条黑栏了，
     * 还可以调成跟Activity一样的样式，形成一个完整的主题,和IOS7.0以上系统一样了。
     */
    @Override
    public void beforeContentView() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 重构findViewById
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().removeActivity(this);
    }
}
