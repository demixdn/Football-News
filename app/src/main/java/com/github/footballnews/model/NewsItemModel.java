package com.github.footballnews.model;

import android.support.annotation.Nullable;

import com.google.common.base.Objects;

/**
 * Date: 30.01.2017
 * Time: 15:59
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsItemModel {
    private int id;
    private String title;
    private String date;
    private String imageUrl;
    private String description;
    @Nullable
    private String htmlArticle;

    public NewsItemModel() {
    }

    public NewsItemModel(int id, String title, String date, String imageUrl, String description, @Nullable String htmlArticle) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.imageUrl = imageUrl;
        this.description = description;
        this.htmlArticle = htmlArticle;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    @Nullable
    public String getHtmlArticle() {
        return htmlArticle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHtmlArticle(@Nullable String htmlArticle) {
        this.htmlArticle = htmlArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NewsItemModel newsItemModel = (NewsItemModel) o;
        return id == newsItemModel.id &&
                Objects.equal(title, newsItemModel.title) &&
                Objects.equal(date, newsItemModel.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, title, date);
    }

    @Override
    public String toString() {
        return "NewsItemModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", htmlArticle='" + htmlArticle + '\'' +
                '}';
    }


}
