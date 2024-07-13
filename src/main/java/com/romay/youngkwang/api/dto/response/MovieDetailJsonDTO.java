package com.romay.youngkwang.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"adult","backdrop_path","belongs_to_collection","budget","genres","homepage","imdb_id","origin_country"
,"original_language","original_title","popularity","production_companies","production_countries","revenue","spoken_languages","status",
"tagline","video","vote_average","vote_count"})
public class MovieDetailJsonDTO {
    private String id;
    private String overview;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("release_date")
    private String releaseDate;
    private String runtime;
    private String title;
}
