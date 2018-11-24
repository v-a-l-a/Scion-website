package com.js.paradigm.security;

import com.js.paradigm.data.UserAuthRepository;
import com.js.paradigm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Protocol;

import java.util.ArrayList;
import java.util.List;

@Component
public class RootCreator {

    @Autowired
    private UserAuthRepository uar;


    public void createRootInDB(){
        if (!uar.existsById("root")){
            User admin = new User();
            admin.setPassword("pass");
            admin.setUsername("root");
            List<String> auths = new ArrayList<>();
            auths.add("admin");
            admin.setAuths(auths);
            uar.save(admin);
        }

    }

}
