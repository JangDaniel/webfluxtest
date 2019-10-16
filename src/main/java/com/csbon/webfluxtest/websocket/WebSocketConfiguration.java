package com.csbon.webfluxtest.websocket;

import com.csbon.webfluxtest.greeting.model.Greeting;
import com.csbon.webfluxtest.greeting.model.GreetingProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;


@Configuration
class WebSocketConfiguration {

    @Bean
    SimpleUrlHandlerMapping simpleUrlHandlerMapping(WebSocketHandler wsh) {

        return new SimpleUrlHandlerMapping() {
            {
                setOrder(10);
                setUrlMap(Map.of("/ws/greetings", wsh));

                Map<String, CorsConfiguration> corsConfigurationMap = new HashMap<>();

                CorsConfiguration corsConfiguration = new CorsConfiguration();
                corsConfiguration.addAllowedOrigin("/**");
                corsConfigurationMap.put("ws://localhost:8080/ws/greetings", corsConfiguration);

                setCorsConfigurations(corsConfigurationMap);
            }
        };
    }

    @Bean
    WebSocketHandlerAdapter webSocketHandlerAdapter() {
        return new WebSocketHandlerAdapter();
    }


    @Bean
    WebSocketHandler webSocketHandler(GreetingProducer producer) {
        return new WebSocketHandler() {
            @Override
            public Mono<Void> handle(WebSocketSession session) {
//                Flux<String> namesToGreet = session.receive(f).map(WebSocketMessage::getPayloadAsText);
//                Flux<Greeting> responseGreetings = namesToGreet.flatMap(producer::greet);
//                Flux<String> stringResponse = responseGreetings.map(Greeting::getMessage);
//
//                Flux<WebSocketMessage> map = stringResponse.map(stringGreeting -> session.textMessage(stringGreeting));
                var greetings = session
                        .receive()
                        .map(WebSocketMessage::getPayloadAsText)
                        .flatMap(producer::greet)
                        .map(Greeting::getMessage)
                        .map(stringGreeting -> session.textMessage(stringGreeting));
                return session.send(greetings);
            }
        };
    }

}
