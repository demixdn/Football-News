package com.github.footballnews.di;

import android.content.Context;

import com.github.footballdata.DataConst;
import com.github.footballdata.mappers.MenuMapper;
import com.github.footballdata.mappers.NewsItemMapper;
import com.github.footballdata.net.RestAPI;
import com.github.footballdata.net.RestModule;
import com.github.footballdata.repository.FootballRepositoryImpl;
import com.github.footballdata.repository.NewsRepositoryImpl;
import com.github.footballnews.BuildConfig;
import com.github.footballnews.executors.AndroidUiScheduler;
import com.github.footballnews.executors.AndroidWorkerScheduler;
import com.github.footballnews.ui.newsitem.presenter.NewsItemPresenter;
import com.github.footballnews.ui.newsitem.presenter.NewsItemPresenterImpl;
import com.github.footballnews.ui.newsitem.view.NewsItemView;
import com.github.footballnews.ui.newslist.presenter.NewsListPresenter;
import com.github.footballnews.ui.newslist.presenter.NewsListPresenterImpl;
import com.github.footballnews.ui.newslist.view.NewsListView;
import com.github.rules.FootballRepository;
import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;
import com.github.rules.interactor.GetFootballItemDetail;
import com.github.rules.interactor.GetFootballNewses;
import com.github.rules.repository.NewsRepository;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Date: 27.01.2017
 * Time: 17:48
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
public class AppModule implements AppComponent {

    private final Context applicationContext;
    private final String baseUrl;
    private UIScheduler uiScheduler;
    private OkHttpClient okHttpClient;
    private FootballRepository footballRepository;
    private NewsRepository newsRepository;
    private MenuMapper menuMapper;
    private NewsItemMapper newsItemMapper;
    private NewsListPresenter newsListPresenter;
    private NewsItemPresenter newsItemPresenter;
    private AndroidWorkerScheduler androidWorkerScheduler;
    private GetFootballNewses getFootballNewses;
    private GetFootballItemDetail getFootballItemDetail;
    private RestAPI restApi;


    public AppModule(Context applicationContext, String baseUrl) {
        this.applicationContext = applicationContext;
        this.baseUrl = baseUrl;
    }

    private UIScheduler getUiScheduler() {
        if (uiScheduler == null)
            uiScheduler = new AndroidUiScheduler();
        return uiScheduler;
    }

    private WorkerScheduler getWorkerScheduler() {
        if (androidWorkerScheduler == null)
            androidWorkerScheduler = new AndroidWorkerScheduler();
        return androidWorkerScheduler;
    }

    private GetFootballNewses getFootballNews() {
        if (getFootballNewses == null)
            getFootballNewses = new GetFootballNewses(getUiScheduler(), getWorkerScheduler(), getNewsRepository());
        return getFootballNewses;
    }

    private String getBaseUrl() {
        return baseUrl;
    }

    private OkHttpClient getOkHttpClient() {
        if (okHttpClient == null)
            okHttpClient = createOkHttp();
        return okHttpClient;
    }

    private OkHttpClient createOkHttp() {
        OkHttpClient.Builder httpClientBuilder;
        httpClientBuilder = new OkHttpClient.Builder()
                .readTimeout(DataConst.Params.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DataConst.Params.DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(DataConst.Params.LOG_LEVEL);
            httpClientBuilder.addInterceptor(logging);
        }
        return httpClientBuilder.build();
    }

    private RestAPI getRestAPI() {
        if (restApi == null)
            restApi = new RestModule(getBaseUrl(), getOkHttpClient()).getRestApi();
        return restApi;
    }

    private NewsRepository getNewsRepository() {
        if(newsRepository == null)
            newsRepository = new NewsRepositoryImpl(getNewsItemMapper(), getRestAPI());
        return newsRepository;
    }

    private FootballRepository getFootballRepository() {
        if (footballRepository == null)
            footballRepository = new FootballRepositoryImpl(getMenuMapper(), getNewsItemMapper(), getRestAPI());
        return footballRepository;
    }

    private GetFootballItemDetail getGetFootballItemDetail() {
        if(getFootballItemDetail == null)
            getFootballItemDetail = new GetFootballItemDetail(getUiScheduler(), getWorkerScheduler(), getNewsRepository());
        return getFootballItemDetail;
    }

    private MenuMapper getMenuMapper() {
        if (menuMapper == null)
            menuMapper = new MenuMapper();
        return menuMapper;
    }

    private NewsItemMapper getNewsItemMapper() {
        if (newsItemMapper == null)
            newsItemMapper = new NewsItemMapper();
        return newsItemMapper;
    }

    private NewsListPresenter getNewsListPresenter() {
        if (newsListPresenter == null)
            newsListPresenter = new NewsListPresenterImpl(getFootballNews(), applicationContext);
        return newsListPresenter;
    }

    private NewsItemPresenter getNewsItemPresenter() {
        if (newsItemPresenter == null)
            newsItemPresenter = new NewsItemPresenterImpl(getGetFootballItemDetail());
        return newsItemPresenter;
    }

    @Override
    public void inject(NewsListView newsListView) {
        newsListView.bindPresenter(getNewsListPresenter());
        newsListView.getPresenter().bindView(newsListView);
    }

    @Override
    public void inject(NewsItemView newsItemView) {
        newsItemView.bindPresenter(getNewsItemPresenter());
        newsItemView.getPresenter().bindView(newsItemView);
    }
}
