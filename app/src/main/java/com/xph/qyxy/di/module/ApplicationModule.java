package com.xph.qyxy.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * 提供Application的Context的注入
 */
@Module
public final class ApplicationModule {

    private final Context mContext;

    ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}