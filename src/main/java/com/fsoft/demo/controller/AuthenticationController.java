package com.fsoft.demo.controller;

import com.fsoft.demo.config.JwtTokenUtil;
import com.fsoft.demo.dto.LoginDTO;
import com.fsoft.demo.entity.Account;
import com.fsoft.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private AccountRepository accountRepository;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, AccountRepository accountRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> getToken(@RequestBody LoginDTO loginDTO) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final Account account = accountRepository.findByUsername(loginDTO.getUsername());
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(token);
    }
}
