package com.mikejenkins.kodiassistant.service.kodi.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mikejenkins.kodiassistant.service.kodi.KodiResponse;

import java.util.List;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/9/2016
 * @since 0.1.0
 */
public class GetMoviesResponse extends KodiResponse {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Result {
        protected List<Movie> movies;

        public Result() {
        }

        public List<Movie> getMovies() {
            return movies;
        }

        public void setMovies(List<Movie> movies) {
            this.movies = movies;
        }
    }
    protected Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
