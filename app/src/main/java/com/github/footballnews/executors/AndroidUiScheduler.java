package com.github.footballnews.executors;

import com.github.rules.executor.UIScheduler;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Date: 27.01.2017
 * Time: 19:04
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class AndroidUiScheduler implements UIScheduler {
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
