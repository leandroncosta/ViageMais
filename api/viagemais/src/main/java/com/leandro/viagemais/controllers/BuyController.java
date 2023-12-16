package com.leandro.viagemais.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.dto.BuyPackageDTO;
import com.leandro.viagemais.entities.BuyPackage;
import com.leandro.viagemais.entities.BuyTicket;
import com.leandro.viagemais.dto.BuyTicketDTO;

import com.leandro.viagemais.services.BuyPackageService;
import com.leandro.viagemais.services.BuyTicketService;

import jakarta.validation.Valid;

// controller quando usuario compra uma passagem ou pacacote

@RestController
@RequestMapping("/api/buy")
public class BuyController {

  private BuyTicketService buyTicketService;
  private BuyPackageService buyPackageService;

  public BuyController(BuyTicketService buyTicketService, BuyPackageService buyPackageService) {
    this.buyPackageService = buyPackageService;
    this.buyTicketService = buyTicketService;
  }

  @GetMapping("/ticket")
  public ResponseEntity<List<BuyTicket>> list() {
    var objects = this.buyTicketService.findAll();

    return ResponseEntity.ok().body(objects);
  }

  @PostMapping("/ticket")
  public ResponseEntity<String> buyTicket(@RequestBody @Valid BuyTicketDTO data) {

    try {

      this.buyTicketService.saveTicket(data);

      return ResponseEntity.status(201).build();

    } catch (RuntimeException e) {
      return ResponseEntity.status(404).body(e.getMessage().toString());
    }

  }

  @GetMapping(("/package"))
  public ResponseEntity<List<BuyPackage>> listBuyPackages() {

    var buyPackages = this.buyPackageService.findAll();

    return ResponseEntity.ok().body(buyPackages);
  }

  @PostMapping("/package")
  public ResponseEntity<String> buyPackage(@RequestBody @Valid BuyPackageDTO data) {

    this.buyPackageService.saveBuyPackage(data);

    return ResponseEntity.ok().build();
  }

}
