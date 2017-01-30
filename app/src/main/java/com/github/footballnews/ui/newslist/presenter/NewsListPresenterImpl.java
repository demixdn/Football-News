package com.github.footballnews.ui.newslist.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.footballnews.model.NewsItemMapper;
import com.github.footballnews.ui.newslist.view.NewsListView;
import com.github.rules.interactor.GetFootballNews;
import com.github.rules.models.NewsItem;

import java.util.List;

import io.reactivex.observers.DefaultObserver;

/**
 * Date: 30.01.2017
 * Time: 16:16
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsListPresenterImpl implements NewsListPresenter {

    private final GetFootballNews useCaseGetFootballNews;

    @Nullable
    private NewsListView view;

    public NewsListPresenterImpl(GetFootballNews useCaseGetFootballNews) {
        this.useCaseGetFootballNews = useCaseGetFootballNews;
    }

    @Override
    public void loadNewsList() {
        if (getView() != null)
            useCaseGetFootballNews
                    .setPageId(null)
                    .execute(new NewsItemObserver(getView()));
    }

    @Override
    public void bindView(NewsListView view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Nullable
    @Override
    public NewsListView getView() {
        return view;
    }

    private final class NewsItemObserver extends DefaultObserver<List<NewsItem>> {

        @NonNull
        private final NewsListView view;

        public NewsItemObserver(@NonNull NewsListView view) {
            this.view = view;
        }

        @Override
        protected void onStart() {
            super.onStart();
            view.showProgress();
        }

        @Override
        public void onNext(List<NewsItem> newsItems) {
            view.showNewsList(NewsItemMapper.transform(newsItems));
        }

        @Override
        public void onError(Throwable e) {
            view.showError(e.getMessage());
        }

        @Override
        public void onComplete() {
            view.hideProgress();
        }
    }
}
