package com.github.rules.models;

import com.google.common.base.Objects;

/**
 * Date: 25.01.2017
 * Time: 16:50
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class MenuItem {
    private String name;
    private String type;
    private String url;

    public MenuItem() {
    }

    public MenuItem(String name, String type, String url) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equal(name, menuItem.name) &&
                Objects.equal(type, menuItem.type) &&
                Objects.equal(url, menuItem.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, type, url);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
