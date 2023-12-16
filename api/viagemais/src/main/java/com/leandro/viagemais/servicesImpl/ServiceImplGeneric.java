package com.leandro.viagemais.servicesImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.leandro.viagemais.services.CrudService;
import com.leandro.viagemais.utils.Utils;

public class ServiceImplGeneric<T, ID extends Serializable, R extends JpaRepository<T, ID>>
    implements CrudService<T, ID> {

  protected final R repository;

  public ServiceImplGeneric(R repository) {
    this.repository = repository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<T> findAll() {
    return this.repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<T> findById(ID id) {
    return this.repository.findById(id);
  }

  @Override
  public T save(T entity) {
    return this.repository.save(entity);
  }

  @Override
  @Transactional
  public void updateById(T entityUpdated, ID id) {

    var entity = this.repository.findById(id).orElse(null);

    Utils.copyNonNullProperties(entityUpdated, entity);

    this.repository.save(entity);
  }

  @Override
  public void deleteById(ID id) {
    this.repository.deleteById(id);

  }

}
