package com.mikejenkins.kodiassistant.web.controller;

import com.mikejenkins.kodiassistant.business.KodiEngine;
import com.mikejenkins.kodiassistant.model.PlayerEntity;
import com.mikejenkins.kodiassistant.model.PlayerRepository;
import com.mikejenkins.kodiassistant.service.kodi.ApiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/10/2016
 * @since 0.1.0
 */

@RestController
public class KodiController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSendingOperations<String>  messagingTemplate;

    @Autowired
    private KodiEngine kodiEngine;

    @RequestMapping(value = "/doCommand", method = RequestMethod.POST, produces = "application/json")
    public String doCommand(@RequestBody ApiRequest request){
        log.debug("API Request Received");
        messagingTemplate.convertAndSend("/topic/liveQuery", request);

        return kodiEngine.processRequest(request);
    }
}
