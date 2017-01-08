package com.xph.qyxy.di.module;

import android.content.Context;

import com.xph.qyxy.App;
import com.xph.qyxy.di.scope.ContextLife;
import com.xph.qyxy.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * 提供Application的Context的注入
 */
@Module
public final class ApplicationModule {

    private App mApplication;

    public ApplicationModule(App application) {
        mApplication = application;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}