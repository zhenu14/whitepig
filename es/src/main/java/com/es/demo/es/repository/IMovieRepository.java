package com.es.demo.es.repository;


import com.es.demo.es.domain.Movie;
import com.es.demo.es.domain.Page;
import com.es.demo.es.domain.QueryDTO;

public interface IMovieRepository {

    boolean save(Movie movie);

    Page<Movie> query(String queryString, int pageNo, int size);

    Page<Movie> query(QueryDTO queryDTO, int pageNo, int size);

    Movie get(String id);
}
