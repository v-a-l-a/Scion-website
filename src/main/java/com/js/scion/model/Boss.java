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
 * @author sjack
 */
public class Boss implements Serializable{
    
    @Id
    private String id;

    private String name;
    private Tier tier;

    public Boss(String name, Tier tier) {
        this.name = name;
        this.tier = tier;
    }

    public Boss() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }
    
    
    
}
