package com.web2project.supermarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web2project.supermarket.DTO.loginDTO;
import com.web2project.supermarket.DTO.registerDTO;
import com.web2project.supermarket.Usuarios.UserEntity;
import com.web2project.supermarket.Usuarios.UserRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid loginDTO loginDTO){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.login(), loginDTO.password());
        var auth = authenticationManager.authenticate(authenticationToken);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid registerDTO registerDTO){
        
        if(this.userRepository.findByLogin(registerDTO.login()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        UserEntity user = new UserEntity(registerDTO.login(), encryptedPassword, registerDTO.role()); 

        userRepository.save(user);

        return ResponseEntity.ok().build();
    }
    
    
}
