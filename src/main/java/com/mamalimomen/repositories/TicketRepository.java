package com.mamalimomen.repositories;

import com.mamalimomen.base.repositories.BaseRepository;
import com.mamalimomen.domains.Ticket;

import java.util.List;

public interface TicketRepository extends BaseRepository<Ticket> {

    List<Ticket> findManyTicketByUserID(Long userID);
}
