package com.mamalimomen.controllers;

import com.mamalimomen.base.controllers.utilities.SMSPanel;
import com.mamalimomen.controllers.utilities.AppManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener(value = "App Initializer and Destroyer!")
public final class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AppManager.startApp();

        //SMSPanel.sendSMS("Your Web application has TurnOn at " + new Date(System.currentTimeMillis()), sce.getServletContext().getInitParameter("phone"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        AppManager.endApp();

        //SMSPanel.sendSMS("Your Web application has ShutDown at " + new Date(System.currentTimeMillis()), sce.getServletContext().getInitParameter("phone"));
    }
}
