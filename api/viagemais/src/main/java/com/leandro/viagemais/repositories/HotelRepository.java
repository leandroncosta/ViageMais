package com.leandro.viagemais.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.viagemais.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, UUID> {

}
