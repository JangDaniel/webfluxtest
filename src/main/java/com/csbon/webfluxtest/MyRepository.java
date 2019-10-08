package com.csbon.webfluxtest;

import com.csbon.webfluxtest.movie.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class Movie {
//    private String name;
//    private Integer score;
//}

@Repository
public class MyRepository {
    private static List<Movie> movie = new ArrayList<>();
/*
    static {
        movie.add(new Movie("Polar (2019)", 64));
        movie.add(new Movie("Iron Man (2008)", 79));
        movie.add(new Movie("The Shawshank Redemption (1994)", 93));
        movie.add(new Movie("Forrest Gump (1994)", 83));
        movie.add(new Movie("Glass (2019)", 70));
    }

    public Flux<Movie> findAll() {
        //Simulate big list of data, streaming it every 2 second delay
        return Flux.fromIterable(movie).delayElements(Duration.ofSeconds(1));
    }

    public Mono<Movie> findFirst() {
        return Mono.just(movie.get(0));
    }

    public Mono<List<Movie>> findAllbyMono() {
        return Mono.just(movie);
    }

 */
}

