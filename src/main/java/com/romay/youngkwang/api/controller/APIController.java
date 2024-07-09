package com.romay.youngkwang.api.controller;

import com.romay.youngkwang.api.dto.response.NowPlayingMoviesResponseDTO;
import com.romay.youngkwang.api.service.TmdbService;
import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name ="외부 API",description = "외부 API 관련 기능입니다.")
public class APIController {

    private final TmdbService tmdbService;

    @GetMapping("/nowPlaying") // 현재 상영작 받아오기
    @Operation(summary = "현재 상영작", description = "현재 상영작 불러오기")
    @ApiResponse(responseCode = "200", description = "성공시 현재 상영작들의 List 를 응답합니다",
            content = @Content(schema = @Schema(implementation = NowPlayingMoviesResponseDTO.class)))
    public ResponseEntity<?> getNowPlaying(int page) {
        List<NowPlayingMoviesResponseDTO> dtoList = tmdbService.nowPlaying(page);
        return ResponseEntity.ok(dtoList);
    }

}
