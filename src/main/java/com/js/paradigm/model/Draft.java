/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.paradigm.model;

import java.util.List;
import org.springframework.data.annotation.Id;

/**
 *
 * @author sjack
 */
public class Draft {
    
    @Id
    private String id;
    
    private List<RaiderStatus> raiderStatuses;

    public Draft(List<RaiderStatus> raiderStatuses) {
        this.raiderStatuses = raiderStatuses;
    }

    public Draft() {
    }

    public List<RaiderStatus> getRaiderStatuses() {
        return raiderStatuses;
    }

    public void setRaiderStatuses(List<RaiderStatus> raiderStatuses) {
        this.raiderStatuses = raiderStatuses;
    }

    public String getId() {
        return id;
    }
    
    
    
    
}
