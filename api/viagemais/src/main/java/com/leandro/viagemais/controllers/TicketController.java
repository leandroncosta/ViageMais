package com.leandro.viagemais.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.viagemais.entities.Hotel;
import com.leandro.viagemais.entities.Ticket;
import com.leandro.viagemais.services.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/ticket")
public class TicketController {

  private TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @GetMapping
  public ResponseEntity<List<Ticket>> list() {
    var tickets = this.ticketService.findAll();

    return ResponseEntity.ok().body(tickets);
  }

  @PostMapping
  public ResponseEntity<String> create(@RequestBody @Valid Ticket data) {
    System.out.println(data.toString());
    this.ticketService.save(data);

    return ResponseEntity.status(201).build();
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
  public ResponseEntity<String> update(@PathVariable("id") UUID id, @RequestBody @Valid Hotel data) {

    return ResponseEntity.ok().build();

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
    this.ticketService.deleteById(id);

    return ResponseEntity.noContent().build();
  }

}
