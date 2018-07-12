/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.scion.data;

import com.js.scion.model.Raider;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author jack
 */
public interface RaiderRepository extends MongoRepository<Raider, String>{
    
    public Raider findByName(String name);
    public List<Raider> findByRole(String role);
}
