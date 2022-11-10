package com.lwl.cbook.service;

import com.lwl.cbook.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppUserService implements UserDetailsService {

  @Autowired
  private UserInitService userInitService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userInitService.getUsersMap().get(username);
        if(appUser!=null){
            return User.builder().username(appUser.getUsername()).password(appUser.getPassword()).authorities(Collections.emptyList()).build();
        }
        throw new UsernameNotFoundException("Username or password is wrong");
  }
}
