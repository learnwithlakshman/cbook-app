package com.lwl.cbook.service;

import com.lwl.cbook.domain.AppUser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Data
@Slf4j
public class UserInitService {
  @Autowired
  private PasswordEncoder passwordEncoder;
  private Map<String, AppUser> usersMap=new HashMap<>();


  @PostConstruct
  public void init(){
    String password = passwordEncoder.encode("krish@123");
    log.info("Password:{}",password);
    usersMap.put("krish", AppUser.builder().username("krish").password(password).build());

  }

}
