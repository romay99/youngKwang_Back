package com.romay.youngkwang.movie.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    private Long MovieCode;
    @Column
    private String movieTitle;
    @Column
    private String movieSynopsis;
    @Column
    private LocalDate movieReleaseDate;
    @Column
    private String moviePosterUrl;
}
