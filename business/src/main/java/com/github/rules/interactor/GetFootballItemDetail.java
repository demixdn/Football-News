package com.github.rules.interactor;

import com.github.rules.FootballRepository;
import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;
import com.github.rules.models.NewsItem;
import com.google.common.base.Preconditions;

import io.reactivex.observers.DefaultObserver;

/**
 * Date: 26.01.2017
 * Time: 15:49
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class GetFootballItemDetail {

    private final UIScheduler uiScheduler;
    private final WorkerScheduler workerScheduler;
    private final FootballRepository footballRepository;
    private int itemId;

    public GetFootballItemDetail(UIScheduler uiScheduler, WorkerScheduler workerScheduler, FootballRepository footballRepository) {
        Preconditions.checkNotNull(uiScheduler);
        Preconditions.checkNotNull(workerScheduler);
        Preconditions.checkNotNull(footballRepository);
        this.uiScheduler = uiScheduler;
        this.workerScheduler = workerScheduler;
        this.footballRepository = footballRepository;
    }

    public GetFootballItemDetail setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public void execute(DefaultObserver<NewsItem> newsItemObserver) {
        footballRepository.getNewsDetail(itemId)
                .subscribeOn(workerScheduler.getScheduler())
                .observeOn(uiScheduler.getScheduler())
                .subscribe(newsItemObserver);
    }
}
