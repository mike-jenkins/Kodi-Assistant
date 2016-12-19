package com.mikejenkins.kodiassistant.service.impl;

import com.mikejenkins.kodiassistant.model.PlayerEntity;
import com.mikejenkins.kodiassistant.model.PlayerRepository;
import com.mikejenkins.kodiassistant.model.UserEntity;
import com.mikejenkins.kodiassistant.service.kodi.player.PlayerResponse;
import com.mikejenkins.kodiassistant.service.kodi.video.GetMoviesResponse;
import com.mikejenkins.kodiassistant.service.kodi.video.Movie;
import com.mikejenkins.kodiassistant.service.KodiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/9/2016
 * @since 0.1.0
 */
@Service(value = "kodiService")
public class KodiServiceImpl implements KodiService{
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Movie> getMovies(PlayerEntity player) {
        String req = "{\"jsonrpc\": \"2.0\", \"id\": 1, \"method\": \"VideoLibrary.GetMovies\"}";
        String url = player.getUrl() + ":" + player.getPort() +"/jsonrpc?request={req}";

        ResponseEntity<GetMoviesResponse> responseEntity = restTemplate.getForEntity(url, GetMoviesResponse.class, req);

        GetMoviesResponse response = responseEntity.getBody();

        return response.getResult().getMovies();
    }

    @Override
    public Boolean playMovie(int movieId, PlayerEntity player, boolean resume) {
        String req = "{\"jsonrpc\": \"2.0\", \"id\": 1, \"method\": \"Player.Open\", \"params\": {\"item\": {\"movieid\":" + movieId + " }, \"options\": {\"resume\": " + resume +"} }}";
        String url = "http://mike-jenkins.com:8088/jsonrpc?request={req}";

        ResponseEntity<PlayerResponse> responseEntity = restTemplate.getForEntity(url, PlayerResponse.class, req);
        PlayerResponse response = responseEntity.getBody();


        return response.getResult().compareToIgnoreCase("ok") == 0;
    }
}
