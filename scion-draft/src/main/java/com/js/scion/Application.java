/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.scion;

import com.js.scion.model.Raider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.js.scion.data.RaiderRepository;
import com.js.scion.data.RaiderStatusRepository;
import com.js.scion.model.Boss;
import com.js.scion.model.RaiderStatus;
import com.js.scion.model.SignupStatus;
import com.js.scion.model.Tier;

/**
 *
 * @author jack
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
    
    @Autowired
    private RaiderRepository raiderRepo;
    
    @Autowired
    private RaiderStatusRepository raiderStatusRepo;
    
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
         raiderRepo.deleteAll();
         raiderRepo.save(new Raider("Yherin", "dps", "tank"));
         raiderRepo.save(new Raider("Vala", "healer", "none"));
         Raider r1 = raiderRepo.findByName("Vala");
         Raider r2 = raiderRepo.findByName("Yherin");
         raiderStatusRepo.save(new RaiderStatus(new Boss("Argus", new Tier("tier 14")),r1,new SignupStatus("drafted")));
         raiderStatusRepo.save(new RaiderStatus(new Boss("Argus", new Tier("tier 14")),r2,new SignupStatus("drafted")));

    }
}
