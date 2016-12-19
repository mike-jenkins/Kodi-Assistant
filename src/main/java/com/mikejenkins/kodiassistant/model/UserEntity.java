package com.mikejenkins.kodiassistant.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/15/2016
 * @since 0.1.0
 */
@Entity
@Table(name = "KODI_USER", schema = "PUBLIC", catalog = "KODI")
public class UserEntity {
    private Integer id;
    private String name;
    private Collection<PreferencesEntity> preferences;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public Collection<PreferencesEntity> getPreferences() {
        return preferences;
    }

    public void setPreferences(Collection<PreferencesEntity> preferences) {
        this.preferences = preferences;
    }
}
