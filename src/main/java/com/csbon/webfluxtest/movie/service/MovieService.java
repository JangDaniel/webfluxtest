package com.csbon.webfluxtest.movie.service;

import com.csbon.webfluxtest.movie.model.Movie;
import com.csbon.webfluxtest.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public boolean addMovieInfo(final Movie movie) {
        movieRepository.save(movie);
        return true;
    }

    public boolean addMoviesInfo(List<Movie> movieList) {
        movieRepository.saveAll(movieList);
        return true;
    }

    public Flux<Movie> findAllMovieInfo() {
        return Flux.fromIterable(movieRepository.findAll())
                .subscribeOn(Schedulers.elastic())
                .log()
                .delayElements(Duration.ofSeconds(1));
    }
}
