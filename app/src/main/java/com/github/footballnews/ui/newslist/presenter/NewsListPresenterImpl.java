package com.github.footballnews.ui.newslist.presenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.github.footballnews.R;
import com.github.footballnews.data.StaticMenu;
import com.github.footballnews.model.MenuItemModel;
import com.github.footballnews.model.mapper.NewsItemMapper;
import com.github.footballnews.ui.base.BasePresenter;
import com.github.footballnews.ui.newslist.view.NewsListView;
import com.github.rules.interactor.GetFootballNewses;
import com.github.rules.models.NewsItem;
import com.google.common.base.Preconditions;

import java.util.List;

/**
 * Date: 30.01.2017
 * Time: 16:16
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsListPresenterImpl extends BasePresenter<NewsListView> implements NewsListPresenter {

    private final GetFootballNewses useCaseGetFootballNewses;
    private final Context applicationContext;

    public NewsListPresenterImpl(GetFootballNewses useCaseGetFootballNewses, Context applicationContext) {
        this.useCaseGetFootballNewses = useCaseGetFootballNewses;
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
        if (getView() != null)
            getView().setTitles(title, subtitle);
        GetFootballNewses.Params params = pageId == null ? null : GetFootballNewses.Params.forPage(pageId);
        useCaseGetFootballNewses.execute(new NewsItemObserver(getView()), params);
    }

    @Override
    public void bottomNavigationChange(MenuItem item) {
        // TODO: 31.01.2017 add change status
    }

    private final class NewsItemObserver extends com.github.rules.interactor.DefaultObserver<List<NewsItem>> {

        @Nullable
        private final NewsListView view;

        NewsItemObserver(@Nullable NewsListView view) {
            Preconditions.checkNotNull(view);
            this.view = view;
        }

        @Override
        protected void onStart() {
            super.onStart();
            if (view != null)
                view.showProgress();
        }

        @Override
        public void onNext(List<NewsItem> newsItems) {
            if (view != null)
                view.showNewsList(NewsItemMapper.transform(newsItems));
        }

        @Override
        public void onError(Throwable e) {
            if (view != null)
                view.showError(e.getMessage());
        }

        @Override
        public void onComplete() {
            if (view != null)
                view.hideProgress();
        }
    }
}
