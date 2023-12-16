package com.leandro.viagemais.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.BeanUtils;

import com.leandro.viagemais.dto.BuyPackageDTO;
import com.leandro.viagemais.entities.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "buy_package")
@Entity
public class BuyPackage {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "package_id")
  private TravelPackage travelPackage;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDate dateOfBuy;

  public BuyPackage() {

  }

  public BuyPackage(BuyPackageDTO data) {
    BeanUtils.copyProperties(data, this);
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public TravelPackage getTravelPackage() {
    return travelPackage;
  }

  public void setTravelPackage(TravelPackage travelPackage) {
    this.travelPackage = travelPackage;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public LocalDate getDateOfBuy() {
    return dateOfBuy;
  }

  public void setDateOfBuy(LocalDate dateOfBuy) {
    this.dateOfBuy = dateOfBuy;
  }
}
