package com.github.footballnews.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.footballnews.model.ItemCategoryModel;
import com.github.footballnews.model.MenuItemModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 31.01.2017
 * Time: 11:50
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class StaticMenu {
    private static final String MENU_JSON = "[{\"name\":\"Украина\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=4\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=18\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=18\"}]},{\"name\":\"Украина. Лига 1\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=12\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=46\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=46\"}]},{\"name\":\"Англия\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=66\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=15\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=15\"}]},{\"name\":\"Аргентина\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=96\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=68\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=68\"}]},{\"name\":\"Бразилия\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=70\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=51\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=51\"}]},{\"name\":\"Германия\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=74\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=13\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=13\"}]},{\"name\":\"Испания\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=121\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=10\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=10\"}]},{\"name\":\"Италия\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=113\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=12\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=12\"}]},{\"name\":\"Нидерланды\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=129\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=38\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=38\"}]},{\"name\":\"Португалия\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=168\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=32\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=32\"}]},{\"name\":\"Северная Америка\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=184\"}]},{\"name\":\"Турция\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=197\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=62\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=62\"}]},{\"name\":\"Франция\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=189\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=14\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=14\"}]},{\"name\":\"Другие страны\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=181\"}]},{\"name\":\"Лига чемпионов\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=24\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=16\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=16\"}]},{\"name\":\"Лига Европы\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=105\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=58\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=58\"}]},{\"name\":\"Копа Либертадорес\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=156\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=65\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=65\"}]},{\"name\":\"ЧМ-2014\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=137\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=20\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=20\"}]},{\"name\":\"ЕВРО-2016\",\"category\":[{\"name\":\"Новости\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=1467\"},{\"name\":\"Календарь\",\"type\":\"MatchCalendar\",\"url\":\"http://football.ua/hnd/Android/FootballMatches.ashx?champ_id=23\"},{\"name\":\"Таблица\",\"type\":\"TableItem\",\"url\":\"http://football.ua/hnd/Android/FootballTable.ashx?champ_id=23\"}]},{\"name\":\"ЧТИВО\",\"category\":[{\"name\":\"4-4-2\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=244\"},{\"name\":\"Бизнес и финансы\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=203\"},{\"name\":\"Бей-беги\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=213\"},{\"name\":\"Другой футбол\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=306\"},{\"name\":\"Испанский связной\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=223\"},{\"name\":\"Ретро Футбол\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=229\"},{\"name\":\"Скаут\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=226\"},{\"name\":\"Третий тайм\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=232\"},{\"name\":\"Прочее\",\"type\":\"NewsList\",\"url\":\"http://football.ua/hnd/Android/News.ashx?page_id=220\"}]}]";

    private static List<MenuItemModel> getMenuJson() {
        TypeToken typeToken = new TypeToken<List<MenuItemModel>>() {
        };
        return new Gson().fromJson(MENU_JSON, typeToken.getType());
    }

    @Nullable
    public static MenuItemModel findByTitle(@NonNull CharSequence title){
        List<MenuItemModel> menus = getMenuJson();
        for(MenuItemModel item : menus)
            if(item.getName().contentEquals(title))
                return item;
        List<ItemCategoryModel> lastCategories = menus.get(menus.size()-1).getCategories();
        for(ItemCategoryModel itemCategory : lastCategories){
            if(itemCategory.getName().contentEquals(title)){
                MenuItemModel menuItemModel = new MenuItemModel();
                menuItemModel.setName(itemCategory.getName());
                List<ItemCategoryModel> subs = new ArrayList<>(1);
                subs.add(itemCategory);
                menuItemModel.setCategories(subs);
                return menuItemModel;
            }
        }
        return null;
    }
}
