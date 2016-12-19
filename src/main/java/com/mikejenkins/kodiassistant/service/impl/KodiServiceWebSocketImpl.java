package com.mikejenkins.kodiassistant.service.impl;

import com.mikejenkins.kodiassistant.model.PlayerEntity;
import com.mikejenkins.kodiassistant.service.kodi.video.Movie;
import com.mikejenkins.kodiassistant.service.KodiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mike Jenkins
 * @version x.x, 12/11/2016
 * @since x.x
 */
public class KodiServiceWebSocketImpl implements KodiService{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    class MyWebsocketHandler implements WebSocketHandler{
        @Override
        public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        }

        @Override
        public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

        }

        @Override
        public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

        }

        @Override
        public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

        }

        @Override
        public boolean supportsPartialMessages() {
            return false;
        }
    }

    @Override
    public List<Movie> getMovies(PlayerEntity player) {
        return null;
    }

    @Override
    public Boolean playMovie(int movieId, PlayerEntity player, boolean resume) {
        List<Transport> transports = new ArrayList<>(2);
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        transports.add(new RestTemplateXhrTransport());

        SockJsClient sockJsClient = new SockJsClient(transports);
        sockJsClient.doHandshake(new MyWebsocketHandler(), "ws://mike-jenkins.com:8088/jsonrpc");

        return null;
    }
}
