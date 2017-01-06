package com.xph.qyxy.mvp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xph.qyxy.utils.BasePresenter;
import com.xph.qyxy.utils.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xikai on 2016/12/20.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments = new ArrayList<Fragment>();
    String[] titles = {"沁阳新闻","理财信息","征信知识"};

    public MainViewPagerAdapter(FragmentManager fm
        ,List<BasePresenter> presentList
        ,List<BaseView> fragmentList) {
        super(fm);
        for(int i=0;i<fragmentList.size();i++){
            fragmentList.get(i).setPresenter(presentList.get(i));
            fragments.add((Fragment) fragmentList.get(i));
        }
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
