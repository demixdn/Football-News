package com.github.footballnews.ui.newslist.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.github.footballnews.R;
import com.github.footballnews.data.StaticMenu;
import com.github.footballnews.model.MenuItemModel;
import com.github.footballnews.model.mapper.NewsItemMapper;
import com.github.footballnews.ui.newslist.view.NewsListView;
import com.github.rules.interactor.GetFootballNews;
import com.github.rules.models.NewsItem;
import com.google.common.base.Preconditions;

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
    private final Context applicationContext;

    @Nullable
    private NewsListView view;

    public NewsListPresenterImpl(GetFootballNews useCaseGetFootballNews, Context applicationContext) {
        this.useCaseGetFootballNews = useCaseGetFootballNews;
        this.applicationContext = applicationContext;
    }

    @Override
    public void loadNewsList() {
        if (getView() != null) {
            useCaseStart(applicationContext.getString(R.string.last_news), null, null);
        }
    }

    @Override
    public void loadNewsList(MenuItem item) {
        if (getView() != null) {
            MenuItemModel menu = StaticMenu.findByTitle(item.getTitle());
            String subtitle = applicationContext.getString(R.string.last_news);
            String title = menu == null ? subtitle : menu.getName();
            Integer pageId = getId(menu);
            useCaseStart(title, subtitle, pageId);
        }
    }

    private Integer getId(MenuItemModel menu) {
        return menu == null || menu.getCategories() == null || menu.getCategories().isEmpty() ? null : menu.getCategories().get(0).getId();
    }

    private void useCaseStart(String title, String subtitle, Integer pageId) {
        getView().setTitles(title, subtitle);
        useCaseGetFootballNews
                .setPageId(pageId)
                .execute(new NewsItemObserver(getView()));
    }

    @Override
    public void bottomNavigationChange(MenuItem item) {
        // TODO: 31.01.2017 add change status
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
            Preconditions.checkNotNull(view);
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
