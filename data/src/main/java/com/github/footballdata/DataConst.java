package com.github.footballdata;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Date: 25.01.2017
 * Time: 12:24
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public final class DataConst {

    public static final class Params{
        public static HttpLoggingInterceptor.Level LOG_LEVEL = HttpLoggingInterceptor.Level.HEADERS;
        public static int DEFAULT_TIMEOUT = 15;
        public static final String NEWS_ID = "news_id";
        public static final String PAGE_ID = "page_id";
        public static final String CHAMP_ID = "champ_id";
    }

    public static final class NewsType{
        public static final String NEWS_LIST = "NewsList";
        public static final String MATCH_CALENDAR = "MatchCalendar";
        public static final String TABLE_ITEM = "TableItem";
    }

}
