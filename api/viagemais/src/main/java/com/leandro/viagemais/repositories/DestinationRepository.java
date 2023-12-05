package com.leandro.viagemais.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.viagemais.entities.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, UUID> {

}
