package com.js.paradigm.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    @Id
    private String username;

    private String password;
    private List<String> auths;

    public void setAuths(List<String> auths) {
        this.auths = auths;
    }

    public List<String> getAuths() {
        return auths;
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
}
