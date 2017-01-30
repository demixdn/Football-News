package com.github.footballdata.mappers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.footballdata.model.ImageDTO;
import com.github.footballdata.model.NewsItemDTO;
import com.github.footballdata.model.RssDTO;
import com.github.rules.models.NewsImage;
import com.github.rules.models.NewsItem;
import com.google.common.base.Strings;

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
    public List<NewsItem> transformList(@Nullable RssDTO rss) {
        List<NewsItem> result = new ArrayList<>();
        if (rss != null && rss.getChannel() != null && rss.getChannel().getNewsItems() != null && !rss.getChannel().getNewsItems().isEmpty()) {
            for (NewsItemDTO item : rss.getChannel().getNewsItems()) {
                result.add(transformItem(item));
            }
        }
        return result;
    }

    @NonNull
    private NewsItem transformItem(@NonNull NewsItemDTO src) {
        NewsItem result = new NewsItem();
        result.setType(src.getType());
        result.setTitle(src.getTitle());
        result.setLink(src.getLink());
        result.setDate(decodeDate(src.getDate()));
        result.setDescription(src.getDescription());
        final NewsImage newsImage = imageFrom(src.getImage());
        result.setImage(newsImage);
        return result;
    }

    @Nullable
    public NewsItem transformDetail(@Nullable RssDTO rss, int newsId) {
        if(rss == null || rss.getChannel() == null || rss.getChannel().getNewsItems() == null || rss.getChannel().getNewsItems().isEmpty())
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
