/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.scion.model;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author jack
 */
public interface RaiderRepository extends MongoRepository<Raider, String>{
    
    public Raider findByName(String name);
    public List<Raider> findByClass(String clas);
}
