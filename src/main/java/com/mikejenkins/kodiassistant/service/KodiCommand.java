package com.mikejenkins.kodiassistant.service;

/**
 * @author Mike Jenkins
 * @version x.x, 12/8/2016
 * @since x.x
 */
public interface KodiCommand {
    String PLAYER_GetActivePlayers = "GetActivePlayers";
    String PLAYER_GetItem = "GetItem";
    String PLAYER_GetProperties = "GetProperties";
    String PLAYER_GoTo = "GoTo";
    String PLAYER_Move = "Move";
    String PLAYER_Open = "Open";
    String PLAYER_PlayPause = "PlayPause";
    String PLAYER_Rotate = "Rotate";
    String PLAYER_Seek = "Seek";
    String PLAYER_SetAudioStream = "SetAudioStream";
    String PLAYER_SetPartymode = "SetPartymode";
    String PLAYER_SetRepeat = "SetRepeat";
    String PLAYER_SetShuffle = "SetShuffle";
    String PLAYER_SetSpeed = "SetSpeed";
    String PLAYER_SetSubtitle = "SetSubtitle";
    String PLAYER_Stop = "Stop";
    String PLAYER_Zoom = "Zoom";

    String VIDEO_LIBRARY_GetMovies = "GetMovies";

    String MY_COMMANDS_PlayMovie = "PlayMovie";
}
