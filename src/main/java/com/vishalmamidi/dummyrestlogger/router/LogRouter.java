package com.vishalmamidi.dummyrestlogger.router;

import com.vishalmamidi.dummyrestlogger.handler.logHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class LogRouter {
    @Bean
    RouterFunction<ServerResponse> routes(logHandler handler) {
        return route()
                .GET("/log", contentType(APPLICATION_JSON), handler::justLog)
                .POST("/save", contentType(APPLICATION_JSON), handler::saveLog)
                .build();
    }
}
