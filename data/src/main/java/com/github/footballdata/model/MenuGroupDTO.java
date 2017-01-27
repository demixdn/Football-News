package com.github.footballdata.model;

import com.google.common.base.Objects;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Date: 25.01.2017
 * Time: 13:00
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@Root(name = "item")
public class MenuGroupDTO {
    @Attribute(name = "name")
    private String name;

    @ElementList(inline=true)
    private List<MenuItemDTO> items;

    public MenuGroupDTO() {
    }

    public MenuGroupDTO(String name, List<MenuItemDTO> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItemDTO> getItems() {
        return items;
    }

    public void setItems(List<MenuItemDTO> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuGroupDTO that = (MenuGroupDTO) o;
        return Objects.equal(name, that.name) &&
                Objects.equal(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, items);
    }

    @Override
    public String toString() {
        return "MenuGroupDTO{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
