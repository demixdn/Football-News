package com.github.footballnews.ui.newslist.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.footballnews.model.NewsItemModel;
import com.github.footballnews.ui.base.View;
import com.github.footballnews.ui.newslist.presenter.NewsListPresenter;

import java.util.List;

/**
 * Date: 30.01.2017
 * Time: 15:59
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface NewsListView extends View<NewsListPresenter> {

    void showProgress();

    void hideProgress();

    void showError(String errorMessage);

    void showNewsList(List<NewsItemModel> newsItemModelList);

    void setTitles(@NonNull String title, @Nullable String subTitle);
}
