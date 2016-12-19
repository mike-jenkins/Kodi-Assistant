package com.mikejenkins.kodiassistant.business;

import com.mikejenkins.kodiassistant.model.PlayerEntity;
import com.mikejenkins.kodiassistant.model.UserEntity;
import com.mikejenkins.kodiassistant.web.model.UserConfig;

import java.util.List;

/**
 * @author Mike Jenkins
 * @version x.x, 12/16/2016
 * @since x.x
 */
public interface GuiDataEngine {
    boolean doesUserExist();

    UserEntity setUpNewUser(UserConfig userConfig);

    UserEntity updateUserConfig(UserConfig userConfig);

    void resetApp();

    List<UserEntity> getUsers();

    List<PlayerEntity> getPlayers();
}
