package com.leandro.viagemais.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.dto.UserPackageDTO;
import com.leandro.viagemais.dto.UserTicketDTO;
import com.leandro.viagemais.services.UserService;

import jakarta.validation.Valid;

// controller quando usuario compra uma passagem ou pacacote

@RestController
@RequestMapping("/api")
public class BuyController {

  private UserService userService;

  public BuyController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/userpackage")
  public ResponseEntity<String> buyPackage(@RequestBody @Valid UserPackageDTO data) {

    return ResponseEntity.ok().build();
  }

  @PostMapping("/userticket")
  public ResponseEntity<String> buyTicket(@RequestBody @Valid UserTicketDTO data) {
    this.userService.addUserTicket(data);

    return ResponseEntity.ok().build();
  }

}
