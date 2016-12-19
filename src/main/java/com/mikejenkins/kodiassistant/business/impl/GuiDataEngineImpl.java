package com.mikejenkins.kodiassistant.business.impl;

import com.mikejenkins.kodiassistant.business.GuiDataEngine;
import com.mikejenkins.kodiassistant.model.*;
import com.mikejenkins.kodiassistant.web.model.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author Mike Jenkins
 * @version x.x, 12/16/2016
 * @since x.x
 */
@Component
public class GuiDataEngineImpl implements GuiDataEngine{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PreferencesRepository preferencesRepository;

    @Override
    public boolean doesUserExist() {
        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();
        return userEntities.size() > 0;
    }

    @Override
    public UserEntity setUpNewUser(UserConfig userConfig) {

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(userConfig.getKodiName());
        playerEntity.setUrl(userConfig.getUrl());
        playerEntity.setPort(userConfig.getPort());

        playerEntity = playerRepository.save(playerEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userConfig.getUserName());

        userEntity = userRepository.save(userEntity);

        PreferencesEntity preferencesEntity = new PreferencesEntity();
        preferencesEntity.setDefaultPlayer(playerEntity);
        preferencesEntity.setUser(userEntity);

        preferencesRepository.save(preferencesEntity);

        return userEntity;

    }

    @Override
    public UserEntity updateUserConfig(UserConfig userConfig) {
        UserEntity userEntity = null;
        try{
            userEntity = userRepository.findOne(userConfig.getUserId());
        } catch (Exception e){}

        if(userEntity == null){
            userEntity = new UserEntity();
        }
        userEntity.setName(userConfig.getUserName());

        return userRepository.save(userEntity);
    }

    @Override
    public void resetApp() {
        preferencesRepository.deleteAll();
        playerRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public List<PlayerEntity> getPlayers() {
        return (List<PlayerEntity>) playerRepository.findAll();
    }
}
