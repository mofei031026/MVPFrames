package com.frame.mvp.mvp.main;

import android.os.Bundle;

import com.frame.mvp.R;
import com.frame.mvp.ui.adapter.MainViewPagerAdapter;
import com.logg.Logg;
import com.tool.common.base.simple.base.BaseSimpleActivity;
import com.tool.common.frame.simple.ISimpleView;
import com.tool.common.frame.simple.Message;
import com.tool.common.widget.navigation.BottomNavigation;
import com.tool.common.widget.navigation.BottomNavigationAdapter;
import com.tool.common.widget.navigation.BottomNavigationViewPager;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;

/**
 * 主页面
 */
public class MainActivity extends BaseSimpleActivity<MainPresenter> implements ISimpleView {

    // UI
    @BindView(R.id.view_pager)
    BottomNavigationViewPager viewPager;
    @BindView(R.id.bottom_navigation)
    BottomNavigation bottomNavigation;

    // Adapter
    private MainViewPagerAdapter adapter;

    @Override
    public void create(Bundle savedInstanceState) {

        // 隐藏导航栏Items
        BottomNavigationAdapter navigationAdapter = new BottomNavigationAdapter(this, R.menu.menu_bottom_navigation);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation);

        // 隐藏导航栏标题
        bottomNavigation.setTitleState(BottomNavigation.TitleState.ALWAYS_HIDE);

        // 导航点击事件
        bottomNavigation.setOnTabSelectedListener(new BottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                viewPager.setCurrentItem(position, false);

                return true;
            }
        });

        viewPager.setOffscreenPageLimit(3);
        adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        Logg.e(getFilesDir()+"/aaaaaaaaaaaaaaaaaa");
 Logg.e(getCacheDir()+"");
        try {
            new File(getFilesDir()+"/aaaaaaaaaaaaaaaaaa").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void handleMessage(Message message) {

    }

    @Override
    public MainPresenter obtainPresenter() {
        return new MainPresenter(component);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}