package com.leandro.viagemais.entities;

import java.time.LocalDate;
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
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private Double serviceFee;
  private Double boardingFee;
  private String airline;
  private String flightType;
  private Boolean roundTrip;
  private LocalDate date;
  private int quantity;
  private Boolean promotion;
  private String airlineCnpj;
  private Double value;

  @ManyToOne
  @JoinColumn(name = "destination_id")
  private Destination destination;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Double getServiceFee() {
    return serviceFee;
  }

  public void setServiceFee(Double serviceFee) {
    this.serviceFee = serviceFee;
  }

  public Double getBoardingFee() {
    return boardingFee;
  }

  public void setBoardingFee(Double boardingFee) {
    this.boardingFee = boardingFee;
  }

  public String getAirline() {
    return airline;
  }

  public void setAirline(String airline) {
    this.airline = airline;
  }

  public String getFlightType() {
    return flightType;
  }

  public void setFlightType(String flightType) {
    this.flightType = flightType;
  }

  public Boolean getRoundTrip() {
    return roundTrip;
  }

  public void setRoundTrip(Boolean roundTrip) {
    this.roundTrip = roundTrip;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Boolean getPromotion() {
    return promotion;
  }

  public void setPromotion(Boolean promotion) {
    this.promotion = promotion;
  }

  public String getAirlineCnpj() {
    return airlineCnpj;
  }

  public void setAirlineCnpj(String airlineCnpj) {
    this.airlineCnpj = airlineCnpj;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

}
