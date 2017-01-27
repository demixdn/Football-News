package com.github.footballdata.model;

import android.support.annotation.Nullable;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Date: 25.01.2017
 * Time: 14:10
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@Root(name = "channel")
public class ChannelDTO {
    @Nullable
    @ElementList(inline=true)
    private List<NewsItemDTO> newsItems;

    public ChannelDTO() {
    }

    public ChannelDTO(List<NewsItemDTO> newsItems) {
        this.newsItems = newsItems;
    }

    @Nullable
    public List<NewsItemDTO> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<NewsItemDTO> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public String toString() {
        return newsItems.toString();
    }
}
