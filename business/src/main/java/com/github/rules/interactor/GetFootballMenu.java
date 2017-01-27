package com.github.rules.interactor;

import com.github.rules.FootballRepository;
import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;

import io.reactivex.Observable;

/**
 * Date: 26.01.2017
 * Time: 17:12
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class GetFootballMenu extends UseCase {

    private final FootballRepository footballRepository;

    public GetFootballMenu(UIScheduler uiScheduler, WorkerScheduler workerScheduler, FootballRepository footballRepository) {
        super(uiScheduler, workerScheduler);
        this.footballRepository = footballRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return footballRepository.getMenu();
    }
}
