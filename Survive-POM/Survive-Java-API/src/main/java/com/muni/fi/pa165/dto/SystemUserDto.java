package com.muni.fi.pa165.dto;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Data transfer object for the {@link Systemuser}.
 * 
 * @author irina
 */
@XmlRootElement
public class SystemUserDto {

    private Long id;
    private String username;
    private String password;
    private Integer accessLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof SystemUserDto)) {
            return false;
        }
        SystemUserDto other = (SystemUserDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
