package com.github.footballnews.ui.newslist.adapter;

import android.view.View;

import com.github.footballnews.model.NewsItemModel;

/**
 * Date: 31.01.2017
 * Time: 19:49
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface OnNewsItemClickListener {
    void onItemClick(View view, NewsItemModel newsItemModel);
}
