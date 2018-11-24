package com.js.paradigm.security;

import com.js.paradigm.data.UserAuthRepository;
import com.js.paradigm.model.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RootCreator {

    @Autowired
    private UserAuthRepository uar;


    public void createRootInDB(){
        if (!uar.existsById("root")){
            UserRecord admin = new UserRecord();
            String encoded = new BCryptPasswordEncoder().encode("pass");
            admin.setUsername("root");
            admin.setPassword(encoded);
            List<String> auths = new ArrayList<>();
            auths.add("admin");
            admin.setAuths(auths);
            uar.save(admin);
        }

    }

}
