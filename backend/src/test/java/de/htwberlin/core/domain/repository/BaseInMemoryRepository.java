package de.htwberlin.core.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

@SuppressWarnings("NullableProblems")
public class BaseInMemoryRepository<T, ID> implements JpaRepository<T, ID> {

  @Override
  public List<T> findAll() {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public List<T> findAll(Sort sort) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public Page<T> findAll(Pageable pageable) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public List<T> findAllById(Iterable<ID> ids) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public long count() {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public void deleteById(ID id) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public void delete(T entity) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public void deleteAllById(Iterable<? extends ID> ids) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public void deleteAll(Iterable<? extends T> entities) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public void deleteAll() {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> S save(S entity) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> List<S> saveAll(Iterable<S> entities) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public Optional<T> findById(ID id) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public boolean existsById(ID id) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public void flush() {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> S saveAndFlush(S entity) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public void deleteAllInBatch(Iterable<T> entities) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public void deleteAllByIdInBatch(Iterable<ID> ids) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public void deleteAllInBatch() {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public T getOne(ID id) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public T getById(ID id) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public T getReferenceById(ID id) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> Optional<S> findOne(Example<S> example) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> List<S> findAll(Example<S> example) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> long count(Example<S> example) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T> boolean exists(Example<S> example) {
    throw new NotImplementedException("Should be implemented");
  }

  @Override
  public <S extends T, R> R findBy(
      Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    throw new NotImplementedException("Should be implemented");
  }
}
