package com.github.footballdata.repository;

import android.support.annotation.NonNull;

import com.github.footballdata.mappers.MenuMapper;
import com.github.footballdata.mappers.NewsItemMapper;
import com.github.footballdata.net.RestAPI;
import com.github.rules.FootballRepository;
import com.github.rules.models.MenuGroup;
import com.github.rules.models.NewsItem;
import com.google.common.base.Preconditions;

import java.util.List;

import io.reactivex.Observable;

/**
 * Date: 26.01.2017
 * Time: 12:16
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class FootballRepositoryImpl implements FootballRepository {

    private static final String ERROR_MESSAGE = "Object can not be null";
    private final MenuMapper menuMapper;
    private final NewsItemMapper newsItemMapper;
    private final RestAPI restAPI;

    public FootballRepositoryImpl(@NonNull MenuMapper menuMapper, @NonNull NewsItemMapper newsItemMapper, @NonNull RestAPI restAPI) {
        Preconditions.checkNotNull(menuMapper, ERROR_MESSAGE);
        Preconditions.checkNotNull(newsItemMapper, ERROR_MESSAGE);
        Preconditions.checkNotNull(restAPI, ERROR_MESSAGE);
        this.menuMapper = menuMapper;
        this.newsItemMapper = newsItemMapper;
        this.restAPI = restAPI;
    }

    @Override
    public Observable<List<MenuGroup>> getMenu() {
        return restAPI.getMenu().map(menuMapper::transform);
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
