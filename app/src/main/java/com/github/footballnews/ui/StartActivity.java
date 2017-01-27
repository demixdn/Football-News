package com.github.footballnews.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.footballnews.App;
import com.github.footballnews.R;
import com.github.footballnews.di.AppComponent;
import com.github.footballnews.di.HasComponent;
import com.github.rules.interactor.GetFootballNews;

import io.reactivex.observers.DefaultObserver;

public class StartActivity extends AppCompatActivity implements HasComponent<AppComponent> {


    private static final String TAG = "StartActivity";
    private GetFootballNews useCaseGetFootbalNews;

    public void setUseCaseGetFootbalNews(GetFootballNews useCaseGetFootbalNews) {
        this.useCaseGetFootbalNews = useCaseGetFootbalNews;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getComponent().inject(this);
        useCaseGetFootbalNews.setPageId(null).execute(new DefaultObserver() {
            @Override
            public void onNext(Object o) {
                Log.i(TAG, "onNext: " + o.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
            }
        });
    }

    @Override
    public AppComponent getComponent() {
        return App.getAppComponent();
    }
}
