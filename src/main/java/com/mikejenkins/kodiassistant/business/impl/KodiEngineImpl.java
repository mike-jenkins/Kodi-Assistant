package com.mikejenkins.kodiassistant.business.impl;

import com.mikejenkins.kodiassistant.business.KodiEngine;
import com.mikejenkins.kodiassistant.model.*;
import com.mikejenkins.kodiassistant.service.kodi.ApiRequest;
import com.mikejenkins.kodiassistant.service.kodi.ApiResponse;
import com.mikejenkins.kodiassistant.service.kodi.video.Movie;
import com.mikejenkins.kodiassistant.service.KodiService;
import com.mikejenkins.kodiassistant.service.kodi.video.TVShow;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/9/2016
 * @since 0.1.0
 */
@Component
public class KodiEngineImpl implements KodiEngine {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected KodiService kodiService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    private static UserEntity activeUser;

    private enum MediaType{
        MOVIE,
        TV_SHOW,
        SONG
    }

    // TODO - Change This
    private PlayerEntity getDefaultPlayer(UserEntity user){
        if(user != null){
            for(PreferencesEntity preferencesEntity: user.getPreferences()){
                if(preferencesEntity.getDefaultPlayer() != null){
                    return  preferencesEntity.getDefaultPlayer();
                }
            }
        }
        for(PlayerEntity playerEntity: playerRepository.findAll()){
            return playerEntity;
        }
        return null;
    }

    @PostConstruct
    private void setup(){
        List<UserEntity> users = (List<UserEntity>)userRepository.findAll();
        if(users.size() == 1) {
            activeUser = users.get(0);
        }
    }

    @Override
    public String processRequest(ApiRequest request) {
        switch (request.getIntent()){
            case PLAY_MEDIA:
                MediaType mediaType = MediaType.MOVIE;
                String mediaTitle = request.getParams().getMediaTitle();

                if(!request.getParams().getEpisodeSelect().isEmpty()){
                    mediaType = MediaType.TV_SHOW;
                }
                switch (mediaType){
                    case TV_SHOW:
                        //TODO
                        break;

                    case MOVIE:
                    default:
                        if(!mediaTitle.isEmpty()) {
                            Movie selectedMovie = getMovie(mediaTitle);
                            playMovie(selectedMovie, request.getParams().getStartPoint().equals(ApiRequest.StartPoint.RESUME));

                            ApiResponse response = new ApiResponse("Sure, I'm playing the movie "+ selectedMovie.getLabel(), "Playing movie "+ selectedMovie.getLabel());
                            return response.toJsonString();
                        }
                        break;
                }

            break;
            default:
                // TODO
            break;
        }
        return null;
    }

    protected Boolean playMovie(Movie movie, boolean resume) {
        //TODO - Make player selectable instead of only using default
        log.info("Playing: " + movie.getLabel());
        kodiService.playMovie(movie.getMovieId(), getDefaultPlayer(activeUser), resume);

        return null;
    }

    private Movie getMovie(String movieTitle){
//        PlayerEntity player = playerRepository.findOne(1);
        List<Movie> movieList = kodiService.getMovies(getDefaultPlayer(activeUser));

        int closestDistance = -1;
        Movie closestMatch = null;

        for (Movie movie: movieList) {
            int distance = StringUtils.getLevenshteinDistance(movieTitle.toLowerCase(), movie.getLabel().toLowerCase());
            if(closestDistance < 0 || distance < closestDistance){
                closestDistance = distance;
                closestMatch = movie;
            }
        }
        if(closestMatch != null) {
            log.info("Closest Match: " + closestMatch.getLabel() + " (score:" + closestDistance + ")");
        }
        return closestMatch;
    }

    //TODO
   /* private TVShow getTVShow(){
        List<TVShow> movieList = kodiService.getTVShows(getDefaultPlayer(activeUser));

        int closestDistance = -1;
        Movie closestMatch = null;

        for (TVShow movie: movieList) {
            int distance = StringUtils.getLevenshteinDistance(movieTitle.toLowerCase(), movie.getLabel().toLowerCase());
            if(closestDistance < 0 || distance < closestDistance){
                closestDistance = distance;
                closestMatch = movie;
            }
        }
        log.info("Closest Match: " + closestMatch.getLabel() + " (score:" + closestDistance + ")");
        return closestMatch;
    }*/

    protected void getMovieList() {
        PlayerEntity player = playerRepository.findOne(1);
        List<Movie> movieList = kodiService.getMovies(player);
        for (Movie movie: movieList) {
            log.info(movie.toString());
        }
    }
}
