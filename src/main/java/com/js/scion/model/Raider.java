/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.scion.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

/**
 *
 * @author jack
 */
public class Raider implements Serializable{
    
    
    @Id
    private String id;
    
    private String name;
    private String role;
    private String offRole;
    
    public Raider(){};

    public Raider(String name, String role, String offRole) {
        this.name = name;
        this.role = role;
        this.offRole = offRole;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOffRole() {
        return offRole;
    }

    public void setOffRole(String offRole) {
        this.offRole = offRole;
    }

    @Override
    public String toString() {
        return "Raider{" + "id=" + id + ", name=" + name + ", role=" + role + ", offRole=" + offRole + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}