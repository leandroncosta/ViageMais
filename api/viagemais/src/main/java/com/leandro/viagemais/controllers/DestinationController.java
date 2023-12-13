package com.leandro.viagemais.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.dto.DestinationDTO;
import com.leandro.viagemais.entities.Destination;
import com.leandro.viagemais.services.DestinationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/destination")
public class DestinationController {

  private DestinationService destinationService;

  public DestinationController(DestinationService destinationService) {
    this.destinationService = destinationService;
  }

  @GetMapping
  public ResponseEntity<List<Destination>> list() {
    var destinations = destinationService.findAll();

    return ResponseEntity.ok().body(destinations);
  }

  @PostMapping
  public ResponseEntity<String> create(@RequestBody Destination data) {
    // var newDestination = new Destination(data);

    // this.destinationService.save(newDestination);
    this.destinationService.save(data);

    return ResponseEntity.status(201).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Destination> findById(@PathVariable("id") UUID id) {
    var destination = this.destinationService.findById(id);

    if (destination.isPresent()) {
      return ResponseEntity.ok().body(destination.get());
    }

    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@PathVariable("id") UUID id, @RequestBody @Valid DestinationDTO data) {

    return ResponseEntity.ok().build();

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
    this.destinationService.deleteById(id);

    return ResponseEntity.noContent().build();
  }

}
