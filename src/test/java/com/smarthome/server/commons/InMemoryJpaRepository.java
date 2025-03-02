package com.smarthome.server.commons;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public class InMemoryJpaRepository<T, ID> implements MongoRepository<T, ID> {
    protected final Map<ID, T> database = new HashMap<>();

    private final Function<T, ID> idGetter;

    @Override
    public List<T> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public List<T> findAll(Sort sort) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> S insert(S entity) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> List<S> insert(Iterable<S> entities) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> S save(S entity) {
        database.put(idGetter.apply(entity), entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public boolean existsById(ID id) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public long count() {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public void deleteById(ID id) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public void delete(T entity) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public void deleteAllById(Iterable<? extends ID> ids) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public void deleteAll() {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        throw new ImplementMePleaseException("please please please");
    }

    @Override
    public <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        throw new ImplementMePleaseException("please please please");
    }
}

