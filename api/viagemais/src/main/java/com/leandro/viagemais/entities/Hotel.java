package com.leandro.viagemais.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table
@Entity
public class Hotel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String cnpj;
  private String name;
  private int stars;
  private Boolean promotion;
  private Double value;

  @JsonFormat(pattern = "dd-MM-yyyy")
  private Date entryDate;
  @JsonFormat(pattern = "dd-MM-yyyy")
  private Date departureDate;

  private String ImageUrl;
  private String adress;

  @OneToMany(mappedBy = "hotel")
  private Set<TravelPackage> packages = new HashSet<>();

  public Hotel(UUID id, String cnpj, String name, int stars, Boolean promotion, Double value, Date entryDate,
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

  public Date getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(Date entryDate) {
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
