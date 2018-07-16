/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.scion.data;

import com.js.scion.model.Boss;
import com.js.scion.model.Raider;
import com.js.scion.model.RaiderStatus;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author sjack
 */
public interface RaiderStatusRepository extends MongoRepository<RaiderStatus, String> {

    public List<RaiderStatus> findByRaider(Raider raider);
    public List<RaiderStatus> findByBoss(Boss boss);
    public RaiderStatus findByBossAndRaider(Boss boss, Raider raider);
    
}
