package com.github.footballnews.executors;

import com.github.rules.executor.WorkerScheduler;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Date: 27.01.2017
 * Time: 19:06
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class AndroidWorkerScheduler implements WorkerScheduler {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
