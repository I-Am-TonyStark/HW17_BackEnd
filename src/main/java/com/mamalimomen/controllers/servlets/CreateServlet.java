package com.mamalimomen.controllers.servlets;

import com.mamalimomen.controllers.utilities.AppManager;
import com.mamalimomen.controllers.utilities.Services;
import com.mamalimomen.services.TravelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create", urlPatterns = {"/filter/security/create"})
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TravelService ts = AppManager.getService(Services.TRAVEL_SERVICE);
        String message = ts.createNewTravel(req);

        req.getSession(false).setAttribute("create_message", message);
        resp.sendRedirect("/OnlineBusReservation/create.jsp");
    }
}
