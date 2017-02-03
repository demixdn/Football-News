package com.github.footballnews.ui.newsitem.presenter;

import android.content.Intent;

import com.github.footballnews.model.NewsItemModel;
import com.github.footballnews.model.mapper.NewsItemMapper;
import com.github.footballnews.ui.base.BasePresenter;
import com.github.footballnews.ui.newsitem.view.NewsItemView;
import com.github.rules.interactor.GetFootballItemDetail;
import com.github.rules.models.NewsItem;

import io.reactivex.observers.DefaultObserver;

import static com.github.footballnews.ui.newsitem.view.NewsItemActivity.BUNDLE_ITEM;

/**
 * Date: 31.01.2017
 * Time: 19:38
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsItemPresenterImpl extends BasePresenter<NewsItemView> implements NewsItemPresenter {

    private final GetFootballItemDetail getFootballItemDetail;

    private NewsItemModel itemModel;

    public NewsItemPresenterImpl(GetFootballItemDetail getFootballItemDetail) {
        this.getFootballItemDetail = getFootballItemDetail;
    }

    @Override
    public void setBundle(Intent bundle) {
        itemModel = (NewsItemModel) bundle.getSerializableExtra(BUNDLE_ITEM);
        if (itemModel != null) {
            if (getView() != null) {
                getView().showImage(itemModel.getImageUrl());
                getView().showTitle(itemModel.getTitle());
                loadNewsItem(itemModel.getId());
            }
        } else {
            if (getView() != null)
                getView().showError("Bundle is empty");
        }
    }

    private void loadNewsItem(int newsItemId) {
        if (getView() != null) {
            getView().showProgress();
            getFootballItemDetail.setItemId(newsItemId).execute(new DefaultObserver<NewsItem>() {
                @Override
                public void onNext(NewsItem newsItem) {
                    itemModel = NewsItemMapper.transform(newsItem);
                    if (getView() != null)
                        getView().showArticle(itemModel.getHtmlArticle());
                }

                @Override
                public void onError(Throwable e) {
                    if (getView() != null)
                        getView().showError(e.getMessage());
                }

                @Override
                public void onComplete() {
                    if (getView() != null)
                        getView().hideProgress();
                }
            });
        }
    }
}
