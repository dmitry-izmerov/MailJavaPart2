package ru.demi.app.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author demi
 * @date 05.03.16
 */
public class Server extends Thread {

    private static final Logger logger = LogManager.getLogger(Server.class);

    private final ServerSocket serverSocket;
    private int numHandlers;

    public Server(int port, int numHandlers) throws IOException {
        this.serverSocket = new ServerSocket(port, 100);
        this.numHandlers = numHandlers;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            logger.warn(e);
        }
    }
}
