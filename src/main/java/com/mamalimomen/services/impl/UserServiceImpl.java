package com.mamalimomen.services.impl;

import com.mamalimomen.base.controllers.utilities.InValidDataException;
import com.mamalimomen.base.services.impl.ORMBaseServiceImpl;
import com.mamalimomen.domains.User;
import com.mamalimomen.repositories.UserRepository;
import com.mamalimomen.repositories.impl.UserRepositoryImpl;
import com.mamalimomen.services.UserService;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserServiceImpl extends ORMBaseServiceImpl<User, UserRepository> implements UserService {
    public UserServiceImpl(EntityManager em) {
        super(new UserRepositoryImpl(em));
    }

    @Override
    public String createNewUser(HttpServletRequest req) {
        User user = new User();

        try {
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));

            if (repository.saveOne(user)) {
                return "Welcome to our website!";
            } else return "There is a problem when persist your account!";
        } catch (InValidDataException e) {
            return "Wrong entered data format for " + e.getMessage() + "!";
        } catch (NullPointerException | NoSuchElementException e) {
            return "There is a problem when create your account!";
        }
    }

    @Override
    public Optional<User> retrieveOneUserByUsername(HttpServletRequest req) {
        return repository.findOneUserByUsername(req.getParameter("username"));
    }
}
