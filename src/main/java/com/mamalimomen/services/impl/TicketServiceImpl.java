package com.mamalimomen.services.impl;

import com.mamalimomen.base.controllers.utilities.InValidDataException;
import com.mamalimomen.base.services.impl.ORMBaseServiceImpl;
import com.mamalimomen.controllers.utilities.AppManager;
import com.mamalimomen.controllers.utilities.Services;
import com.mamalimomen.domains.Gender;
import com.mamalimomen.domains.Ticket;
import com.mamalimomen.domains.Travel;
import com.mamalimomen.repositories.TicketRepository;
import com.mamalimomen.repositories.impl.TicketRepositoryImpl;
import com.mamalimomen.services.TicketService;
import com.mamalimomen.services.TravelService;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class TicketServiceImpl extends ORMBaseServiceImpl<Ticket, TicketRepository> implements TicketService {
    public TicketServiceImpl(EntityManager em) {
        super(new TicketRepositoryImpl(em));
    }

    @Override
    public String createNewTicketByTravelID(HttpServletRequest req) {
        Ticket ticket = new Ticket();

        try {
            ticket.setGender(Gender.valueOf(req.getParameter("gender")));
            ticket.setOwnerFullName(req.getParameter("passenger_name"));
            ticket.setOwnerUserID((long) req.getSession(false).getAttribute("userID"));

            TravelService ts = AppManager.getService(Services.TRAVEL_SERVICE);
            Optional<Travel> oTravel = ts.findOneById(Travel.class, Long.parseLong(req.getParameter("travel_ID")));
            ticket.setTravel(oTravel.get());

            if (repository.saveOne(ticket)) {
                StringBuilder result = new StringBuilder();

                switch (ticket.getGender()) {
                    case MALE -> result.append("Mr. ");
                    case FEMALE -> result.append("Miss. ");
                }

                result.append(ticket.getOwnerFullName())
                        .append(", Your Ticket Has created successfully!")
                        .append("\n")
                        .append("Ticket ID: ")
                        .append(ticket.getId());

                return result.toString();
            } else return "There is a problem when persist your ticket!";
        } catch (InValidDataException e) {
            return "Wrong entered data format for " + e.getMessage() + "!";
        } catch (NullPointerException | NoSuchElementException e) {
            return "There is a problem when create your ticket!";
        }
    }

    @Override
    public String deleteExistTicketByID(HttpServletRequest req) {
        try {
            Optional<Ticket> oTicket = repository.findOneById(Ticket.class, Long.valueOf(req.getParameter("ticket_ID")));
            Ticket ticket = oTicket.get();

            if (repository.deleteOne(ticket)) {
                StringBuilder result = new StringBuilder();

                switch (ticket.getGender()) {
                    case MALE -> result.append("Mr. ");
                    case FEMALE -> result.append("Miss. ");
                }

                result.append(ticket.getOwnerFullName())
                        .append(", Your Ticket Has canceled successfully!")
                        .append("\n")
                        .append("Ticket ID: ")
                        .append(ticket.getId());

                return result.toString();
            } else return "There is a problem when commit deleting your ticket!";
        } catch (NullPointerException | NoSuchElementException e) {
            return "There is a problem when delete your ticket!";
        }
    }

    @Override
    public List<Ticket> retrieveManyTicketByUserID(HttpServletRequest req) {
        return repository.findManyTicketByUserID((long) req.getSession(false).getAttribute("userID"));
    }
}
