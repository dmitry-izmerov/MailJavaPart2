package ru.demi.app.resourceServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResourceServerController implements ResourceServerControllerMBean {
    private final ResourceServer resourceServer;
    private static final Logger logger = LogManager.getLogger(ResourceServerController.class);

    public ResourceServerController(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public String getName() {
        return resourceServer.getName();
    }

    @Override
    public int getAge() {
        return resourceServer.getAge();
    }
}
