package com.mikejenkins.kodiassistant.service.kodi;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/9/2016
 * @since 0.1.0
 */
public abstract class KodiResponse {
    protected Integer id;
    protected String jsonrpc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }
}
