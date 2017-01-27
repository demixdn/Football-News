package com.github.rules.models;

import com.google.common.base.Objects;

import java.util.List;

/**
 * Date: 25.01.2017
 * Time: 13:00
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
public class MenuGroup {
    private String name;

    private List<MenuItem> items;

    public MenuGroup(String name, List<MenuItem> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MenuGroup menuGroup = (MenuGroup) o;
        return Objects.equal(name, menuGroup.name) &&
                Objects.equal(items, menuGroup.items);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, items);
    }

    @Override
    public String toString() {
        return "MenuGroup{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
