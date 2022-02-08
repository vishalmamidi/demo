package com.vishalmamidi.demorestlogger.router;

import com.vishalmamidi.demorestlogger.handler.LogDumpHandler;
import com.vishalmamidi.demorestlogger.handler.LogHandler;
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
    RouterFunction<ServerResponse> routes(LogHandler handler, LogDumpHandler handler2) {
        return route()
                .GET("/", handler::justLog)
                .GET("/hello", handler::justLog)
                .GET("/log", handler::justLog)
                .POST("/save", contentType(APPLICATION_JSON), handler::saveLog)
                .POST("/dump", handler2::justLog)
                .POST("/post", handler2::justLog)
                .build();
    }
}
