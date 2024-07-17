package com.romay.youngkwang.api.service;

import com.romay.youngkwang.api.dto.response.MovieDetailJsonDTO;
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

    public List<NowPlayingMoviesResponseDTO> getNowPlayingMovies(int page) {
        String endPoint = "/movie/now_playing";

        String url = UriComponentsBuilder.fromUriString(endPoint)
                        .queryParam("language","ko-KO")
                        .queryParam("region","KR")
                        .queryParam("page",page)
                        .toUriString();

        NowPlayingJsonDTO response = restTemplate.getForObject(url, NowPlayingJsonDTO.class);

        return response.getResults().stream().map(entity->
                NowPlayingMoviesResponseDTO.builder()
                        .tmdbMovieCode(entity.getId())
                        .movieTitle(entity.getTitle())
                        .movieSynopsis(entity.getOverview())
                        .movieReleaseDate(entity.getReleaseDate())
                        .moviePosterUrl("https://image.tmdb.org/t/p/original/" + entity.getPosterPath())
                        .build()
                ).toList();
    }

    public MovieDetailJsonDTO getMovieDetail(int movieCode) {
        String endPoint = "/movie/"+ movieCode;
        String url = UriComponentsBuilder.fromUriString(endPoint)
                .queryParam("language","ko-KO")
                .toUriString();

        MovieDetailJsonDTO response = restTemplate.getForObject(url, MovieDetailJsonDTO.class);

        return response;
    }

    public List<NowPlayingMoviesResponseDTO> getMovieWithTitle(String title) {
        String endPoint = "/search/movie";
        String url = UriComponentsBuilder.fromUriString(endPoint)
                .queryParam("language", "ko-KO")
                .queryParam("query",title)
                .toUriString();

        NowPlayingJsonDTO response = restTemplate.getForObject(url, NowPlayingJsonDTO.class);

        return response.getResults().stream().map(entity->
                NowPlayingMoviesResponseDTO.builder()
                        .tmdbMovieCode(entity.getId())
                        .movieTitle(entity.getTitle())
                        .movieSynopsis(entity.getOverview())
                        .movieReleaseDate(entity.getReleaseDate())
                        .moviePosterUrl("https://image.tmdb.org/t/p/original/" + entity.getPosterPath())
                        .build())
                .toList();

    }
}
