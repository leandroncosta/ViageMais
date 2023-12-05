package com.leandro.viagemais.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leandro.viagemais.entities.Destination;
import com.leandro.viagemais.repositories.DestinationRepository;
import com.leandro.viagemais.services.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService {

  private DestinationRepository destinationRepository;

  public DestinationServiceImpl(DestinationRepository destinationRepository) {
    this.destinationRepository = destinationRepository;
  }

  @Override
  public List<Destination> findAllDestination() {
    var destinations = this.destinationRepository.findAll();
    return destinations;
  }

}
