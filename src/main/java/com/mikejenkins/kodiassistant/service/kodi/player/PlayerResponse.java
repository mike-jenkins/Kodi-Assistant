package com.mikejenkins.kodiassistant.service.kodi.player;

import com.mikejenkins.kodiassistant.service.kodi.KodiResponse;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/10/2016
 * @since 0.1.0
 */
public class PlayerResponse extends KodiResponse{
    String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
