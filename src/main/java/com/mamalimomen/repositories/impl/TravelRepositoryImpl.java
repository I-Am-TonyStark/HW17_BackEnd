package com.mamalimomen.repositories.impl;

import com.mamalimomen.base.repositories.impl.ORMBaseRepositoryImpl;
import com.mamalimomen.domains.City;
import com.mamalimomen.domains.Travel;
import com.mamalimomen.repositories.TravelRepository;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.List;

public class TravelRepositoryImpl extends ORMBaseRepositoryImpl<Travel> implements TravelRepository {
    public TravelRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Travel> findManyTravelsByODD(City origin, City destination, Date date) {
        return findManyByNamedQuery("Travel.findManyByODD", Travel.class, origin, destination, date);
    }
}
