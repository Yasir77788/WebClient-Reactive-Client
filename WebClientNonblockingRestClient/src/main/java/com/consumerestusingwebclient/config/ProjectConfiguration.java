package com.consumerestusingwebclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfiguration {

    //@Bean
//    public BasicAuthenticationInterceptor basicAuthenticationInterceptor(){
//        return new BasicAuthenticationInterceptor("username", "password");
//    }


    @Bean
    public  WebClient webClient(){
        return WebClient.builder()
                .filter(ExchangeFilterFunctions
                        .basicAuthentication())// it takes username and password
                .build();
    }
}
