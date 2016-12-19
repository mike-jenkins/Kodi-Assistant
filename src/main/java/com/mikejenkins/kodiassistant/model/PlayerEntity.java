package com.mikejenkins.kodiassistant.model;

import javax.persistence.*;

/**
 * @author Mike Jenkins
 * @version x.x, 12/15/2016
 * @since x.x
 */
@Entity
@Table(name = "PLAYER", schema = "PUBLIC", catalog = "KODI")
public class PlayerEntity {
    private Integer id;
    private String name;
    private String url;
    private Integer port;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "URL", nullable = false, length = 200)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "PORT", nullable = false)
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerEntity entity = (PlayerEntity) o;

        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (name != null ? !name.equals(entity.name) : entity.name != null) return false;
        if (url != null ? !url.equals(entity.url) : entity.url != null) return false;
        if (port != null ? !port.equals(entity.port) : entity.port != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        return result;
    }
}
