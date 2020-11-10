package com.mamalimomen.controllers.utilities;

import com.mamalimomen.base.controllers.utilities.PersistenceUnitManager;
import com.mamalimomen.base.controllers.utilities.PersistenceUnits;
import com.mamalimomen.base.domains.BaseEntity;
import com.mamalimomen.base.services.BaseService;
import com.mamalimomen.services.impl.TicketServiceImpl;
import com.mamalimomen.services.impl.TravelServiceImpl;
import com.mamalimomen.services.impl.UserServiceImpl;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class AppManager {
    private final static Stack<EntityManager> emStack = new Stack<>();
    private final static Map<Services, BaseService<? extends BaseEntity>> serviceMapper = new HashMap<>();

    private AppManager() {
    }

    public static synchronized void startApp() {
        try {
            System.setErr(new PrintStream("D:\\عزم راسخ\\جاوا مکتب\\کلاس\\49\\HW17_BackEnd\\src\\main\\resources\\log.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        EntityManager emORM = PersistenceUnitManager.getEntityManager(PersistenceUnits.UNIT_ONE);
        //EntityManager emOGM = PersistenceUnitManager.getEntityManager(PersistenceUnits.UNIT_TWO);

        emStack.push(emORM);
        //emStack.push(emOGM);

        serviceMapper.put(Services.TICKET_SERVICE, new TicketServiceImpl(emORM));
        serviceMapper.put(Services.TRAVEL_SERVICE, new TravelServiceImpl(emORM));
        serviceMapper.put(Services.USER_SERVICE, new UserServiceImpl(emORM));
    }

    public static <E extends BaseEntity, S extends BaseService<E>> S getService(Services service) {
        return (S) serviceMapper.get(service);
    }

    public static synchronized void endApp() {
        for (EntityManager em : emStack) {
            em.close();
        }

        PersistenceUnitManager.closeAllPersistenceProviders();
    }
}
