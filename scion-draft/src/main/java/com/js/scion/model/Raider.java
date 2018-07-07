/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.scion.model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author jack
 */
public class Raider {
    
    
    @Id
    public String id;
    
    public String name;
    public String clas;
    
    public Raider(){};

    public Raider(String name, String clas) {
        this.name = name;
        this.clas = clas;
    }

    @Override
    public String toString() {
        return "Raider{" + "id=" + id + ", name=" + name + ", clas=" + clas + '}';
    }
    
    
}