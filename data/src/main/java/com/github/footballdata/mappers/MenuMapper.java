package com.github.footballdata.mappers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.footballdata.model.MenuDTO;
import com.github.rules.models.MenuGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 26.01.2017
 * Time: 19:55
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class MenuMapper {
    public MenuMapper() {
        //empty
    }

    @NonNull
    public List<MenuGroup> transform(@Nullable MenuDTO menu){
        List<MenuGroup> result = new ArrayList<>();
        // TODO: 26.01.2017 add transformation
        return result;
    }
}
