package com.mamalimomen.repositories.impl;

import com.mamalimomen.base.repositories.impl.ORMBaseRepositoryImpl;
import com.mamalimomen.domains.Ticket;
import com.mamalimomen.repositories.TicketRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class TicketRepositoryImpl extends ORMBaseRepositoryImpl<Ticket> implements TicketRepository {
    public TicketRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Ticket> findManyTicketByUserID(Long userID) {
        return findManyByNamedQuery("Ticket.findManyByUserID", Ticket.class, userID);
    }
}
