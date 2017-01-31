package com.github.footballnews.ui.newslist.presenter;

import android.view.MenuItem;

import com.github.footballnews.ui.base.Presenter;
import com.github.footballnews.ui.newslist.view.NewsListView;

/**
 * Date: 30.01.2017
 * Time: 15:59
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface NewsListPresenter extends Presenter<NewsListView> {

    void loadNewsList();

    void loadNewsList(MenuItem item);

    void bottomNavigationChange(MenuItem item);

}
