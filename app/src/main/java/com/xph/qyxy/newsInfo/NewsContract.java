package com.xph.qyxy.newsInfo;

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
    }
}
