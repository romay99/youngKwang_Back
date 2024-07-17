package com.romay.youngkwang.api.controller;

import com.romay.youngkwang.api.dto.response.MovieDetailJsonDTO;
import com.romay.youngkwang.api.dto.response.NowPlayingMoviesResponseDTO;
import com.romay.youngkwang.api.service.TmdbService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "외부 API", description = "외부 API 관련 기능입니다.")
public class APIController {

    private final TmdbService tmdbService;

    @GetMapping("/nowPlaying") // 현재 상영작 받아오기
    @Operation(summary = "현재 상영작", description = "현재 상영작 불러오기")
    @ApiResponse(responseCode = "200", description = "성공시 현재 상영작들의 List 를 응답합니다",
            content = @Content(schema = @Schema(implementation = NowPlayingMoviesResponseDTO.class)))
    public ResponseEntity<?> getNowPlaying(int page) {
        List<NowPlayingMoviesResponseDTO> dtoList = tmdbService.getNowPlayingMovies(page);
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/movie/detail")
    @Operation(summary = "영화 상세정보", description = "영화의 상세 정보 조회하기")
    @ApiResponse(responseCode = "200", description = "영화의 상세 정보를 return 해줍니다",
            content = @Content(schema = @Schema(implementation = MovieDetailJsonDTO.class)))
    public ResponseEntity<?> getMovie(@RequestParam("id") int movieCode) {
        MovieDetailJsonDTO movieDetail = tmdbService.getMovieDetail(movieCode);
        return ResponseEntity.ok(movieDetail);
    }

    @GetMapping("/movie/search")
    @Operation(summary = "영화 제목으로검색", description = "영화의 제목으로 검색합니다")
    @ApiResponse(responseCode = "200", description = "제목에 맞는 영화들을 return 해줍니다",
            content = @Content(schema = @Schema(implementation = NowPlayingMoviesResponseDTO.class)))
    public ResponseEntity<?> searchMovieWithTitle(@RequestParam("title") String title) {
        List<NowPlayingMoviesResponseDTO> movieWithTitle = tmdbService.getMovieWithTitle(title);
        return ResponseEntity.ok(movieWithTitle);
    }

}
