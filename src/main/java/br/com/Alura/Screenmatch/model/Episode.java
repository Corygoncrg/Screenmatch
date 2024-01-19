package br.com.Alura.Screenmatch.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer episode;
    private double rating;
    private LocalDate released;

    public Episode(Integer episodes, EpisodeData episodeData) {
        this.season = episodes;
        this.title = episodeData.title();
        this.episode = episodeData.episode();

        try {
            this.rating = Double.valueOf(episodeData.rating());
        } catch (NumberFormatException e) {
            this.rating = 0.0;
        }

        try {
            this.released = LocalDate.parse(episodeData.released());

        } catch (DateTimeParseException e) {
            this.released = null;
        }

    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getReleased() {
        return released;
    }

    @Override
    public String toString() {
        return
                "Season: " + season +
                "\nTitle: " + title +
                "\nEpisode: " + episode +
                "\nRating: " + rating +
                "\nReleased: " + released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }
}
