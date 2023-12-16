package com.leandro.viagemais.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.dto.TicketDTO;
import com.leandro.viagemais.entities.Destination;
import com.leandro.viagemais.entities.Ticket;
import com.leandro.viagemais.services.DestinationService;
import com.leandro.viagemais.services.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/ticket")
public class TicketController {

  private TicketService ticketService;

  private DestinationService destinationService;

  public TicketController(TicketService ticketService, DestinationService destinationService) {
    this.ticketService = ticketService;
    this.destinationService = destinationService;
  }

  @GetMapping
  public ResponseEntity<List<Ticket>> list() {
    var tickets = this.ticketService.findAll();

    return ResponseEntity.ok().body(tickets);
  }

  @Transactional
  @PostMapping
  public ResponseEntity<Ticket> create(@RequestBody @Valid TicketDTO data) {
    var destination = this.destinationService.findById((UUID) data.destination_id())
        .orElse(new Destination());

    var ticket = new Ticket(data);
    ticket.setDestination(destination);

    this.ticketService.save(ticket);

    return ResponseEntity.status(201).body(ticket);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Ticket> findById(@PathVariable("id") UUID id) {
    var ticket = this.ticketService.findById(id);

    if (ticket.isPresent()) {
      return ResponseEntity.ok().body(ticket.get());
    }

    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@PathVariable("id") UUID id, @RequestBody @Valid TicketDTO data) {
    var ticketUpdated = new Ticket(data);

    this.ticketService.updateById(ticketUpdated, id);

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
    this.ticketService.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}
