package com.leandro.viagemais.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leandro.viagemais.entities.Destination;
import com.leandro.viagemais.repositories.DestinationRepository;
import com.leandro.viagemais.servicesImpl.ServiceImplGeneric;

@Service
public class DestinationService extends ServiceImplGeneric<Destination, UUID, DestinationRepository> {

  public DestinationService(@Qualifier("destinationRepository") DestinationRepository repository) {
    super(repository);
  }

}
