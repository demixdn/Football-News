package com.github.footballdata.net;

import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Date: 25.01.2017
 * Time: 16:31
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@SuppressWarnings("all")
public class RestModule {
    @NonNull
    private final String baseUrl;

    @NonNull
    private final OkHttpClient okHttpClient;

    public RestModule(@NonNull String baseUrl, @NonNull OkHttpClient okHttpClient) {
        Preconditions.checkNotNull(baseUrl, "Base URL can not be null");
        Preconditions.checkNotNull(okHttpClient, "Http Client can not be null");
        this.baseUrl = baseUrl;
        this.okHttpClient = okHttpClient;
    }

    @NonNull
    public RestAPI getRestApi(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RestAPI.class);
    }

}
