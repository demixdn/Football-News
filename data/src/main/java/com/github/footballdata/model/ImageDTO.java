package com.github.footballdata.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Date: 30.01.2017
 * Time: 12:49
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@Root(name = "img")
public class ImageDTO {
    @Attribute(name = "name")
    private int height;
    @Attribute(name = "name")
    private int width;
    @Text
    private String url;

    public ImageDTO() {
    }

    public ImageDTO(int height, int width, String url) {
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

    @Override
    public String toString() {
        return "{" +
                "height=" + height +
                ", width=" + width +
                ", url='" + url + '\'' +
                '}';
    }
}
