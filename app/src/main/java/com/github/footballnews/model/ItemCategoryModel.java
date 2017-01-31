package com.github.footballnews.model;

import android.util.Log;

import com.google.common.base.Objects;

/**
 * Date: 31.01.2017
 * Time: 11:36
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class ItemCategoryModel {

    private String name;
    private String type;
    private String url;

    public ItemCategoryModel() {
    }

    public ItemCategoryModel(String name, String type, String url) {
        this.name = name;
        this.type = type;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        String id = url.substring(url.lastIndexOf('=')+1);
        Log.i("TAG", "getId: " + id);
        return Integer.decode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ItemCategoryModel that = (ItemCategoryModel) o;
        return Objects.equal(name, that.name) &&
                Objects.equal(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, type);
    }

    @Override
    public String toString() {
        return "ItemCategoryModel{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
