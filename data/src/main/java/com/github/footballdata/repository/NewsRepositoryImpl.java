package com.github.footballdata.repository;

import android.support.annotation.NonNull;

import com.github.footballdata.mappers.NewsItemMapper;
import com.github.footballdata.net.RestAPI;
import com.github.rules.models.NewsItem;
import com.github.rules.repository.NewsRepository;
import com.google.common.base.Preconditions;

import java.util.List;

import io.reactivex.Observable;

/**
 * Date: 15.02.2017
 * Time: 16:34
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsRepositoryImpl implements NewsRepository {

    private static final String ERROR_MESSAGE = "Object can not be null";
    private final NewsItemMapper newsItemMapper;
    private final RestAPI restAPI;

    public NewsRepositoryImpl(@NonNull NewsItemMapper newsItemMapper, @NonNull RestAPI restAPI) {
        Preconditions.checkNotNull(newsItemMapper, ERROR_MESSAGE);
        Preconditions.checkNotNull(restAPI, ERROR_MESSAGE);
        this.newsItemMapper = newsItemMapper;
        this.restAPI = restAPI;
    }

    @Override
    public Observable<List<NewsItem>> getNews(Integer pageId) {
        return restAPI.getNews(pageId).map(newsItemMapper::transformList);
    }

    @Override
    public Observable<NewsItem> getNewsDetail(int newsId) {
        return restAPI.getNewsDetail(newsId).map(rss -> newsItemMapper.transformDetail(rss, newsId));
    }
}
