package com.csbon.webfluxtest.movie.controller;

import com.csbon.webfluxtest.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @RequestMapping("/")
    public String indexMainView(final Model model) {
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(movieService.findAllMovieInfo(), 1);
        model.addAttribute("movies", reactiveDataDrivenMode);

        return "index";
    }
}
