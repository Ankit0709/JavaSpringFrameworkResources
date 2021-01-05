package com.springsecurity.learning.SpringSecurityLearning.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandonUserDetailsService  implements UserDetailsService {

    private  UserRepository userRepository;
    private AuthRepository authRepository;

    LandonUserDetailsService(UserRepository userRepository, AuthRepository authRepository){
        super();
        this.userRepository = userRepository;
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user ==  null){
            throw new UsernameNotFoundException("Cannot Find User!");
        }
        List<AuthGroup> authGroups = authRepository.findByUsername(username);
        return new LandonUserPrincipal(user,authGroups);
    }
}
