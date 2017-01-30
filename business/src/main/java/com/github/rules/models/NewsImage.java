package com.github.rules.models;

import java.util.Locale;

/**
 * Date: 30.01.2017
 * Time: 12:56
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsImage {

    private static final String FULL_IMAGE_SIZE = "768x437";

    private int height;
    private int width;
    private String url;

    public NewsImage() {
    }

    public NewsImage(int height, int width, String url) {
        this.height = height;
        this.width = width;
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullSizeUrl() {
        String replacement = String.format(Locale.getDefault(), "%dx%d", width, height);
        return url.replace(replacement, FULL_IMAGE_SIZE);
    }

    @Override
    public String toString() {
        return "{" +
                "height=" + height +
                ", width=" + width +
                ", url='" + url + '\'' +
                '}';
    }
}
