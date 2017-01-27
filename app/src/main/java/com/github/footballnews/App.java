package com.github.footballnews;

import android.app.Application;

import com.github.footballnews.di.AppComponent;
import com.github.footballnews.di.AppModule;
import static com.github.footballdata.BuildConfig.ENDPOINT;

/**
 * Date: 27.01.2017
 * Time: 17:27
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = new AppModule(this, ENDPOINT);
    }
}
