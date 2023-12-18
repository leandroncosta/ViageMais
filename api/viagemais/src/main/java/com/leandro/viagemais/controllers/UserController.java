package com.leandro.viagemais.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.entities.user.User;
import com.leandro.viagemais.services.UserService;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/user")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> list() {
    var users = this.userService.findAll();

    return ResponseEntity.ok().body(users);
  }

  @GetMapping("{login}")
  public ResponseEntity<UserDetails> findUser(@PathVariable("login") String login) {
    var user = this.userService.findByLogin(login);

    return ResponseEntity.ok().body(user);
  }

  @GetMapping("/info")
  public ResponseEntity<UserDetails> getUserInfo() {
    var userDetails = this.userService.getUserInfo();

    if (userDetails != null) {
      // Retorna os detalhes do usuário
      return ResponseEntity.ok().body(userDetails);
    } else {
      // Retorna um erro ou uma resposta apropriada se o usuário não estiver
      // autenticado
      return ResponseEntity.status(401).build();
    }
  }
}
