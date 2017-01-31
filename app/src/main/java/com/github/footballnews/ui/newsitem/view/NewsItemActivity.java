package com.github.footballnews.ui.newsitem.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.transition.Slide;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.github.footballnews.App;
import com.github.footballnews.R;
import com.github.footballnews.di.AppComponent;
import com.github.footballnews.di.HasComponent;
import com.github.footballnews.model.NewsItemModel;
import com.github.footballnews.ui.newsitem.presenter.NewsItemPresenter;
import com.github.rules.models.NewsItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsItemActivity extends AppCompatActivity implements HasComponent<AppComponent>, NewsItemView {

    public static final String BUNDLE_ITEM = "item";
    public static final String EXTRA_IMAGE = "detailImage";

    @BindView(R.id.ivNewsItemDetailImage)
    ImageView newsImage;
    @BindView(R.id.toolbarNewsItemDetail)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingLayout;
    @BindView(R.id.tvNewsDetailTitle)
    TextView tvNewsDetailTitle;
    @BindView(R.id.tvNewsDetailArticle)
    TextView tvNewsDetailArticle;

    private NewsItemPresenter presenter;


    public static void navigate(AppCompatActivity activity, View transitionImage, NewsItemModel viewModel) {
        Intent intent = new Intent(activity, NewsItemActivity.class);
        intent.putExtra(BUNDLE_ITEM, viewModel);

        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity, transitionImage, EXTRA_IMAGE);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityTransitions();
        setContentView(R.layout.activity_news_item);

        ViewCompat.setTransitionName(findViewById(R.id.app_bar), EXTRA_IMAGE);
        supportPostponeEnterTransition();

        ButterKnife.bind(this);
        initToolbar();
        getComponent().inject(this);
        initModel();
    }

    private void initModel() {
        NewsItemModel model = (NewsItemModel) getIntent().getSerializableExtra(BUNDLE_ITEM);
        collapsingLayout.setTitle(model.getTitle());
        collapsingLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));
        tvNewsDetailTitle.setText(model.getTitle());
        Glide.with(this)
                .load(model.getImageUrl())
                .asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        Palette.from(resource).generate(NewsItemActivity.this::applyPalette);
                        newsImage.setImageBitmap(resource);
                    }
                });
        getPresenter().loadNewsItem(model.getId());
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }

    @Override public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void applyPalette(Palette palette) {
        int primaryDark = ContextCompat.getColor(NewsItemActivity.this, R.color.colorPrimaryDark);
        int primary = ContextCompat.getColor(NewsItemActivity.this, R.color.colorPrimary);
        collapsingLayout.setContentScrimColor(palette.getMutedColor(primary));
        collapsingLayout.setStatusBarScrimColor(palette.getMutedColor(primaryDark));
        supportStartPostponedEnterTransition();
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

    @SuppressWarnings("deprecation")
    @Override
    public void showNewsItem(NewsItem newsItem) {
        Log.e("TAG", "showNewsItem: " + newsItem.toString());
        tvNewsDetailArticle.setText(Html.fromHtml(newsItem.getArticle()));
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
