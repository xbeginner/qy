package com.xph.qyxy.newsInfo;

import com.xph.qyxy.newsInfo.Presenter.NewsPresenter;
import com.xph.qyxy.newsInfo.View.NewsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xikai on 2017/1/4.
 * 提供所有需要注入的类
 */

@Module
public class NewsInfoModule {

    NewsContract.View mView;

    public NewsInfoModule(NewsContract.View mView){
        this.mView = mView;
    }

    @Provides
    NewsPresenter newsPresenter(){
      return new NewsPresenter(mView);
    }



}
