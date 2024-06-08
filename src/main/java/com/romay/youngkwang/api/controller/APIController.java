package com.romay.youngkwang.api.controller;

import com.romay.youngkwang.api.service.APIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    private final APIService apiService;

    public APIController(APIService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/nowPlaying") // 현재 상영작 리스트 받아오기
    public void getNowPlayingMovieList () {
//        System.out.println(apiService.getNowPlaying());


    }
}
