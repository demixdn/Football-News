package com.github.footballnews.di;

import com.github.footballnews.ui.newsitem.view.NewsItemView;
import com.github.footballnews.ui.newslist.view.NewsListView;

/**
 * Date: 27.01.2017
 * Time: 17:42
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface AppComponent {
    void inject(NewsListView newsListView);
    void inject(NewsItemView newsItemView);
}
