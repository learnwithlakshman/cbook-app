package com.lwl.cbook.controller;

import com.lwl.cbook.config.JwtTokenUtil;
import com.lwl.cbook.domain.AppUser;
import com.lwl.cbook.dto.TokenResponseDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody AppUser appUser){
        log.info("Login user :{}",appUser);
        authenticate(appUser.getUsername(), appUser.getPassword());
        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(appUser.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new TokenResponseDto(token));
    }

    @SneakyThrows
    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (Exception e) {
            log.info("Error {}",e);
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
