package com.devarchi33.web.config;

/**
 * Created by donghoon on 2016. 1. 22..
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("==== Session is created ====");
        se.getSession().setMaxInactiveInterval(0);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("==== Session is destroyed ====");
    }


}
