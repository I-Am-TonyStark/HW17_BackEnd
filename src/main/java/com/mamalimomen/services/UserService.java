package com.mamalimomen.services;

import com.mamalimomen.base.services.BaseService;
import com.mamalimomen.domains.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface UserService extends BaseService<User> {

    String createNewUser(HttpServletRequest req);

    Optional<User> retrieveOneUserByUsername(HttpServletRequest req);
}
