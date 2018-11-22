/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.paradigm.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

/**
 *
 * @author sjack
 */
public class RaiderStatus implements Serializable{
    
    @Id
    private String id;
    
    private Boss boss;
    private Raider raider;
    private SignupStatus signUp;

    public RaiderStatus(Boss boss, Raider raider, SignupStatus signUp) {
        this.boss = boss;
        this.raider = raider;
        this.signUp = signUp;
    }

    public RaiderStatus() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public Raider getRaider() {
        return raider;
    }

    public void setRaider(Raider raider) {
        this.raider = raider;
    }

    public SignupStatus getSignUp() {
        return signUp;
    }

    public void setSignUp(SignupStatus signUp) {
        this.signUp = signUp;
    }
    
    
    
}
