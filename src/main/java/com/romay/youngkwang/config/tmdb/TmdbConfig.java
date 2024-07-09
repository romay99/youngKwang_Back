package com.romay.youngkwang.config.tmdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TmdbConfig {

    @Value("${api.key}")
    private String apiKey;

    private String baseUrl = "https://api.themoviedb.org/3";

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder
                .defaultHeader("Authorization",apiKey)
                .rootUri(baseUrl)
                .build();
    }
}
