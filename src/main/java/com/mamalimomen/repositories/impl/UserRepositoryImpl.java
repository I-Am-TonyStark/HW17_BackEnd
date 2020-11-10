package com.mamalimomen.repositories.impl;

import com.mamalimomen.base.repositories.impl.ORMBaseRepositoryImpl;
import com.mamalimomen.domains.User;
import com.mamalimomen.repositories.UserRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserRepositoryImpl extends ORMBaseRepositoryImpl<User> implements UserRepository {
    public UserRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<User> findOneUserByUsername(String username) {
        //return findOneByNativeQuery("{username:{" + username + "}}", User.class);
        return findOneByNamedQuery("User.findOneByUsername", User.class, username);
    }
}
