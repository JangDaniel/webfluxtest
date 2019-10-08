package com.csbon.webfluxtest.greeting.controller;

import com.csbon.webfluxtest.greeting.model.GreetingProducer;
import com.csbon.webfluxtest.greeting.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GreetinsController {
      private final GreetingProducer producer;

    @GetMapping(value = "/sse/greetings/{name}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Publisher<String> greet(@PathVariable String name) {
        return this.producer.greet(name).map(Greeting::getMessage);
    }
}
