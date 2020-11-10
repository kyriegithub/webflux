package com.example.demo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author caojianyi@dxy.cn
 * @date 2020-11-10 23:43
 * @Description  用响应式变成开发webflux--》处理器类Handler
 *  相当于mvc模式中的controller层
 */
@Component
public class HelloWorldHandler {


    public Mono<ServerResponse> sayHelloWorld(ServerRequest serverRequest){
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("This is WebFlux demo"),String.class);

    }
}
