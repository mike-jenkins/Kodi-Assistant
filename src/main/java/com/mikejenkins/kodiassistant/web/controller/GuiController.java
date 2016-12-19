package com.mikejenkins.kodiassistant.web.controller;

import com.mikejenkins.kodiassistant.business.GuiDataEngine;
import com.mikejenkins.kodiassistant.model.UserEntity;
import com.mikejenkins.kodiassistant.model.UserRepository;
import com.mikejenkins.kodiassistant.web.model.UserConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class GuiController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GuiDataEngine guiDataEngine;

    @GetMapping("/")
    public ModelAndView getHandler(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("userConfig", new UserConfig());
        mv.addObject("usersSetup", guiDataEngine.doesUserExist());
        mv.addObject("users", guiDataEngine.getUsers());
        mv.addObject("players", guiDataEngine.getPlayers());
        //TODO - Get version from pom
        mv.addObject("version", "ver.0.1.0 (2016-12-18)");

        return mv;
    }

    @PostMapping(value = "/newUserSetup", produces = "application/json")
    public @ResponseBody UserEntity formSubmitHandler(@ModelAttribute UserConfig userConfig){
        return guiDataEngine.setUpNewUser(userConfig);
    }

    @PostMapping("/reset")
    public @ResponseBody Boolean resetApp(){
        try {
            guiDataEngine.resetApp();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
