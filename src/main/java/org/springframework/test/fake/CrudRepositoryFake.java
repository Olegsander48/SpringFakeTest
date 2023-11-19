package org.springframework.test.fake;

import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class CrudRepositoryFake<T extends Base<ID>, ID> implements CrudRepository<T, ID> {
    protected final Map<ID, T> memory = new HashMap<>();

    @Override
    public final <S extends T> S save(S entity) {
        memory.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public final <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        entities.forEach(this::save);
        return entities;
    }

    @Override
    public final Optional<T> findById(ID id) {
        return Optional.ofNullable(memory.get(id));
    }

    @Override
    public final boolean existsById(ID id) {
        return memory.containsKey(id);
    }

    @Override
    public final Iterable<T> findAll() {
        return memory.values();
    }

    @Override
    public final Iterable<T> findAllById(Iterable<ID> ids) {
        throw new UnsupportedOperationException("Not impl yet.");
    }

    @Override
    public final long count() {
        return memory.size();
    }

    @Override
    public final void deleteById(ID id) {
        memory.remove(id);
    }

    @Override
    public final void delete(T entity) {
        memory.remove(entity.getId());
    }

    @Override
    public final void deleteAllById(Iterable<? extends ID> ids) {
        throw new UnsupportedOperationException("Not impl yet.");
    }

    @Override
    public final void deleteAll(Iterable<? extends T> entities) {
        throw new UnsupportedOperationException("Not impl yet.");
    }

    @Override
    public final void deleteAll() {
        memory.clear();
    }
}
