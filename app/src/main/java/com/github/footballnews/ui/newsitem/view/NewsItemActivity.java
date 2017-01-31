package com.github.footballnews.ui.newsitem.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.github.footballnews.App;
import com.github.footballnews.R;
import com.github.footballnews.di.AppComponent;
import com.github.footballnews.di.HasComponent;
import com.github.footballnews.model.NewsItemModel;
import com.github.footballnews.ui.newsitem.presenter.NewsItemPresenter;
import com.github.rules.models.NewsItem;

public class NewsItemActivity extends AppCompatActivity implements HasComponent<AppComponent>, NewsItemView {

    public static final String BUNDLE_ITEM = "item";
    private NewsItemPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getComponent().inject(this);
        NewsItemModel model = (NewsItemModel)getIntent().getSerializableExtra(BUNDLE_ITEM);
        getPresenter().loadNewsItem(model.getId());
    }

    @Override
    public AppComponent getComponent() {
        return App.getAppComponent();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showNewsItem(NewsItem newsItem) {
        Log.i("TAG", "showNewsItem: "+newsItem.toString());
    }

    @Override
    public void bindPresenter(NewsItemPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public NewsItemPresenter getPresenter() {
        return presenter;
    }
}
