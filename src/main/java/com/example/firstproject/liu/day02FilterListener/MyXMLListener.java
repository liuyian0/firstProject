package com.example.firstproject.liu.day02FilterListener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class MyXMLListener implements ServletContextListener{

    public MyXMLListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

}
