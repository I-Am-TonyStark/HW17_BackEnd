package com.mamalimomen.services;

import com.mamalimomen.base.services.BaseService;
import com.mamalimomen.domains.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TicketService extends BaseService<Ticket> {
    String createNewTicketByTravelID(HttpServletRequest req);

    String deleteExistTicketByID(HttpServletRequest req);

    List<Ticket> retrieveManyTicketByUserID(HttpServletRequest req);
}
