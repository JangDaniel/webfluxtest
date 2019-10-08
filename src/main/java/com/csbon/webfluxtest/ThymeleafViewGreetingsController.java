package com.csbon.webfluxtest;

import com.csbon.webfluxtest.greeting.model.GreetingProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
@RequiredArgsConstructor
class ThymeleafViewGreetingsController {


    private final GreetingProducer producer;
    private final MyRepository repo;

    @GetMapping("/greetings.do")
    String renderInitialView() {
     return "greetings";
    }

    @GetMapping(value = "/greetings-updates.do", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String renderUpdatedView(@RequestParam("name") String name, Model model) {
        var variable = new ReactiveDataDriverContextVariable(this.producer.greet(name), 1);

        model.addAttribute("greetings", variable);
        return "greetings :: #greetings-block";
    }


}
