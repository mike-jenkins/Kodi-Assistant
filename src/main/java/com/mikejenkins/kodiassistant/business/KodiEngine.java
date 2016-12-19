package com.mikejenkins.kodiassistant.business;

import com.mikejenkins.kodiassistant.service.kodi.ApiRequest;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/9/2016
 * @since 0.1.0
 */
public interface KodiEngine {
    String processRequest(ApiRequest request);
}
