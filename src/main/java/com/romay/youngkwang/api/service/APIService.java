package com.romay.youngkwang.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class APIService {

    @Value("${api.key}")
    private String apiKey;
    private final WebClient webClient;

    public APIService(WebClient webClient) {
        this.webClient = webClient;
    }

    //현재 상영작 가져오는 메서드
    public void getNowPlaying() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?language=ko-KR&page=1&region=KR";
        String response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class).toString();

        System.out.println("response = " + response);


    }
}
