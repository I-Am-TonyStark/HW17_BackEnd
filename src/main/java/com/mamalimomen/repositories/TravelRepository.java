package com.mamalimomen.repositories;

import com.mamalimomen.base.repositories.BaseRepository;
import com.mamalimomen.domains.City;
import com.mamalimomen.domains.Travel;

import java.sql.Date;
import java.util.List;

public interface TravelRepository extends BaseRepository<Travel> {

    List<Travel> findManyTravelsByODD(City origin, City destination, Date date);
}
