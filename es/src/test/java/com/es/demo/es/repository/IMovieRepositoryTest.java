package com.es.demo.es.repository;

import com.es.demo.es.domain.Movie;
import com.es.demo.es.domain.Page;
import com.es.demo.es.domain.QueryDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IMovieRepositoryTest {

    @Autowired
    private IMovieRepository movieRepository;

    @Test
    public void testQuery() {
        Page<Movie> page = movieRepository.query("爆裂无声",1, 10);
        log.info(page.toString());
        Assert.assertNotNull(page);
    }

    @Test
    public void testQuery2() {
        QueryDTO queryDTO = QueryDTO.builder().minScore(7.5f).orderBy("updateDate").build();
        Page<Movie> page = movieRepository.query(queryDTO,1, 10);
        log.info(page.toString());
        Assert.assertNotNull(page);
    }
}