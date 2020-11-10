package com.mamalimomen.controllers.servlets;

import com.mamalimomen.controllers.utilities.AppManager;
import com.mamalimomen.controllers.utilities.Services;
import com.mamalimomen.domains.Ticket;
import com.mamalimomen.services.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "see", urlPatterns = {"/filter/see"})
public class SeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TicketService ts = AppManager.getService(Services.TICKET_SERVICE);
            List<Ticket> tickets = ts.retrieveManyTicketByUserID(req);

            req.getSession(false).setAttribute("tickets", tickets);

            resp.sendRedirect("/OnlineBusReservation/see.jsp");
        } catch (NullPointerException e) {
            resp.sendError(500);
        }
    }
}
