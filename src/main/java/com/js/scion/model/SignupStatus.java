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
public class SignupStatus implements Serializable{
    
    @Id
    private String id;
    
    private String status;

    public SignupStatus() {
    }

    public SignupStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
