package com.github.rules.executor;


import io.reactivex.Scheduler;

/**
 * Date: 26.01.2017
 * Time: 12:38
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@FunctionalInterface
public interface WorkerScheduler {
    Scheduler getScheduler();
}
