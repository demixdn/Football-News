package com.github.footballnews.ui.newsitem.presenter;

import com.github.footballnews.ui.newsitem.view.NewsItemView;
import com.github.rules.interactor.GetFootballItemDetail;
import com.github.rules.models.NewsItem;

import io.reactivex.observers.DefaultObserver;

/**
 * Date: 31.01.2017
 * Time: 19:38
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsItemPresenterImpl implements NewsItemPresenter {

    private final GetFootballItemDetail getFootballItemDetail;
    private NewsItemView newsItemView;

    public NewsItemPresenterImpl(GetFootballItemDetail getFootballItemDetail) {
        this.getFootballItemDetail = getFootballItemDetail;
    }

    @Override
    public void loadNewsItem(int newsItemId) {
        if (getView() != null) {
            getView().showProgress();
            getFootballItemDetail.setItemId(newsItemId).execute(new DefaultObserver<NewsItem>() {
                @Override
                public void onNext(NewsItem newsItem) {
                    getView().showNewsItem(newsItem);
                }

                @Override
                public void onError(Throwable e) {
                    getView().showError(e.getMessage());
                }

                @Override
                public void onComplete() {
                    getView().hideProgress();
                }
            });
        }
    }

    @Override
    public void bindView(NewsItemView view) {
        this.newsItemView = view;
    }

    @Override
    public void unbindView() {
        this.newsItemView = null;
    }

    @Override
    public NewsItemView getView() {
        return newsItemView;
    }
}
