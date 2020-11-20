package com.mamalimomen.controllers.servlets;

import com.mamalimomen.controllers.utilities.AppManager;
import com.mamalimomen.controllers.utilities.Services;
import com.mamalimomen.domains.Travel;
import com.mamalimomen.services.TravelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "search", urlPatterns = "/filter/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TravelService ts = AppManager.getService(Services.TRAVEL_SERVICE);
            List<Travel> travels = ts.retrieveManyTravelsBySearch(req);

            if (travels.isEmpty()) {
                req.getSession(false).setAttribute("search_message", "We can't found anything!");
            }

            travels.sort(Travel::compareTo);
            req.getSession(false).setAttribute("travels", travels);

            resp.sendRedirect("/OnlineBusReservation/search.jsp");
        } catch (NullPointerException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
