package com.mamalimomen.services;

import com.mamalimomen.base.services.BaseService;
import com.mamalimomen.domains.Travel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TravelService extends BaseService<Travel> {
    String createNewTravel(HttpServletRequest req);

    List<Travel> retrieveManyTravelsBySearch(HttpServletRequest req);
}
