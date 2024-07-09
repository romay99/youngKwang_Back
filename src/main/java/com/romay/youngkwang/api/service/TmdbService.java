package com.romay.youngkwang.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class TmdbService {

    private final RestTemplate restTemplate;

    public String nowPlaying() {
        String endPoint = "/movie/now_playing";

        String url = UriComponentsBuilder.fromUriString(endPoint)
                        .queryParam("language","ko-KO")
                        .queryParam("region","KR")
                                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }
}
