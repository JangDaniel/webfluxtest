package com.csbon.webfluxtest.movie.controller;

import com.csbon.webfluxtest.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final Logger logger = LoggerFactory.getLogger(MovieController.class);
    private final MovieService movieService;

    @RequestMapping("/")
    public String indexMainView(final Model model) {
        logger.info("START");
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(movieService.findAllMovieInfo(), 1);
        model.addAttribute("movies", reactiveDataDrivenMode);
        IntStream.range(1, 100).forEach(i -> logger.info(String.valueOf(i)));
        logger.info("END");
        return "index";
    }
}
