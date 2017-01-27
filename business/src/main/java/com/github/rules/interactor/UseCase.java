package com.github.rules.interactor;

import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Date: 26.01.2017
 * Time: 12:45
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public abstract class UseCase {
    private final UIScheduler uiScheduler;
    private final WorkerScheduler workerScheduler;

    protected UseCase(UIScheduler uiScheduler, WorkerScheduler workerScheduler) {
        this.uiScheduler = uiScheduler;
        this.workerScheduler = workerScheduler;
    }

    protected abstract Observable buildUseCaseObservable();

    @SuppressWarnings("unchecked")
    public void execute(Observer useCaseObserver){
        this.buildUseCaseObservable()
                .subscribeOn(workerScheduler.getScheduler())
                .observeOn(uiScheduler.getScheduler())
                .subscribe(useCaseObserver);
    }
}