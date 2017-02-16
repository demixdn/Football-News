package com.github.rules.models;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Date: 16.02.2017
 * Time: 16:38
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
public class NewsImageTest {

    private static final String FAKE_IMAGE_URL = "http://s.ill.in.ua/i/news/289x192/328/328394.jpg";
    private static final String FAKE_FULL_IMAGE_URL = "http://s.ill.in.ua/i/news/768x437/328/328394.jpg";
    private static final int FAKE_HEIGHT = 192;
    private static final int FAKE_WIDTH = 289;

    private NewsImage newsImage;

    @Before
    public void setUp() throws Exception {
        newsImage = new NewsImage(FAKE_HEIGHT, FAKE_WIDTH, FAKE_IMAGE_URL);
    }

    @Test
    public void getHeight() throws Exception {
        assertThat(newsImage.getHeight()).isEqualTo(FAKE_HEIGHT);
    }

    @Test
    public void getWidth() throws Exception {
        assertThat(newsImage.getWidth()).isEqualTo(FAKE_WIDTH);
    }

    @Test
    public void getUrl() throws Exception {
        assertThat(newsImage.getUrl()).isEqualTo(FAKE_IMAGE_URL);
    }

    @Test
    public void getFullSizeUrl() throws Exception {
        assertThat(newsImage.getFullSizeUrl()).isEqualTo(FAKE_FULL_IMAGE_URL);
    }

}