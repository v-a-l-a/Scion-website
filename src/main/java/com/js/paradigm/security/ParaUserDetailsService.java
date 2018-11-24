package com.js.paradigm.security;

import com.js.paradigm.data.UserAuthRepository;
import com.js.paradigm.model.UserRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParaUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(ParaUserDetailsService.class);

    @Autowired
    private UserAuthRepository userauth;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("Fetching record for userRecord " + s);
        Optional<UserRecord> userRecordOptional = userauth.findById(s);
        if (userRecordOptional.isPresent()){
            UserRecord userRecord = userRecordOptional.get();
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            for (String cs : userRecord.getAuths()){
                grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_"+cs));
            }

            User user = new User(userRecord.getUsername(),userRecord.getPassword(), grantedAuthorityList );
           return user;

        } else {
            return null;
        }
    }
}
