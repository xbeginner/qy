package com.xph.qyxy.mvp.newsInfo.Presenter;

import android.support.annotation.NonNull;

import com.xph.qyxy.mvp.newsInfo.NewsContract;
import com.xph.qyxy.utils.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xikai on 2016/12/20.
 */

public class NewsPresenter implements NewsContract.Presenter {

    private final NewsContract.View newsView;

    public NewsPresenter(@NonNull NewsContract.View view){
        this.newsView = view;
    }

    private List<String> titles;

    /**
     * 初始化数据
     */


    @Override
    public void onCreate() {

    }

    @Override
    public void attachView(@NonNull BaseView view) {
         
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadData() {
        titles = new ArrayList<String>();
        for(int i=0;i<20;i++){
            titles.add("titles"+i);
        }
        newsView.showData(titles);
    }

    @Override
    public void loadMoreData() {
        for(int i=0;i<20;i++){
            titles.add("more titles"+i);
        }
        newsView.showData(titles);
    }

    @Override
    public void loadNewData() {
        for(int i=0;i<20;i++){
            titles.add("new titles"+i);
        }
        newsView.showData(titles);
    }

    @Override
    public List<String> getData() {
        return titles;
    }
}
