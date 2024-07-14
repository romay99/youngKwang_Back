package com.romay.youngkwang.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@JsonIgnoreProperties({"dates","page","total_pages","total_results"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class NowPlayingJsonDTO {

    private List<Movie> results;

    @Getter
    @Setter
    public static class Movie {
        private boolean adult;
        @JsonProperty("backdrop_path")
        private String backdropPath;
        @JsonProperty("genre_ids")
        private List<Integer> genreIds;
        private int id;
        @JsonProperty("original_language")
        private String originalLanguage;
        @JsonProperty("original_title")
        private String originalTitle;
        private String overview;
        private double popularity;
        @JsonProperty("poster_path")
        private String posterPath;
        @JsonProperty("release_date")
        private String releaseDate;
        private String title;
        private boolean video;
        @JsonProperty("vote_average")
        private double voteAverage;
        @JsonProperty("vote_count")
        private int voteCount;
    }

}
