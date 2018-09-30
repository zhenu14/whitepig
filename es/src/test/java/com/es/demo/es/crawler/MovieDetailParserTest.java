package com.es.demo.es.crawler;

import com.es.demo.es.domain.Movie;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MovieDetailParserTest {

    @Autowired
    private MovieDetailParser movieDetail;

    @Test
    public void testParse() throws IOException {
        Movie movie = movieDetail.parse("99860");
        log.info("电影详情:{}", movie);
        Assert.assertEquals(movie.getName(), "Skyscraper");
        Assert.assertTrue(movie.getDuration() == 102);
        Assert.assertTrue(movie.getYear() == 2018);
        Assert.assertEquals(movie.getOrigin(), "美国");
        Assert.assertNotNull(movie.getDescription());
        Assert.assertEquals(movie.getActor().size(), 23);
    }

}