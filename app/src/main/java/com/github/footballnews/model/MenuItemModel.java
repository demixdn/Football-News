package com.github.footballnews.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Objects;

import java.util.List;

/**
 * Date: 31.01.2017
 * Time: 11:36
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class MenuItemModel {
    @NonNull
    private String name;
    @Nullable
    private List<ItemCategoryModel> category;

    public MenuItemModel() {
        this.name = "";
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public List<ItemCategoryModel> getCategories() {
        return category;
    }

    public void setCategories(List<ItemCategoryModel> categories) {
        this.category = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MenuItemModel that = (MenuItemModel) o;
        return Objects.equal(name, that.name) &&
                Objects.equal(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, category);
    }

    @Override
    public String toString() {
        return "MenuItemModel{" +
                "name='" + name + '\'' +
                ", categories=" + category +
                '}';
    }
}
