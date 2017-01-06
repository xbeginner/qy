package com.xph.qyxy.mvp.newsInfo;

import com.xph.qyxy.utils.BasePresenter;
import com.xph.qyxy.utils.BaseView;

import java.util.List;

/**
 * Created by xikai on 2016/12/20.
 */

public interface NewsContract {

    interface View extends BaseView<Presenter> {
        void  showData(List<String> titles);
    }

    interface Presenter extends BasePresenter {
        void loadData();

        //上拉刷新
        void loadMoreData();

        //下拉加载更多
        void loadNewData();

        List<String> getData();
    }
}
