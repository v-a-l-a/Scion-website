package com.js.paradigm;

import com.js.paradigm.security.RootCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {

    @Autowired
    RootCreator rc;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void makeRootInDB(){
        rc.createRootInDB();
    }



}
