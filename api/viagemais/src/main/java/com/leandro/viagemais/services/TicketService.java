package com.leandro.viagemais.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leandro.viagemais.entities.Ticket;
import com.leandro.viagemais.repositories.TicketRepository;
import com.leandro.viagemais.servicesImpl.ServiceImplGeneric;

@Service
public class TicketService extends ServiceImplGeneric<Ticket, UUID, TicketRepository> {

  public TicketService(@Qualifier("ticketRepository") TicketRepository repository) {
    super(repository);

  }

}
