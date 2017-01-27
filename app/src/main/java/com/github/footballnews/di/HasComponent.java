package com.github.footballnews.di;

/**
 * Date: 27.01.2017
 * Time: 19:26
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface HasComponent<C extends Component> {
    C getComponent();
}
