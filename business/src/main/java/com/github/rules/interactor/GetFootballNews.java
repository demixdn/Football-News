package com.github.rules.interactor;

import com.github.rules.FootballRepository;
import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;

import io.reactivex.Observable;

/**
 * Date: 26.01.2017
 * Time: 15:49
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class GetFootballNews extends UseCase {

    private Integer pageId;
    private final FootballRepository footballRepository;

    public GetFootballNews(UIScheduler uiScheduler, WorkerScheduler workerScheduler, FootballRepository footballRepository) {
        super(uiScheduler, workerScheduler);
        this.pageId = null;
        this.footballRepository = footballRepository;
    }

    public GetFootballNews setPageId(Integer pageId) {
        this.pageId = pageId;
        return this;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return footballRepository.getNews(pageId);
    }
}
