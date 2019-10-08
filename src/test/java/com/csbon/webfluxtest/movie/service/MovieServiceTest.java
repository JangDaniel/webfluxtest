package com.csbon.webfluxtest.movie.service;

import com.csbon.webfluxtest.movie.model.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void addMovieTest() {

        List<Movie> movieList = Arrays.asList(new Movie("Polar (2019)", 64),
                new Movie("Iron Man (2008)", 79),
                new Movie("he Shawshank Redemption (1994)", 93),
                new Movie("Forrest Gump (1994)", 83),
                new Movie("Glass (2019)", 70));

        assertThat(movieService.addMoviesInfo(movieList)).isTrue();


    }
}