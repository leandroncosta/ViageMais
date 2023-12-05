package com.leandro.viagemais.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.entities.Destination;
import com.leandro.viagemais.services.DestinationService;

@RestController
@RequestMapping("/destination")
public class DestinationController {

  private DestinationService destinationService;

  public DestinationController(DestinationService destinationService) {
    this.destinationService = destinationService;
  }

  @GetMapping
  public ResponseEntity<List<Destination>> list() {
    var destinations = destinationService.findAllDestination();

    return ResponseEntity.ok().body(destinations);
  }
}
