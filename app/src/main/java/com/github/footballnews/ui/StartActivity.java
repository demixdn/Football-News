package com.github.footballnews.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.footballnews.App;
import com.github.footballnews.R;
import com.github.footballnews.di.AppComponent;
import com.github.footballnews.di.HasComponent;
import com.github.footballnews.model.NewsItemModel;
import com.github.footballnews.ui.newslist.adapter.NewsListAdapter;
import com.github.footballnews.ui.newslist.presenter.NewsListPresenter;
import com.github.footballnews.ui.newslist.view.NewsListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity implements HasComponent<AppComponent>, NewsListView {


    private static final String TAG = "StartActivity";

    @BindView(R.id.rvNewsList)
    RecyclerView recyclerNewsList;

    private NewsListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        getComponent().inject(this);
        getPresenter().loadNewsList();
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
    public void showNewsList(List<NewsItemModel> newsItemModelList) {
        recyclerNewsList.setAdapter(new NewsListAdapter(newsItemModelList));
        recyclerNewsList.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
    }

    @Override
    public void bindPresenter(NewsListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public NewsListPresenter getPresenter() {
        return presenter;
    }
}
