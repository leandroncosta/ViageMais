package com.leandro.viagemais.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leandro.viagemais.dto.TicketDTO;
import com.leandro.viagemais.entities.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;
  private int quantity;
  private Boolean promotion;

  @Column(unique = true)
  private String airlineCnpj;
  private Double value;

  @JsonIgnore
  @ManyToMany(mappedBy = "tickets", fetch = FetchType.EAGER)
  private Set<User> users = new HashSet<>();

  @ManyToOne(cascade = { CascadeType.ALL })
  @JoinColumn(name = "destination_id")
  private Destination destination;

  public Ticket(UUID id, Double serviceFee, Double boardingFee, String airline, String flightType, Boolean roundTrip,
      LocalDate date, int quantity, Boolean promotion, String airlineCnpj, Double value, Destination destination) {
    this.id = id;
    this.serviceFee = serviceFee;
    this.boardingFee = boardingFee;
    this.airline = airline;
    this.flightType = flightType;
    this.roundTrip = roundTrip;
    this.date = date;
    this.quantity = quantity;
    this.promotion = promotion;
    this.airlineCnpj = airlineCnpj;
    this.value = value;
    this.destination = destination;
  }

  public Ticket() {

  }

  public Ticket(TicketDTO dto) {
    BeanUtils.copyProperties(dto, this);
  }

  public Destination getDestination() {
    return destination;
  }

  public void setDestination(Destination destination) {
    this.destination = destination;
  }

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

  @Override
  public String toString() {
    return "Ticket [id=" + id + ", serviceFee=" + serviceFee + ", boardingFee=" + boardingFee + ", airline=" + airline
        + ", flightType=" + flightType + ", roundTrip=" + roundTrip + ", date=" + date + ", quantity=" + quantity
        + ", promotion=" + promotion + ", airlineCnpj=" + airlineCnpj + ", value=" + value + ", destination="
        + destination + "]";
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

}
