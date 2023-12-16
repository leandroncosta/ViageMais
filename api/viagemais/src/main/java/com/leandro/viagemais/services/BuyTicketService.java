package com.leandro.viagemais.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leandro.viagemais.dto.BuyTicketDTO;
import com.leandro.viagemais.entities.BuyTicket;
import com.leandro.viagemais.repositories.BuyTicketRepository;
import com.leandro.viagemais.repositories.TicketRepository;
import com.leandro.viagemais.repositories.UserRepository;
import com.leandro.viagemais.servicesImpl.ServiceImplGeneric;

@Service
public class BuyTicketService extends ServiceImplGeneric<BuyTicket, UUID, BuyTicketRepository> {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TicketRepository ticketRepository;

  public BuyTicketService(@Qualifier("buyTicketRepository") BuyTicketRepository repository) {
    super(repository);

  }

  // public void saveTicket(UUID userId, UUID ticketId) {
  // var user = this.userRepository.findById(userId)
  // .orElseThrow(() -> new RuntimeException("ID: " + userId + " not found"));
  // var ticket = this.ticketRepository.findById(ticketId)
  // .orElseThrow(() -> new RuntimeException("ID: " + ticketId + " not found"));

  // if (user != null && ticket != null) {

  // ticket.getUsers().add(user);
  // user.getTickets().add(ticket);

  // this.userRepository.save(user);
  // this.ticketRepository.save(ticket);
  // }

  // }

  public void saveTicket(BuyTicketDTO data) {
    var user = this.userRepository.findById(data.user_id())
        .orElseThrow(() -> new RuntimeException("ID: " + data.user_id() + " not found"));
    var ticket = this.ticketRepository.findById(data.ticket_id())
        .orElseThrow(() -> new RuntimeException("ID: " + data.ticket_id() + " not found"));

    if (user != null && ticket != null) {

      var buyTicket = new BuyTicket(data);

      buyTicket.setTicket(ticket);
      buyTicket.setUser(user);

      this.repository.save(buyTicket);

      // ticket.getUsers().add(user);
      // user.getTickets().add(ticket);

      // this.userRepository.save(user);
      // this.ticketRepository.save(ticket);
    }

  }

  public List<Object> findAllTicket() {
    var objects = this.repository.findAllTicket();

    return objects;
  }
}
