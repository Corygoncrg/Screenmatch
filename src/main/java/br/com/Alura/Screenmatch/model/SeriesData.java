package br.com.Alura.Screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(@JsonAlias ("Title") String title,
                         @JsonAlias("totalSeaons") Integer totalSeasons,
                         @JsonAlias("imdbRating") String rating) {
}
