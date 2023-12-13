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

import com.leandro.viagemais.entities.Hotel;
import com.leandro.viagemais.services.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/hotel")
public class HotelController {

  private HotelService hotelService;

  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @GetMapping
  public ResponseEntity<List<Hotel>> list() {
    var hotels = this.hotelService.findAll();

    return ResponseEntity.ok().body(hotels);
  }

  @PostMapping
  public ResponseEntity<String> create(@RequestBody @Valid Hotel data) {

    this.hotelService.save(data);

    return ResponseEntity.status(201).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Hotel> findById(@PathVariable("id") UUID id) {
    var hotel = this.hotelService.findById(id);

    if (hotel.isPresent()) {
      return ResponseEntity.ok().body(hotel.get());
    }

    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@PathVariable("id") UUID id, @RequestBody @Valid Hotel data) {

    return ResponseEntity.ok().build();

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
    this.hotelService.deleteById(id);

    return ResponseEntity.noContent().build();
  }

}
