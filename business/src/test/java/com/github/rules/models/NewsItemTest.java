package com.github.rules.models;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Date: 16.02.2017
 * Time: 15:19
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
public class NewsItemTest {

    private static final int FAKE_NEWS_ID = 328394;
    private static final String FAKE_TYPE = "news";
    private static final String FAKE_TITLE = "Баланюк: у каждого есть шанс попасть в состав";
    private static final String FAKE_LINK = "http://football.ua/hnd/Android/NewsItem.ashx?news_id=328394";
    private static final String FAKE_URL = "http://football.ua/ukraine/328394-balanjuk-u-kazhdogo-est-shans-popast-v-sostav.html";
    private static final long FAKE_DATE = 1487256840;
    private static final String FAKE_DESCRIPTION = "Нападающий Днепра Денис Баланюк отметил старания каждого футболиста команды.";
    private static final String FAKE_CATEGORY = "Украина";
    private static final String FAKE_ARTICLE = "<![CDATA[<p>&quot;Каждый день прогрессируем, становимся лучше. На пользу идет каждый день&quot;, &mdash; сказал Баланюк в комментарии телеканалу<em> Футбол 1</em>.</p><p>&quot;Толком состав не поменялся, много ребят не ушли. Лучкевич, разве что, и то он полсезона не играл&hellip; Еще Близниченко&quot;.</p><p>&quot;Есть игроки, которые прогрессируют, хотят попасть в состав, у каждого есть шансы, поэтому все стараются&quot;.</p><p>Первый официальный матч после зимней паузы Днепр проведет 26 февраля. Соперник &mdash; Зирка.</p>]]>";
    private static final String FAKE_IMAGE_URL = "http://s.ill.in.ua/i/news/289x192/328/328394.jpg";
    private static final NewsImage FAKE_IMAGE = new NewsImage(192, 289, FAKE_IMAGE_URL);

    private NewsItem newsItem;

    @Before
    public void setUp() {
        newsItem = new NewsItem();
    }

    @Test
    public void getNewsId() throws Exception {
        newsItem.setNewsId(FAKE_NEWS_ID);

        assertThat(newsItem.getNewsId()).isEqualTo(FAKE_NEWS_ID);
    }

    @Test
    public void getType() throws Exception {
        newsItem.setType(FAKE_TYPE);

        assertThat(newsItem.getType()).isEqualTo(FAKE_TYPE);
    }

    @Test
    public void getTitle() throws Exception {
        newsItem.setTitle(FAKE_TITLE);

        assertThat(newsItem.getTitle()).isEqualTo(FAKE_TITLE);
    }

    @Test
    public void getLink() throws Exception {
        newsItem.setLink(FAKE_LINK);

        assertThat(newsItem.getLink()).isEqualTo(FAKE_LINK);
    }

    @Test
    public void getUrl() throws Exception {
        newsItem.setUrl(FAKE_URL);

        assertThat(newsItem.getUrl()).isEqualTo(FAKE_URL);
    }

    @Test
    public void getDate() throws Exception {
        newsItem.setDate(FAKE_DATE);

        assertThat(newsItem.getDate()).isEqualTo(FAKE_DATE);
    }

    @Test
    public void getDescription() throws Exception {
        newsItem.setDescription(FAKE_DESCRIPTION);

        assertThat(newsItem.getDescription()).isEqualTo(FAKE_DESCRIPTION);
    }

    @Test
    public void getCategory() throws Exception {
        newsItem.setCategory(FAKE_CATEGORY);

        assertThat(newsItem.getCategory()).isEqualTo(FAKE_CATEGORY);
    }

    @Test
    public void getArticle() throws Exception {
        newsItem.setArticle(FAKE_ARTICLE);

        assertThat(newsItem.getArticle()).isEqualTo(FAKE_ARTICLE);
    }

    @Test
    public void getImage() throws Exception {
        newsItem.setImage(FAKE_IMAGE);

        assertThat(newsItem.getImage()).isEqualTo(FAKE_IMAGE);
    }

    @Test
    public void isFullItemSuccess() throws Exception {
        newsItem.setNewsId(FAKE_NEWS_ID);
        newsItem.setCategory(FAKE_CATEGORY);
        newsItem.setArticle(FAKE_ARTICLE);
        assertThat(newsItem.isFullItem()).isEqualTo(true);
    }

    @Test
    public void isFullItemErrorWithoutCategory() throws Exception {
        newsItem.setNewsId(FAKE_NEWS_ID);
        newsItem.setArticle(FAKE_ARTICLE);
        assertThat(newsItem.isFullItem()).isEqualTo(false);
    }

    @Test
    public void isFullItemErrorWithoutId() throws Exception {
        newsItem.setCategory(FAKE_CATEGORY);
        newsItem.setArticle(FAKE_ARTICLE);
        assertThat(newsItem.isFullItem()).isEqualTo(false);
    }

    @Test
    public void isFullItemErrorWithoutArticle() throws Exception {
        newsItem.setNewsId(FAKE_NEWS_ID);
        newsItem.setCategory(FAKE_CATEGORY);
        assertThat(newsItem.isFullItem()).isEqualTo(false);
    }

}