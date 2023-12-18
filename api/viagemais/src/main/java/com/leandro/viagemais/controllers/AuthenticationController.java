package com.leandro.viagemais.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.config.TokenService;
import com.leandro.viagemais.entities.user.AuthenticationDTO;
import com.leandro.viagemais.entities.user.LoginResponseDTO;
import com.leandro.viagemais.entities.user.RegisterDTO;
import com.leandro.viagemais.entities.user.User;
import com.leandro.viagemais.repositories.UserRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
    var userNamePass = new UsernamePasswordAuthenticationToken(data.login(), data.password());
    var auth = this.authenticationManager.authenticate(userNamePass);

    var token = tokenService.GenerateToken((User) auth.getPrincipal());
    var response = new LoginResponseDTO(token);

    return ResponseEntity.ok(response);
  }

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data) {
    if (this.userRepository.findByLogin(data.login()) != null) {
      return ResponseEntity.badRequest().body("Usuário já existe");
    }

    String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
    User newUser = new User(data.login(), encryptedPassword, data.role());

    this.userRepository.save(newUser);

    return ResponseEntity.status(201).build();
  }
}
