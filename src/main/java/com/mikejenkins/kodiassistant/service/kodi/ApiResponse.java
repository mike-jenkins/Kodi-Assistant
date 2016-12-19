package com.mikejenkins.kodiassistant.service.kodi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * @author Mike Jenkins
 * @version x.x, 12/10/2016
 * @since x.x
 */
public class ApiResponse {

    protected String speech;
    protected String displayText;
    protected String source;

    public ApiResponse(String speech, String displayText) {
        this.speech = speech;
        this.displayText = displayText;
        this.source = "kodi assistant";
    }

    public String getSpeech() {
        return speech;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getSource() {
        return source;
    }

    public String toJsonString(){
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return objectWriter.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
