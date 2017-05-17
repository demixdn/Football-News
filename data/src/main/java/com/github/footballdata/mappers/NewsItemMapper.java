package com.github.footballdata.mappers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.github.footballdata.model.ImageDTO;
import com.github.footballdata.model.NewsItemDTO;
import com.github.footballdata.model.RssDTO;
import com.github.rules.models.NewsImage;
import com.github.rules.models.NewsItem;
import com.google.common.base.Strings;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 26.01.2017
 * Time: 19:33
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsItemMapper {
    public NewsItemMapper() {
        //empty
    }

    @NonNull
    public List<NewsItem> transformList(@Nullable RssDTO rss) throws MalformedURLException, UnsupportedEncodingException {
        List<NewsItem> result = new ArrayList<>();
        if (rss != null && rss.getChannel() != null && rss.getChannel().getNewsItems() != null && !rss.getChannel().getNewsItems().isEmpty()) {
            for (NewsItemDTO item : rss.getChannel().getNewsItems()) {
                if (!TextUtils.isEmpty(item.getType()) && item.getType().contentEquals("news")) {
                    result.add(transformItem(item));
                }
            }
        }
        return result;
    }

    @NonNull
    private NewsItem transformItem(@NonNull NewsItemDTO src) throws MalformedURLException, UnsupportedEncodingException {
        NewsItem result = new NewsItem();
        result.setType(src.getType());
        result.setTitle(src.getTitle());
        result.setLink(src.getLink());
        result.setNewsId(parseIdFromLink(src.getLink()));
        result.setDate(decodeDate(src.getDate()));
        result.setDescription(src.getDescription());
        final NewsImage newsImage = imageFrom(src.getImage());
        result.setImage(newsImage);
        return result;
    }

    private static int parseIdFromLink(String link) throws MalformedURLException, UnsupportedEncodingException {
        //http://football.ua/hnd/Android/NewsItem.ashx?news_id=326274
        String positionString = splitQuery(new URL(link)).get("news_id");
        return Integer.decode(positionString);
    }

    private static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
        final Map<String, String> queryPairs = new HashMap<>();
        final String[] pairs = url.getQuery().split("&");
        for (String pair : pairs) {
            final int indexOf = pair.indexOf('=');
            final String key = indexOf > 0 ? URLDecoder.decode(pair.substring(0, indexOf), "UTF-8") : pair;
            final String value = indexOf > 0 && pair.length() > indexOf + 1 ? URLDecoder.decode(pair.substring(indexOf + 1), "UTF-8") : null;
            if (!queryPairs.containsKey(key)) {
                queryPairs.put(key, value);
            }
        }
        return queryPairs;
    }

    @Nullable
    public NewsItem transformDetail(@Nullable RssDTO rss, int newsId) {
        if (rss == null || rss.getChannel() == null || rss.getChannel().getNewsItems() == null || rss.getChannel().getNewsItems().isEmpty())
            return null;
        NewsItemDTO src = rss.getChannel().getNewsItems().get(0);
        NewsItem result = new NewsItem();
        result.setType(src.getType());
        result.setTitle(src.getTitle());
        result.setLink(src.getLink());
        result.setDate(decodeDate(src.getDate()));
        result.setArticle(src.getArticle());
        result.setCategory(src.getCategory());
        result.setNewsId(newsId);
        result.setUrl(src.getLink());
        result.setDescription(src.getDescription());
        final NewsImage newsImage = imageFrom(src.getImage());
        result.setImage(newsImage);
        return result;
    }

    private Long decodeDate(String dateString) {
        try {
            return Long.decode(Strings.isNullOrEmpty(dateString) ? "0" : dateString);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    @Nullable
    private NewsImage imageFrom(@Nullable ImageDTO imageDTO) {
        NewsImage image = null;
        if (imageDTO != null)
            image = new NewsImage(imageDTO.getHeight(), imageDTO.getWidth(), imageDTO.getUrl());
        return image;
    }
}
