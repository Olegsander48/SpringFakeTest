package org.springframework.test.fake;

import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class CrudRepositoryFake<T extends Base<ID>, ID> implements CrudRepository<T, ID> {
    protected final Map<ID, T> memory = new HashMap<>();

    @Override
    public <S extends T> S save(S entity) {
        memory.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        entities.forEach(this::save);
        return entities;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(memory.get(id));
    }

    @Override
    public boolean existsById(ID id) {
        return memory.containsKey(id);
    }

    @Override
    public Iterable<T> findAll() {
        return memory.values();
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {
        throw new UnsupportedOperationException("Not impl yet.");
    }

    @Override
    public long count() {
        return memory.size();
    }

    @Override
    public void deleteById(ID id) {
        memory.remove(id);
    }

    @Override
    public void delete(T entity) {
        memory.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends ID> ids) {
        throw new UnsupportedOperationException("Not impl yet.");
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        throw new UnsupportedOperationException("Not impl yet.");
    }

    @Override
    public void deleteAll() {
        memory.clear();
    }
}
