package com.leandro.viagemais.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.viagemais.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {

}
