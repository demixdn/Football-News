package com.github.rules;

import com.github.rules.models.MenuGroup;
import com.github.rules.models.NewsItem;

import java.util.List;

import io.reactivex.Observable;

/**
 * Date: 25.01.2017
 * Time: 19:41
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface FootballRepository {
    Observable<List<MenuGroup>> getMenu();

    Observable<List<NewsItem>> getNews(Integer pageId);

    Observable<NewsItem> getNewsDetail(int newsId);
}
