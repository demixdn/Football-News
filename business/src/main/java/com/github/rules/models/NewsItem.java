package com.github.rules.models;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

/**
 * Date: 25.01.2017
 * Time: 17:20
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsItem {
    private int newsId;

    private String type;

    private String title;

    private String link;

    private String url;

    private long date;

    private String description;

    private String category;

    private String article;

    private String image;

    public NewsItem() {
    }

    public NewsItem(int newsId, String type, String title, String link, String url, long date, String description, String category, String article, String image) {
        this.newsId = newsId;
        this.type = type;
        this.title = title;
        this.link = link;
        this.url = url;
        this.date = date;
        this.description = description;
        this.category = category;
        this.article = article;
        this.image = image;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFullItem(){
        return !Strings.isNullOrEmpty(category) && !Strings.isNullOrEmpty(article) && newsId > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NewsItem newsItem = (NewsItem) o;
        return newsId == newsItem.newsId &&
                Objects.equal(title, newsItem.title) &&
                Objects.equal(date, newsItem.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(newsId, title, date);
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "newsId=" + newsId +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", article='" + article + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
