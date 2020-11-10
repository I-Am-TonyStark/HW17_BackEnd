package com.mamalimomen.base.services;

import com.mamalimomen.base.domains.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity> {
    void closeEntityManger();

    boolean saveOne(E e);

    boolean updateOne(E e);

    boolean deleteOne(E e);

    Optional<E> findOneById(Class<E> c, Long id);

    Optional<E> findOneByNamedQuery(String namedQuery, Class<E> c, Object... parameters);

    List<E> findManyByNamedQuery(String namedQuery, Class<E> c, Object... parameters);

    List<E> findAllByNamedQuery(String namedQuery, Class<E> c);

    List<E> findManyByNativeQuery(String nativeQuery, Class<E> c);

    Optional<E> findOneByNativeQuery(String nativeQuery, Class<E> c);
}
