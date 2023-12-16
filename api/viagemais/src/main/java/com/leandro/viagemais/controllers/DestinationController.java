package com.leandro.viagemais.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.entities.Destination;
import com.leandro.viagemais.services.DestinationService;

@RestController
@RequestMapping("api/destination")
public class DestinationController extends GenericController<Destination, UUID, DestinationService> {

  public DestinationController(@Qualifier("destinationService") DestinationService service) {
    super(service);

  }

}
