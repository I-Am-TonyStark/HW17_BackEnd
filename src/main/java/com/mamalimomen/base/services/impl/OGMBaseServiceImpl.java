package com.mamalimomen.base.services.impl;

import com.mamalimomen.base.domains.BaseEntity;
import com.mamalimomen.base.repositories.BaseRepository;
import com.mamalimomen.base.services.BaseService;

import java.util.List;
import java.util.Optional;

public class OGMBaseServiceImpl<E extends BaseEntity, R extends BaseRepository<E>> implements BaseService<E> {
    protected final R repository;

    public OGMBaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void closeEntityManger() {
        repository.closeEntityManger();
    }

    @Override
    public boolean saveOne(E e) {
        return repository.saveOne(e);
    }

    @Override
    public boolean updateOne(E e) {
        return repository.updateOne(e);
    }

    @Override
    public boolean deleteOne(E e) {
        return repository.deleteOne(e);
    }

    @Override
    public Optional<E> findOneById(Class<E> c, Long id) {
        return repository.findOneById(c, id);
    }

    @Override
    public Optional<E> findOneByNamedQuery(String namedQuery, Class<E> c, Object... parameters) {
        return repository.findOneByNamedQuery(namedQuery, c, parameters);
    }

    @Override
    public List<E> findManyByNamedQuery(String namedQuery, Class<E> c, Object... parameters) {
        return repository.findManyByNamedQuery(namedQuery, c, parameters);
    }

    @Override
    public List<E> findAllByNamedQuery(String namedQuery, Class<E> c) {
        return repository.findAllByNamedQuery(namedQuery, c);
    }

    @Override
    public List<E> findManyByNativeQuery(String nativeQuery, Class<E> c) {
        return repository.findManyByNativeQuery(nativeQuery, c);
    }

    @Override
    public Optional<E> findOneByNativeQuery(String nativeQuery, Class<E> c) {
        return repository.findOneByNativeQuery(nativeQuery, c);
    }
}