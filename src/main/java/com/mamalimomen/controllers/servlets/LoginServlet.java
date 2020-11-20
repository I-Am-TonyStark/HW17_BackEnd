package com.mamalimomen.controllers.servlets;

import com.mamalimomen.base.controllers.utilities.SecurityManager;
import com.mamalimomen.controllers.utilities.AppManager;
import com.mamalimomen.controllers.utilities.Services;
import com.mamalimomen.domains.City;
import com.mamalimomen.domains.User;
import com.mamalimomen.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String username = req.getParameter("username");

        UserService us = AppManager.getService(Services.USER_SERVICE);
        Optional<User> oUser = us.retrieveOneUserByUsername(req);

        String message;

        if (oUser.isEmpty()) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/signup");
            requestDispatcher.forward(req, resp);
            return;
        } else {
            User user = oUser.get();
            if (!SecurityManager.checkPasswordHash(password, user.getPassword())) {
                message = "Wrong Password!";
                req.setAttribute("login_message", message);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
                requestDispatcher.include(req, resp);
                return;
            }

            HttpSession session = req.getSession(true);
            session.setMaxInactiveInterval(30 * 60);
            session.setAttribute("userID", user.getId());
            session.setAttribute("cities", City.values());
        }


        Cookie usernameCookie = new Cookie("username", username);
        Cookie passwordCookie = new Cookie("password", password);

        usernameCookie.setMaxAge(-1);
        passwordCookie.setMaxAge(-1);

        /*usernameCookie.setPath("/security");
        passwordCookie.setPath("/security");*/

        usernameCookie.setHttpOnly(true);
        passwordCookie.setHttpOnly(true);

        /*usernameCookie.setSecure(true);
        passwordCookie.setSecure(true);*/

        resp.addCookie(usernameCookie);
        resp.addCookie(passwordCookie);

        resp.sendRedirect("menu.jsp");
    }
}
