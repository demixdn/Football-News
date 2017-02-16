package com.github.rules.interactor;

import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;
import com.google.common.base.Preconditions;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Date: 26.01.2017
 * Time: 12:45
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public abstract class UseCase<T, Params> {
    private final UIScheduler uiScheduler;
    private final WorkerScheduler workerScheduler;
    private final CompositeDisposable disposables;

    UseCase(UIScheduler uiScheduler, WorkerScheduler workerScheduler) {
        Preconditions.checkNotNull(uiScheduler);
        Preconditions.checkNotNull(workerScheduler);
        this.uiScheduler = uiScheduler;
        this.workerScheduler = workerScheduler;
        this.disposables = new CompositeDisposable();
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    abstract Observable<T> buildUseCaseObservable(Params params);

    /**
     * Executes the current use case.
     *
     * @param observer {@link DisposableObserver} which will be listening to the observable build
     *                 by {@link #buildUseCaseObservable(Params)} ()} method.
     * @param params   Parameters (Optional) used to build/execute this use case.
     */
    public void execute(DisposableObserver<T> observer, Params params) {
        Preconditions.checkNotNull(observer);
        final Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(workerScheduler.getScheduler())
                .observeOn(uiScheduler.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }
}