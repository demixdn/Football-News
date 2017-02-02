package com.github.footballnews.ui.base;

/**
 * Date: 30.01.2017
 * Time: 16:09
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface View<P extends Presenter> {

    void bindPresenter(P presenter);
    P getPresenter();
}
