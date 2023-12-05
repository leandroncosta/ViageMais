package com.leandro.viagemais.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.entities.Hotel;
import com.leandro.viagemais.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

  private HotelService hotelService;

  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @GetMapping
  public ResponseEntity<List<Hotel>> list() {
    var hotels = this.hotelService.findAllHotels();

    return ResponseEntity.ok().body(hotels);
  }

}
