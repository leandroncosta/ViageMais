package com.leandro.viagemais.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leandro.viagemais.entities.Hotel;
import com.leandro.viagemais.repositories.HotelRepository;
import com.leandro.viagemais.servicesImpl.ServiceImplGeneric;

@Service
public class HotelService extends ServiceImplGeneric<Hotel, UUID, HotelRepository> {

  public HotelService(@Qualifier("hotelRepository") HotelRepository repository) {
    super(repository);

  }

}
