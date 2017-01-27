package com.github.footballdata.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Date: 25.01.2017
 * Time: 13:45
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@Root(name = "menu")
public class MenuDTO {

    @ElementList(inline=true)
    private List<MenuGroupDTO> menus;

    public MenuDTO() {
    }

    public MenuDTO(List<MenuGroupDTO> menus) {
        this.menus = menus;
    }

    public List<MenuGroupDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuGroupDTO> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menus=" + menus +
                '}';
    }
}
