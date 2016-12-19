package com.mikejenkins.kodiassistant.model;

import javax.persistence.*;

/**
 * @author Mike Jenkins
 * @version x.x, 12/15/2016
 * @since x.x
 */
@Entity
@Table(name = "USER_PREFERENCES", schema = "PUBLIC", catalog = "KODI")
public class PreferencesEntity {
    private Integer id;
    private UserEntity user;
    private PlayerEntity defaultPlayer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreferencesEntity that = (PreferencesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "DEFAULT_PLAYER_ID", referencedColumnName = "ID")
    public PlayerEntity getDefaultPlayer() {
        return defaultPlayer;
    }

    public void setDefaultPlayer(PlayerEntity defaultPlayer) {
        this.defaultPlayer = defaultPlayer;
    }
}
