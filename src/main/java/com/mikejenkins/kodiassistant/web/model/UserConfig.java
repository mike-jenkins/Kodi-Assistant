package com.mikejenkins.kodiassistant.web.model;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/16/2016
 * @since 0.1.0
 */
public class UserConfig {
    protected Integer userId;
    protected String userName;

    protected Integer kodiId;
    protected String kodiName;
    protected String url;
    protected Integer port;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getKodiId() {
        return kodiId;
    }

    public void setKodiId(Integer kodiId) {
        this.kodiId = kodiId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKodiName() {
        return kodiName;
    }

    public void setKodiName(String kodiName) {
        this.kodiName = kodiName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
