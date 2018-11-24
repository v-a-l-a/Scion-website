package com.js.paradigm.security;

import com.js.paradigm.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MongoUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private List<GrantedAuthority> auths;


    public MongoUserDetails(final User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        String[] auths = (String[]) user.getAuths().toArray();
        this.auths = AuthorityUtils.createAuthorityList(auths);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return auths;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
