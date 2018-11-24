package com.js.paradigm.security;

import com.js.paradigm.data.UserAuthRepository;
import com.js.paradigm.model.User;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class ParaUserDetailsService implements UserDetailsService {


    @Autowired
    private UserAuthRepository userauth;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<User> user = userauth.findById(s);
        if (user.isPresent()){
            return new MongoUserDetails(user.get());

        } else {
            return null;
        }
    }
}
