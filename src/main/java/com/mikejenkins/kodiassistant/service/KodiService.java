package com.mikejenkins.kodiassistant.service;

import com.mikejenkins.kodiassistant.model.PlayerEntity;
import com.mikejenkins.kodiassistant.service.kodi.video.Movie;

import java.util.List;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/9/2016
 * @since 0.1.0
 */
public interface KodiService {
    List<Movie> getMovies(PlayerEntity player);

    Boolean playMovie(int movieId, PlayerEntity player, boolean resume);
}
