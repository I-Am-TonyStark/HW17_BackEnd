package com.mamalimomen.controllers.servlets;

import com.mamalimomen.controllers.utilities.AppManager;
import com.mamalimomen.controllers.utilities.Services;
import com.mamalimomen.services.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "buy", urlPatterns = {"/filter/buy"})
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketService ts = AppManager.getService(Services.TICKET_SERVICE);

        String message = ts.createNewTicketByTravelID(req);

        req.getSession(false).setAttribute("message", message);

        resp.sendRedirect("/OnlineBusReservation/result.jsp");
    }
}
