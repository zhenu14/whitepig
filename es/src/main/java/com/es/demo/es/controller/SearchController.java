package com.es.demo.es.controller;

import com.es.demo.es.domain.Movie;
import com.es.demo.es.domain.Page;
import com.es.demo.es.domain.QueryDTO;
import com.es.demo.es.repository.IMovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author prayer
 */
@Controller
@Slf4j
public class SearchController {

    @Autowired
    private IMovieRepository movieRepository;

    @GetMapping("/")
    public String index(Model model) {
        QueryDTO queryDTO = QueryDTO.builder().minScore(7.5f).orderBy("updateDate").build();
        Page<Movie> page = movieRepository.query(queryDTO, 1, 6);
        List<String> recommendWord = new ArrayList<>();
        if (page != null) {
            page.getList().forEach(movie -> {
                String word = movie.getName();
                String title = movie.getTitle();
                if (!StringUtils.isEmpty(title) && title.contains("《") && title.contains("》")) {
                    word = title.substring(title.indexOf('《') + 1, title.indexOf('》'));
                }
                recommendWord.add(word);
            });
        }
        model.addAttribute("recommendWord", recommendWord);
        return "index";
    }

    @RequestMapping("/s")
    public String search(
            @RequestParam("wd") String queryString,
            @RequestParam(value = "pn", required = false, defaultValue = "1") int pageNo,
            Model model
    ) {
        log.info("搜索参数wd:{},pn:{}", queryString, pageNo);
        Page<Movie> page = movieRepository.query(queryString, pageNo, 10);
        model.addAttribute("page", page);
        model.addAttribute("wd", queryString);
        return "search";
    }

    @GetMapping("/detail/{id}")
    public String detail(
            @PathVariable("id") String id,
            Model model
    ) {
        Movie movie = movieRepository.get(id);
        model.addAttribute("movie", movie);
        return "detail";
    }
}
