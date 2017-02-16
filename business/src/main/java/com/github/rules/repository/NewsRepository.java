package com.github.rules.repository;

import com.github.rules.models.NewsItem;

import java.util.List;

import io.reactivex.Observable;

/**
 * Date: 15.02.2017
 * Time: 16:16
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface NewsRepository {
    Observable<List<NewsItem>> getNews(Integer pageId);

    Observable<NewsItem> getNewsDetail(int newsId);
}
