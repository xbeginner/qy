/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.xph.qyxy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatDelegate;


import com.socks.library.KLog;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.xph.qyxy.common.Constants;
import com.xph.qyxy.di.component.ApplicationComponent;
import com.xph.qyxy.di.module.ApplicationModule;
import com.xph.qyxy.utils.MyUtils;


/**
 * 作用
 * 1.监控内存泄露
 */
public class App extends Application {

    private ApplicationComponent mApplicationComponent;
    private RefWatcher refWatcher;

    //在onDestroy方法中可以进行调用
    public static RefWatcher getRefWatcher(Context context) {
        App application = (App) context.getApplicationContext();
        return application.refWatcher;
    }

    //定义一个Application的Context
    private static Context sAppContext;
    //初始化一个Dao
    //private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
        //初始化内存监控组件
        initLeakCanary();
        //初始化网络、IO和内存监测
        initStrictMode();
        //初始化日夜模式
        initDayNightMode();
        //设为DEBUG
        KLog.init(true);
        //
        setupDatabase();
        initApplicationComponent();

    }

    private void initLeakCanary() {
        if (BuildConfig.DEBUG) {
            refWatcher = LeakCanary.install(this);
        } else {
            refWatcher = installLeakCanary();
        }
    }

    /**
     * release版本使用此方法
     * 不再进行提示
     */
    protected RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
    }



    private void initStrictMode() {
        //如果是调试模式,对策略违例进行检测
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder()
                            .detectAll()
//                            .penaltyDialog() // 弹出违规提示对话框
                            .penaltyLog() // 在logcat中打印违规异常信息
                            .build());
            StrictMode.setVmPolicy(
                    new StrictMode.VmPolicy.Builder()
                            .detectAll()
                            .penaltyLog()
                            .build());
        }
    }

    private void initDayNightMode() {
        if (MyUtils.isNightMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void setupDatabase() {
        //使用GreentDao

    }

    public static Context getAppContext() {
        return sAppContext;
    }

    // Fixme
    private void initApplicationComponent() {
        //对
//        mApplicationComponent = DaggerApplicationComponent.builder()
//                .applicationModule(new ApplicationModule(this))
//                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }


    public static boolean isHavePhoto() {
        return MyUtils.getSharedPreferences().getBoolean(Constants.SHOW_NEWS_PHOTO, true);
    }

}
