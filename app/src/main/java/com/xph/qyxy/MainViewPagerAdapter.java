package com.xph.qyxy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xph.qyxy.newsInfo.NewsContract;
import com.xph.qyxy.newsInfo.Presenter.NewsPresenter;
import com.xph.qyxy.newsInfo.View.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xikai on 2016/12/20.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments = new ArrayList<Fragment>();
    String[] titles = {"沁阳新闻","理财信息","征信知识"};

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);

        NewsFragment fragment = NewsFragment.newInstance("1","2");
        NewsPresenter presenter = new NewsPresenter(fragment);
        fragment.setPresenter(presenter);
        fragments.add(fragment);

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
