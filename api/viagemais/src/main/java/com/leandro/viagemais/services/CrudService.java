package com.leandro.viagemais.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

// interface crud generico

public interface CrudService<T, ID extends Serializable> {
  List<T> findAll();

  Optional<T> findById(ID id);

  T save(T entity);

  void updateById(T entity, ID id);

  void deleteById(ID id);

}
