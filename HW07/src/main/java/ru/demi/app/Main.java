package ru.demi.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.demi.app.server.Server;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Server server = new Server(5050, 10);

        server.start();
        logger.info("Server started");

        server.join();
    }
}
