/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.scion.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sjack
 */
public class RaiderList implements Serializable{
    
    List<Raider> raiders;

    public RaiderList(List<Raider> raiders) {
        this.raiders = raiders;
    }

    public RaiderList() {
    }

    public List<Raider> getRaiders() {
        return raiders;
    }

    public void setRaiders(List<Raider> raiders) {
        this.raiders = raiders;
    }
    
    
    
}
