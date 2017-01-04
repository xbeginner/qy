package com.xph.qyxy.newsInfo;

import com.xph.qyxy.ApplicationModule;
import com.xph.qyxy.MainActivity;
import com.xph.qyxy.newsInfo.Model.Entity.NewsInfo;

import dagger.Component;
import dagger.Module;

/**
 * Created by xikai on 2017/1/4.
 */

@Component(modules = {NewsInfoModule.class, ApplicationModule.class})
public interface NewsInfoComponent {
    void inject(MainActivity mainActivity);
}
