package com.zlx.sharelive.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.p2m.core.P2M;
import com.p2m.module.api.Home;
import com.p2m.module.api.Mine;
import com.p2m.module.api.Project;
import com.p2m.module.api.Publics;
import com.p2m.module.api.Square;
import com.zlx.module_base.base_ac.BaseAc;

import com.zlx.sharelive.R;
import com.zlx.sharelive.adapter.VpAdapterMain;
import com.zlx.sharelive.impl.TabPagerListener;
import com.zlx.widget.bubblenavigation.BubbleNavigationConstraintView;
import com.zlx.widget.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.zlx.widget.viewpager.NoScrollViewPager;


import butterknife.BindView;

public class MainActivity extends BaseAc implements BubbleNavigationChangeListener, TabPagerListener {


    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;
    @BindView(R.id.bottom_navigation_view_linear)
    BubbleNavigationConstraintView bubbleNavigationLinearView;


    @Override
    protected int getLayoutId() {
        return R.layout.ac_main;
    }

    @Override
    protected boolean canSwipeBack() {
        return false;
    }

    @Override
    public void initViews() {
        initTab();

        initNav();

        requestPermissions(
                "android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.READ_EXTERNAL_STORAGE"
        );

    }


    private void initNav() {

        bubbleNavigationLinearView.setTypeface(Typeface.createFromAsset(getAssets(), "rubik.ttf"));

        bubbleNavigationLinearView.setBadgeValue(0, null);
        bubbleNavigationLinearView.setBadgeValue(1, null); //invisible badge
        bubbleNavigationLinearView.setBadgeValue(2, null);
        bubbleNavigationLinearView.setBadgeValue(3, null);
        bubbleNavigationLinearView.setBadgeValue(4, null); //empty badge
        bubbleNavigationLinearView.setNavigationChangeListener(this);
    }

    private void initTab() {
        VpAdapterMain adapterMain = new VpAdapterMain(getSupportFragmentManager());
        adapterMain.setListener(this);
        viewPager.setOffscreenPageLimit(5);
        viewPager.setScrollable(false);
        viewPager.setAdapter(adapterMain);
    }


    @Override
    public void onNavigationChanged(View view, int position) {
        viewPager.setCurrentItem(position, false);
    }

    //用户按返回按钮不关闭页面，而是返回到系统桌面。相当于按home键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public Fragment getFragment(int position) {
        if (position == 0) {
            return P2M.moduleOf(Home.class).getLauncher().newFragmentForHomeFg();
        } else if (position == 1) {
            return P2M.moduleOf(Project.class).getLauncher().newFragmentForProjectFg();
        } else if (position == 2) {
            return P2M.moduleOf(Square.class).getLauncher().newFragmentForSquareFg();
        } else if (position == 3) {
            return P2M.moduleOf(Publics.class).getLauncher().newFragmentForPublicFg();
        } else if (position == 4) {
            return P2M.moduleOf(Mine.class).getLauncher().newFragmentForMineFg();
        }
        return null;
    }

    @Override
    public int count() {
        return 5;
    }
}
