package com.mikejenkins.kodiassistant.service.kodi.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mikejenkins.kodiassistant.service.kodi.item.Base;

/**
 * @author Mike Jenkins
 * @version x.x, 12/9/2016
 * @since x.x
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie extends Base {
    @JsonProperty(value = "movieid")
    protected Integer movieId;
    @JsonProperty(value = "sorttitle")
    protected String sortTitle;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getSortTitle() {
        return sortTitle;
    }

    public void setSortTitle(String sortTitle) {
        this.sortTitle = sortTitle;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", label='" + label + '\'' +
                '}';
    }
}
