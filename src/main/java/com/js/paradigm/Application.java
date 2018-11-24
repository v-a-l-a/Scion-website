package com.js.paradigm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.js.paradigm.data.UserAuthRepository;
import com.js.paradigm.model.User;
import com.js.paradigm.security.RootCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
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
