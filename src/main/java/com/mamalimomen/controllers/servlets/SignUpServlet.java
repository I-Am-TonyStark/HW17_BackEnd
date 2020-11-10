package com.mamalimomen.controllers.servlets;

import com.mamalimomen.controllers.utilities.AppManager;
import com.mamalimomen.controllers.utilities.Services;
import com.mamalimomen.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "signup", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService us = AppManager.getService(Services.USER_SERVICE);

        String message;

        message = us.createNewUser(req);
        req.setAttribute("message", message);

        if (!message.matches("Welcome to our website!")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login");
            requestDispatcher.forward(req, resp);
        }
    }
}
