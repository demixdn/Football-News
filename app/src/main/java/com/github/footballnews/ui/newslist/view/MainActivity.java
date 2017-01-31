package com.github.footballnews.ui.newslist.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.github.footballnews.App;
import com.github.footballnews.R;
import com.github.footballnews.di.AppComponent;
import com.github.footballnews.di.HasComponent;
import com.github.footballnews.model.NewsItemModel;
import com.github.footballnews.ui.newsitem.view.NewsItemActivity;
import com.github.footballnews.ui.newslist.adapter.NewsListAdapter;
import com.github.footballnews.ui.newslist.adapter.OnNewsItemClickListener;
import com.github.footballnews.ui.newslist.presenter.NewsListPresenter;
import com.github.footballnews.ui.widget.LoadingDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        HasComponent<AppComponent>,
        NewsListView, OnNewsItemClickListener {

    @BindView(R.id.rvNewsList)
    RecyclerView recyclerNewsList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private NewsListPresenter presenter;

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();

        getComponent().inject(this);
        getPresenter().loadNewsList();
    }

    private void initUI() {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = ButterKnife.findById(this, R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = ButterKnife.findById(this, R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = ButterKnife.findById(this, R.id.navigationBottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::changeStatus);

        loadingDialog = new LoadingDialog(this);
    }

    private boolean changeStatus(MenuItem item) {
        getPresenter().bottomNavigationChange(item);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        getPresenter().loadNewsList(item);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public AppComponent getComponent() {
        return App.getAppComponent();
    }

    @Override
    public void showProgress() {
        loadingDialog.setStatus(true);
    }

    @Override
    public void hideProgress() {
        loadingDialog.setStatus(false);
    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showNewsList(List<NewsItemModel> newsItemModelList) {
        recyclerNewsList.setAdapter(new NewsListAdapter(newsItemModelList, this));
        recyclerNewsList.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
    }

    @Override
    public void setTitles(@NonNull String title, @Nullable String subTitle) {
        Log.i("TAG", "setTitles: " + title + "; " + subTitle);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setSubtitle(subTitle);
    }

    @Override
    public void bindPresenter(NewsListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public NewsListPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onItemClick(View view, NewsItemModel newsItemModel) {
        Log.i("TAG", "onItemClick: " + newsItemModel);
        NewsItemActivity.navigate(this, ButterKnife.findById(view, R.id.newsItemImage), newsItemModel);
    }
}
