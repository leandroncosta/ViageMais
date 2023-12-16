package com.leandro.viagemais.entities;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.leandro.viagemais.dto.DestinationDTO;

import jakarta.persistence.Column;
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

  @Column(unique = true, nullable = false)
  private String city;

  private String state;
  private String imageUrl;

  public Destination(UUID id, String city, String state, String imageUrl) {
    this.id = id;
    this.city = city;
    this.state = state;
    this.imageUrl = imageUrl;
  }

  public Destination() {

  }

  public Destination(DestinationDTO data) {
    BeanUtils.copyProperties(data, this);
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

}
