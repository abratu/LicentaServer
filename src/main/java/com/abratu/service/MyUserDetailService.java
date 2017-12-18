package com.abratu.service;

import com.abratu.entities.User;
import com.abratu.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyUserDetailService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(userName);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        logger.info(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleName());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), Arrays.asList(authority));
    }
}
