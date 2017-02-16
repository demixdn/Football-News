package com.github.rules.interactor;

import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;
import com.github.rules.models.NewsItem;
import com.github.rules.repository.NewsRepository;
import com.google.common.base.Preconditions;

import java.util.List;

import io.reactivex.Observable;

/**
 * Date: 26.01.2017
 * Time: 15:49
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class GetFootballNewses extends UseCase<List<NewsItem>, GetFootballNewses.Params> {

    private final NewsRepository newsRepository;

    public GetFootballNewses(UIScheduler uiScheduler, WorkerScheduler workerScheduler, NewsRepository newsRepository) {
        super(uiScheduler, workerScheduler);
        Preconditions.checkNotNull(newsRepository);
        this.newsRepository = newsRepository;
    }

    @Override
    Observable<List<NewsItem>> buildUseCaseObservable(Params params) {
        if (params == null)
            return this.newsRepository.getNews(null);
        else
            return this.newsRepository.getNews(params.pageId);
    }

    public static final class Params {
        private final int pageId;

        private Params(int pageId) {
            this.pageId = pageId;
        }

        public static Params forPage(int pageId) {
            return new Params(pageId);
        }
    }
}
