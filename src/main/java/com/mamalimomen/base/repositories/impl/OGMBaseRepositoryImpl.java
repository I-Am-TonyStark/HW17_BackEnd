package com.mamalimomen.base.repositories.impl;

import com.mamalimomen.base.domains.BaseEntity;
import com.mamalimomen.base.repositories.BaseRepository;

import javax.persistence.*;
import javax.persistence.RollbackException;
import javax.transaction.*;
import java.util.List;
import java.util.Optional;

public class OGMBaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E> {
    private final TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();

    @PersistenceContext(unitName = "ogm-unit")
    private final EntityManager em;

    public OGMBaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void closeEntityManger() {
        if (em.isOpen()) {
            em.close();
        }
    }

    @Override
    public boolean saveOne(E e) {
        try {
            tm.begin();

            em.persist(e);

            tm.commit();

            return true;
        } catch (EntityExistsException | RollbackException ex) {
            try {
                tm.rollback();
            } catch (SystemException exc) {
                exc.printStackTrace();
            }
        } catch (NotSupportedException | SystemException | HeuristicMixedException | HeuristicRollbackException | javax.transaction.RollbackException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateOne(E e) {
        try {
            tm.begin();

            if (!em.contains(e))
                em.merge(e);

            tm.getTransaction().commit();

            return true;
        } catch (IllegalArgumentException | RollbackException ex) {
            try {
                tm.rollback();
            } catch (SystemException exc) {
                exc.printStackTrace();
            }
        } catch (NotSupportedException | SystemException | HeuristicMixedException | HeuristicRollbackException | javax.transaction.RollbackException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOne(E e) {
        try {
            tm.begin();

            em.remove(e);

            tm.commit();

            return true;
        } catch (IllegalArgumentException | RollbackException ex) {
            try {
                tm.rollback();
            } catch (SystemException exc) {
                exc.printStackTrace();
            }
        } catch (NotSupportedException | SystemException | javax.transaction.RollbackException | HeuristicMixedException | HeuristicRollbackException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<E> findOneById(Class<E> c, Long id) {
        E e = em.find(c, id);
        return e != null ? Optional.of(e) : Optional.empty();
    }

    @Override
    public Optional<E> findOneByNamedQuery(String namedQuery, Class<E> c, Object... parameters) {
        E e;
        try {
            TypedQuery<E> nq = em.createNamedQuery(namedQuery, c);

            for (int i = 1; i <= parameters.length; i++) {
                nq = nq.setParameter(i, parameters[i - 1]);
            }

            e = nq.getSingleResult();
        } catch (NoResultException ex) {
            e = null;
        }
        return e != null ? Optional.of(e) : Optional.empty();
    }

    @Override
    public List<E> findManyByNamedQuery(String namedQuery, Class<E> c, Object... parameters) {
        TypedQuery<E> nq = em.createNamedQuery(namedQuery, c);

        for (int i = 1; i <= parameters.length; i++) {
            nq = nq.setParameter(i, parameters[i - 1]);
        }

        return nq.getResultList();
    }

    @Override
    public List<E> findAllByNamedQuery(String namedQuery, Class<E> c) {
        return em.createNamedQuery(namedQuery, c)
                .getResultList();
    }

    @Override
    public List<E> findManyByNativeQuery(String nativeQuery, Class<E> c) {
        return em.createNativeQuery(nativeQuery, c)
                .getResultList();
    }

    @Override
    public Optional<E> findOneByNativeQuery(String nativeQuery, Class<E> c) {
        E e = (E) em.createNativeQuery(nativeQuery, c).getSingleResult();
        return e != null ? Optional.of(e) : Optional.empty();
    }
}

