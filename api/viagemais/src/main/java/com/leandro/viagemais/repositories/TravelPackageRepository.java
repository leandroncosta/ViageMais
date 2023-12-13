package com.leandro.viagemais.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.viagemais.entities.TravelPackage;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, UUID> {

}
