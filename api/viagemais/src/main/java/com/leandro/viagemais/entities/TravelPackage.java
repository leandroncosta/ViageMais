package com.leandro.viagemais.entities;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity
public class TravelPackage {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private Boolean promotion;
  private Double totalValue;

  @ManyToOne
  @JoinColumn(name = "hotel_id")
  private Hotel hotel;

  @ManyToOne
  @JoinColumn(name = "ticket_id")
  private Ticket ticket;
}
