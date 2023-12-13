package com.leandro.viagemais.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leandro.viagemais.entities.TravelPackage;
import com.leandro.viagemais.repositories.TravelPackageRepository;
import com.leandro.viagemais.servicesImpl.ServiceImplGeneric;

@Service
public class TravelPackageService extends ServiceImplGeneric<TravelPackage, UUID, TravelPackageRepository> {

  public TravelPackageService(@Qualifier("travelPackageRepository") TravelPackageRepository repository) {
    super(repository);

  }

}
