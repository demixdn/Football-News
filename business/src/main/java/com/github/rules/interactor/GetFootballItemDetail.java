package com.github.rules.interactor;

import com.github.rules.FootballRepository;
import com.github.rules.executor.UIScheduler;
import com.github.rules.executor.WorkerScheduler;
import com.github.rules.models.NewsItem;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Date: 26.01.2017
 * Time: 15:49
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class GetFootballItemDetail extends UseCase {

    private int itemId;
    private final FootballRepository footballRepository;

    public GetFootballItemDetail(UIScheduler uiScheduler, WorkerScheduler workerScheduler, FootballRepository footballRepository) {
        super(uiScheduler, workerScheduler);
        this.footballRepository = footballRepository;
    }

    public GetFootballItemDetail setItem(NewsItem item) throws MalformedURLException, UnsupportedEncodingException, NumberFormatException {
        this.itemId = parseIdFromLink(item.getLink());
        return this;
    }

    private int parseIdFromLink(String link) throws MalformedURLException, UnsupportedEncodingException, NumberFormatException {
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

    @Override
    protected Observable buildUseCaseObservable() {
        return footballRepository.getNewsDetail(itemId);
    }
}
