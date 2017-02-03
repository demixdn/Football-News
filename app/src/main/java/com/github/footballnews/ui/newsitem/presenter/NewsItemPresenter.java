package com.github.footballnews.ui.newsitem.presenter;

import android.content.Intent;

import com.github.footballnews.ui.base.Presenter;
import com.github.footballnews.ui.newsitem.view.NewsItemView;

/**
 * Date: 31.01.2017
 * Time: 19:34
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface NewsItemPresenter extends Presenter<NewsItemView>{
    void setBundle(Intent bundle);
}
