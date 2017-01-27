package com.github.footballdata.net;

import android.support.annotation.Nullable;

import com.github.footballdata.BuildConfig;
import com.github.footballdata.DataConst;
import com.github.footballdata.model.MenuDTO;
import com.github.footballdata.model.RssDTO;
import com.google.common.annotations.Beta;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Date: 25.01.2017
 * Time: 13:45
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public interface RestAPI {

    @Beta
    @GET(BuildConfig.MENU)
    Observable<MenuDTO> getMenu();

    @Beta
    @GET(BuildConfig.NEWS)
    Observable<RssDTO> getNews(@Query(DataConst.Params.PAGE_ID) @Nullable Integer pageId);

    @Beta
    @GET(BuildConfig.NEWS_DETAIL)
    Observable<RssDTO> getNewsDetail(@Query(DataConst.Params.NEWS_ID) int newsId);
}
