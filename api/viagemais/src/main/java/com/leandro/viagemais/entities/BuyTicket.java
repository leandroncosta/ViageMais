package com.leandro.viagemais.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.BeanUtils;

import com.leandro.viagemais.dto.BuyTicketDTO;
import com.leandro.viagemais.entities.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "buy_ticket")
public class BuyTicket {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "ticket_id")
  private Ticket ticket;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDate dateOfBuy;

  public BuyTicket(BuyTicketDTO data) {
    BeanUtils.copyProperties(data, this);
  }

  public BuyTicket() {

  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public LocalDate getDateOfBuy() {
    return dateOfBuy;
  }

  public void setDateOfBuy(LocalDate dateOfBuy) {
    this.dateOfBuy = dateOfBuy;
  }

}
