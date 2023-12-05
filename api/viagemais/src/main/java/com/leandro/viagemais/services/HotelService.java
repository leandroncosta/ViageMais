package com.leandro.viagemais.services;

import java.util.List;

import com.leandro.viagemais.entities.Hotel;

public interface HotelService {
  List<Hotel> findAllHotels();
}
