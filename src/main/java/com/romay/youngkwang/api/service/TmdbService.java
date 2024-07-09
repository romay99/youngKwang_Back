package com.romay.youngkwang.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.romay.youngkwang.api.dto.response.NowPlayingJsonDTO;
import com.romay.youngkwang.api.dto.response.NowPlayingMoviesResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TmdbService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public List<NowPlayingMoviesResponseDTO> nowPlaying(int page) {
        String endPoint = "/movie/now_playing";

        String url = UriComponentsBuilder.fromUriString(endPoint)
                        .queryParam("language","ko-KO")
                        .queryParam("region","KR")
                        .queryParam("page",page)
                        .toUriString();

        String response = restTemplate.getForObject(url, String.class);
        try {
            NowPlayingJsonDTO movieDetailDTO = objectMapper.readValue(response, NowPlayingJsonDTO.class);

            return movieDetailDTO.getResults().stream().map(entity->
                    NowPlayingMoviesResponseDTO.builder()
                            .tmdbMovieCode(entity.getId())
                            .movieTitle(entity.getTitle())
                            .movieSynopsis(entity.getOverview())
                            .movieReleaseDate(entity.getReleaseDate())
                            .moviePosterUrl("https://image.tmdb.org/t/p/original/" + entity.getPosterPath())
                            .build()
                    ).toList();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
