package com.xph.qyxy.newsInfo;

import com.xph.qyxy.newsInfo.Presenter.NewsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xikai on 2017/1/4.
 * 提供所有需要注入的类
 */

@Module
public class NewsInfoModule {

    private final NewsContract.View mView;

    public NewsInfoModule(NewsContract.View view) {
        mView = view;
    }


  @Provides
  NewsPresenter newsPresenter(){
      return new NewsPresenter(mView);
  }

}
