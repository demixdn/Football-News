package com.github.footballnews.ui.base;

/**
 * Date: 30.01.2017
 * Time: 16:08
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface Presenter<V extends View> {
    void bindView(V view);
    void unbindView();
    V getView();
}
