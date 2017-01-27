package com.github.footballdata.mappers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.footballdata.model.NewsItemDTO;
import com.github.footballdata.model.RssDTO;
import com.github.rules.models.NewsItem;

import java.util.ArrayList;
import java.util.List;

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
    public List<NewsItem> transformList(@Nullable RssDTO rss){
        List<NewsItem> result = new ArrayList<>();
        if(rss!=null && rss.getChannel()!=null && rss.getChannel().getNewsItems()!=null && !rss.getChannel().getNewsItems().isEmpty()){
            for(NewsItemDTO item : rss.getChannel().getNewsItems()){
                result.add(transformItem(item));
            }
        }
        return result;
    }

    @NonNull
    private NewsItem transformItem(@NonNull NewsItemDTO src){
        NewsItem result = new NewsItem();
        result.setType(src.getType());
        result.setTitle(src.getTitle());
        result.setLink(src.getLink());
        result.setDate(Long.decode(src.getDate())); // TODO: 26.01.2017 check numberformatexception
        result.setDescription(src.getDescription());
        result.setImage(src.getImage());
        return result;
    }

    @Nullable
    public NewsItem transformDetail(@Nullable RssDTO rss, int newsId){
        try {
            NewsItemDTO src = rss.getChannel().getNewsItems().get(0);// TODO: 26.01.2017 check non null
            NewsItem result = new NewsItem();
            result.setType(src.getType());
            result.setTitle(src.getTitle());
            result.setLink(src.getLink());
            result.setDate(Long.decode(src.getDate())); // TODO: 26.01.2017 check numberformatexception
            result.setArticle(src.getArticle());
            result.setCategory(src.getCategory());
            result.setNewsId(newsId);
            result.setUrl(src.getLink());
            result.setDescription(src.getDescription());
            result.setImage(src.getImage());
            return result;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return null;
        }
    }
}
