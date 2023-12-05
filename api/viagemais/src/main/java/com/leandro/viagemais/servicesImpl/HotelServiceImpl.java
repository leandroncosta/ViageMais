package com.leandro.viagemais.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leandro.viagemais.entities.Hotel;
import com.leandro.viagemais.repositories.HotelRepository;
import com.leandro.viagemais.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

  private HotelRepository hotelRepository;

  public HotelServiceImpl(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  @Override
  public List<Hotel> findAllHotels() {
    var hotels = hotelRepository.findAll();
    return hotels;
  }

}
