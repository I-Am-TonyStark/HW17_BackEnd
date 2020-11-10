package com.mamalimomen.services.impl;

import com.mamalimomen.base.services.impl.ORMBaseServiceImpl;
import com.mamalimomen.domains.City;
import com.mamalimomen.domains.Travel;
import com.mamalimomen.repositories.TravelRepository;
import com.mamalimomen.repositories.impl.TravelRepositoryImpl;
import com.mamalimomen.services.TravelService;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TravelServiceImpl extends ORMBaseServiceImpl<Travel, TravelRepository> implements TravelService {
    public TravelServiceImpl(EntityManager em) {
        super(new TravelRepositoryImpl(em));
    }

    @Override
    public String createNewTravel(HttpServletRequest req) {
        try {
            Travel travel = new Travel();

            String origin = req.getParameter("origin_cities");
            String destination = req.getParameter("dest_cities");

            if (origin.equalsIgnoreCase(destination)) {
                throw new IllegalArgumentException("Same origin and destination!");
            }

            travel.setOrigin(City.valueOf(origin));
            travel.setDestination(City.valueOf(destination));
            travel.setTravelDate(Date.valueOf(req.getParameter("date")));
            travel.setTravelTime(Time.valueOf(req.getParameter("time") + ":00"));

            if (repository.saveOne(travel)) {
                return "Your Travel Has created successfully!";
            } else return "There is a problem when persist your travel!";
        } catch (IllegalArgumentException e) {
            return "Wrong entered data format for " + e.getMessage() + "!";
        }
    }

    @Override
    public List<Travel> retrieveManyTravelsBySearch(HttpServletRequest req) {
        try {
            return repository.findManyTravelsByODD(City.valueOf(req.getParameter("origin_cities")),
                    City.valueOf(req.getParameter("dest_cities")),
                    Date.valueOf(req.getParameter("date")));
        } catch (IllegalArgumentException e) {
            return new ArrayList<>();
        }
    }
}
