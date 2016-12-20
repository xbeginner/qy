package com.xph.qyxy.newsInfo.Presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.xph.qyxy.newsInfo.NewsContract;

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

    /**
     * 初始化数据
     */
    @Override
    public void start() {
         loadData();
    }

    @Override
    public void loadData() {
        List<String> titles = new ArrayList<String>();
        for(int i=0;i<20;i++){
            titles.add("titles"+i);
        }
        newsView.showData(titles);
    }
}
