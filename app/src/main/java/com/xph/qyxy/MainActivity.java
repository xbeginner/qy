package com.xph.qyxy;

import android.net.Uri;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.xph.qyxy.newsInfo.DaggerNewsInfoComponent;
import com.xph.qyxy.newsInfo.Presenter.NewsPresenter;
import com.xph.qyxy.newsInfo.View.NewsFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NewsFragment.OnFragmentInteractionListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.news_activity_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.news_activity_viewpager)
    ViewPager viewPager;

    @Inject
    NewsPresenter newsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定ButterKnife
        ButterKnife.bind(this);

        initStatusBar();
        initView();

        //注入Dagger
        DaggerNewsInfoComponent.builder()
                .newsInfoModule()

    }


    /**
     * 初始化对应的View
     */
    private void initView(){
        //设计toolbar
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        //设置DrawerLayout
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimary);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        //初始化navigationView
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        //初始化ViewPager和TabLayout
        //设置尽可能填充,GRAVITY_FILL和MODE_FIXED合起来才有效果
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //固定Tab,同时显示所有Tabs
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        //设置ViewPager
        FragmentManager manager = getSupportFragmentManager();
        MainViewPagerAdapter viewPagerAdapter = new MainViewPagerAdapter(manager,newsPresenter);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);



    }

    /**
     * 设置状态栏颜色和Toolbar一致,但是需要5.0及以上
     */
    private void initStatusBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
    }


    /**
     *  监听侧边栏点击事件
     */

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_myInfo_item:

                                break;
                            case R.id.navigation_setting_item:

                                break;
                            default:
                                break;
                        }
                        // Close the navigation drawer when an item is selected.
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


    /**
     * 点击系统菜单事件
      * @param item
     * @return
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
