package com.csbon.webfluxtest.movie.repository;

import com.csbon.webfluxtest.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
