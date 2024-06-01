package com.romay.youngkwang.api.service;

import com.romay.youngkwang.common.ResponseDTO;
import com.romay.youngkwang.common.ResponseTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Service
public class APIService {

    @Value("${api.key}")
    private String apiKey;
    private ResponseTool responseTool;
    private RestTemplate restTemplate;


    public APIService(ResponseTool responseTool, RestTemplate restTemplate) {
        this.responseTool = responseTool;
        this.restTemplate = restTemplate;
    }
}

    //현재 상영작 가져오는 메서드
//    public String getNowPlaying() {
//        String url = "/movie/now_playing";
//        restTemplate.
//
//        return response;
//
//
//
//
//    }
//}
