package com.example.demo.router;

import com.example.demo.handler.HelloWorldHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

/**
 * @author caojianyi@dxy.cn
 * @date 2020-11-10 23:51
 * @Description  webflux中的路由器类--》相当于@RequestMapping
 */
@Configuration
public class Router {

    @Autowired
    private HelloWorldHandler  helloWorldHandler;

    @Bean
    public RouterFunction<ServerResponse> getString(){
        return route(GET("helloworld"),req->helloWorldHandler.sayHelloWorld(req));
    }

}
