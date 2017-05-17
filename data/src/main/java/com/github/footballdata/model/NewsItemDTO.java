package com.github.footballdata.model;

import android.support.annotation.Nullable;

import com.google.common.base.Objects;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Date: 25.01.2017
 * Time: 14:07
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@Root(name = "item", strict = false)
public class NewsItemDTO {
    @Nullable
    @Attribute(name = "type")
    private String type;

    @Nullable
    @Element(name = "title", data = true, required = false)
    private String title;

    @Nullable
    @Element(name = "link", data = true)
    private String link;

    @Nullable
    @Element(name = "date", data = true, required = false)
    private String date;

    @Nullable
    @Element(name = "description", data = true, required = false)
    private String description;

    @Nullable
    @Element(name = "category", data = true, required = false)
    private String category;

    @Nullable
    @Element(name = "article", data = true, required = false)
    private String article;

    @Nullable
    @Element(name = "img")
    private ImageDTO image;

    public NewsItemDTO() {
    }

    public NewsItemDTO(@Nullable String type, @Nullable String title, @Nullable String link,
                       @Nullable String date, @Nullable String description, @Nullable String category,
                       @Nullable String article, @Nullable ImageDTO image) {
        this.type = type;
        this.title = title;
        this.link = link;
        this.date = date;
        this.description = description;
        this.category = category;
        this.article = article;
        this.image = image;
    }

    @Nullable
    public String getType() {
        return type;
    }

    public void setType(@Nullable String type) {
        this.type = type;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getLink() {
        return link;
    }

    public void setLink(@Nullable String link) {
        this.link = link;
    }

    @Nullable
    public String getDate() {
        return date;
    }

    public void setDate(@Nullable String date) {
        this.date = date;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public String getCategory() {
        return category;
    }

    public void setCategory(@Nullable String category) {
        this.category = category;
    }

    @Nullable
    public String getArticle() {
        return article;
    }

    public void setArticle(@Nullable String article) {
        this.article = article;
    }

    @Nullable
    public ImageDTO getImage() {
        return image;
    }

    public void setImage(@Nullable ImageDTO image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NewsItemDTO that = (NewsItemDTO) o;
        return Objects.equal(title, that.title) &&
                Objects.equal(link, that.link) &&
                Objects.equal(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, link, date);
    }

    @Override
    public String toString() {
        return "NewsItemDTO{" +
                "type='" + type + '\'' +
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
