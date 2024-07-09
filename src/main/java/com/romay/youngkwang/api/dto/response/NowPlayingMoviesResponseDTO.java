package com.romay.youngkwang.api.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NowPlayingMoviesResponseDTO {
    private int tmdbMovieCode;
    private String movieTitle;
    private String movieSynopsis;
    private String movieReleaseDate;
    private String moviePosterUrl;
}
