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

import com.leandro.viagemais.dto.TravelPackageDTO;
import com.leandro.viagemais.entities.Hotel;
import com.leandro.viagemais.entities.TravelPackage;
import com.leandro.viagemais.services.TravelPackageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/packages")
public class TravelPackageController {

  private TravelPackageService travelPackageService;

  public TravelPackageController(TravelPackageService travelPackageService) {
    this.travelPackageService = travelPackageService;
  }

  @GetMapping
  public ResponseEntity<List<TravelPackage>> list() {
    var packages = this.travelPackageService.findAll();

    return ResponseEntity.ok().body(packages);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TravelPackage> findById(@PathVariable("id") UUID id) {
    var packages = this.travelPackageService.findById(id);

    if (packages.isPresent()) {
      return ResponseEntity.ok().body(packages.get());
    }

    return ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity<String> create(@RequestBody @Valid TravelPackageDTO data) {

    var newPackage = new TravelPackage(data);

    this.travelPackageService.save(newPackage);

    return ResponseEntity.status(201).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@PathVariable("id") UUID id, @RequestBody @Valid Hotel data) {

    return ResponseEntity.ok().build();

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
    this.travelPackageService.deleteById(id);

    return ResponseEntity.noContent().build();
  }

}
