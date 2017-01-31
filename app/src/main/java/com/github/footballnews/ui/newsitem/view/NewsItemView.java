package com.github.footballnews.ui.newsitem.view;

import com.github.footballnews.ui.base.View;
import com.github.footballnews.ui.newsitem.presenter.NewsItemPresenter;
import com.github.rules.models.NewsItem;

/**
 * Date: 31.01.2017
 * Time: 19:35
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface NewsItemView extends View<NewsItemPresenter> {
    void showProgress();

    void hideProgress();

    void showError(String errorMessage);

    void showNewsItem(NewsItem newsItem);
}
