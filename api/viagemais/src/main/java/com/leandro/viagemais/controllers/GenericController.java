package com.leandro.viagemais.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.leandro.viagemais.services.CrudService;

import jakarta.validation.Valid;

public abstract class GenericController<T, ID extends Serializable, S extends CrudService<T, ID>> {

  private final S service;

  public GenericController(S service) {
    this.service = service;
  }

  // api/default - GET ALL
  @GetMapping
  public ResponseEntity<List<T>> list() {
    var entities = service.findAll();

    return ResponseEntity.ok().body(entities);
  }

  // api/default/1 - GET BY ID
  @GetMapping("/{id}")
  public ResponseEntity<T> findById(@PathVariable("id") ID id) {
    var entity = this.service.findById(id);

    if (entity.isPresent()) {
      return ResponseEntity.ok().body(entity.get());
    }

    return ResponseEntity.noContent().build();
  }

  // api/default - POST
  @PostMapping
  public ResponseEntity<Void> create(@RequestBody T data) {
    this.service.save(data);

    return ResponseEntity.status(201).build();
  }

  // api/default/1- PUT
  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable("id") ID id, @RequestBody @Valid T data) {
    this.service.updateById(data, id);

    return ResponseEntity.ok().build();
  }

  // api/default/1 - DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") ID id) {
    this.service.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}
