package com.github.footballnews.model.mapper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;

import com.github.footballnews.model.NewsItemModel;
import com.github.rules.models.NewsItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.github.footballnews.model.NewsItemModel.DATE_PATTERN;

/**
 * Date: 30.01.2017
 * Time: 16:55
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsItemMapper {

    private NewsItemMapper() {
        //empty
    }

    @NonNull
    public static List<NewsItemModel> transform(@NonNull List<NewsItem> items) {
        List<NewsItemModel> result = new ArrayList<>();
        for (NewsItem item : items) {
            result.add(transform(item));
        }
        return result;
    }

    @SuppressWarnings("deprecation")
    @Nullable
    private static NewsItemModel transform(@NonNull NewsItem item) {
        NewsItemModel result = new NewsItemModel();
        result.setTitle(Html.fromHtml(item.getTitle()).toString());
        result.setId(item.getNewsId());
        result.setDescription(Html.fromHtml(item.getDescription()).toString());
        result.setImageUrl(item.getImage().getFullSizeUrl());
        result.setHtmlArticle(item.getArticle());
        result.setDate(dateFromLong(item.getDate()));
        return result;
    }

    private static String dateFromLong(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN, Locale.getDefault());
        return sdf.format(new Date(date * 1000L));
    }

}
