package com.frame.mvp.ui.common;

import com.frame.mvp.app.MVPApplication;
import com.frame.mvp.di.AppComponent;
import com.squareup.leakcanary.RefWatcher;
import com.tool.common.base.BaseActivity;
import com.tool.common.frame.BasePresenter;

/**
 * CommonActivity
 */
public abstract class CommonActivity<P extends BasePresenter> extends BaseActivity<P> {

    // Application
    protected MVPApplication application = null;

    @Override
    protected void componentInject() {
        application = (MVPApplication) getApplication();

        // init presenter
        presenter = setupActivityComponent(application.getAppComponent());
    }

    /**
     * 如使用MVP结构，子类需实现此方法初始化Presenter
     */
    protected <P extends BasePresenter> P setupActivityComponent(AppComponent appComponent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher watcher = MVPApplication.getRefWatcher(this);
        if (watcher != null) {
            watcher.watch(this);
        }
        this.application = null;
    }
}