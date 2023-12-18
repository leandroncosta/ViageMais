package com.leandro.viagemais.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.entities.Hotel;
import com.leandro.viagemais.services.HotelService;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("api/hotel")
public class HotelController extends GenericController<Hotel, UUID, HotelService> {

  public HotelController(@Qualifier("hotelService") HotelService service) {
    super(service);

  }

}
