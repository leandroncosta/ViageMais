package com.leandro.viagemais.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Table
@Entity
public class Hotel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(unique = true)
  private String cnpj;

  @Column(nullable = false)
  private String name;

  private int stars;
  private Boolean promotion;

  @Column(nullable = false)
  private Double value;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @CreationTimestamp
  private LocalDate entryDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date departureDate;

  private String ImageUrl;

  @NotBlank
  @Column(nullable = false)
  private String adress;

  public Hotel(UUID id, String cnpj, String name, int stars, Boolean promotion, Double value, LocalDate entryDate,
      Date departureDate, String imageUrl, String adress) {
    this.id = id;
    this.cnpj = cnpj;
    this.name = name;
    this.stars = stars;
    this.promotion = promotion;
    this.value = value;
    this.entryDate = entryDate;
    this.departureDate = departureDate;
    ImageUrl = imageUrl;
    this.adress = adress;
  }

  public Hotel() {

  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }

  public Boolean getPromotion() {
    return promotion;
  }

  public void setPromotion(Boolean promotion) {
    this.promotion = promotion;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public LocalDate getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(LocalDate entryDate) {
    this.entryDate = entryDate;
  }

  public Date getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(Date departureDate) {
    this.departureDate = departureDate;
  }

  public String getImageUrl() {
    return ImageUrl;
  }

  public void setImageUrl(String imageUrl) {
    ImageUrl = imageUrl;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

}
