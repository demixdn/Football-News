package com.github.footballdata.model;

import com.google.common.base.Objects;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Date: 25.01.2017
 * Time: 13:01
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@Root(name = "sub")
public class MenuItemDTO {
    @Attribute(name = "name")
    private String name;
    @Attribute(name = "type")
    private String type;
    @Attribute(name = "url")
    private String url;

    public MenuItemDTO() {
    }

    public MenuItemDTO(String name, String type, String url) {
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
        MenuItemDTO menuItem = (MenuItemDTO) o;
        return Objects.equal(name, menuItem.name) &&
               Objects.equal(type, menuItem.type) &&
               Objects.equal(url, menuItem.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, type, url);
    }
}
