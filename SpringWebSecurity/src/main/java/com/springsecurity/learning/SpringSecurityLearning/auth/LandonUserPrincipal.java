package com.springsecurity.learning.SpringSecurityLearning.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class LandonUserPrincipal implements UserDetails {

    private User user;
    private List<AuthGroup> authGroups;

    LandonUserPrincipal(User user,List<AuthGroup> authGroups){
        super();
        this.user = user;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authGroups == null){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
        authGroups.forEach(authGroup ->{
             authoritySet.add(new SimpleGrantedAuthority(authGroup.getAuthGroup()));
        });
        return authoritySet;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
