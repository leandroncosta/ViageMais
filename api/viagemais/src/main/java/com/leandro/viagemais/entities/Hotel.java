package com.leandro.viagemais.entities;

import java.util.Date;
import java.util.UUID;

import org.hibernate.mapping.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Hotel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String cnpj;
  private String name;
  private int starts;
  private Boolean promotion;
  private Double value;

  private Date entryDate;
  private Date departureDate;

  private String ImageUrl;
}
