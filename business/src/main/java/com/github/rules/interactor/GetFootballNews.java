package com.github.rules.interactor;

import com.github.rules.FootballRepository;
import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;
import com.github.rules.models.NewsItem;

import java.util.List;

import io.reactivex.observers.DefaultObserver;

/**
 * Date: 26.01.2017
 * Time: 15:49
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class GetFootballNews {

    private final UIScheduler uiScheduler;
    private final WorkerScheduler workerScheduler;
    private final FootballRepository footballRepository;
    private Integer pageId;

    public GetFootballNews(UIScheduler uiScheduler, WorkerScheduler workerScheduler, FootballRepository footballRepository) {
        this.uiScheduler = uiScheduler;
        this.workerScheduler = workerScheduler;
        this.footballRepository = footballRepository;
        this.pageId = null;
    }

    public GetFootballNews setPageId(Integer pageId) {
        this.pageId = pageId;
        return this;
    }

    public void execute(DefaultObserver<List<NewsItem>> listNewsObserver) {
        footballRepository.getNews(pageId)
                .subscribeOn(workerScheduler.getScheduler())
                .observeOn(uiScheduler.getScheduler())
                .subscribe(listNewsObserver);
    }
}
