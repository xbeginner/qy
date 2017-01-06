package com.xph.qyxy.mvp.newsInfo;

import com.xph.qyxy.di.module.ApplicationModule;
import com.xph.qyxy.mvp.MainActivity;

import dagger.Component;

/**
 * Created by xikai on 2017/1/4.
 */

@Component(modules = {NewsInfoModule.class, ApplicationModule.class})
public interface NewsInfoComponent {
    void inject(MainActivity mainActivity);
}
