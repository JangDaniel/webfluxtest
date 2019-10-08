package com.csbon.webfluxtest.movie.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int score;

    public Movie(String name, int score) {
        this.name = name;
        this.score = score;
    }

}
