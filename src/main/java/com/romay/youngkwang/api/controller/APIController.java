package com.romay.youngkwang.api.controller;

import com.romay.youngkwang.api.service.TmdbService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name ="외부 API",description = "외부 API 관련 기능입니다.")
public class APIController {

    private final TmdbService tmdbService;

    @GetMapping("/test") // 현재 상영작 받아오기
    public ResponseEntity<?> getNowPlaying() {
        String test = tmdbService.nowPlaying();
        return ResponseEntity.ok(test);
    }

}
