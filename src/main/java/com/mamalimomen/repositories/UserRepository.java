package com.mamalimomen.repositories;

import com.mamalimomen.base.repositories.BaseRepository;
import com.mamalimomen.domains.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    Optional<User> findOneUserByUsername(String username);
}
