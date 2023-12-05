package com.leandro.viagemais.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Destination {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String city;
  private String state;
  private String imageUrl;
}
