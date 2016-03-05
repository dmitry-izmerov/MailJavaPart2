package ru.demi.app.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;

/**
 * @author demi
 * @date 05.03.16
 */
public class Handler extends Thread {
    private static final Logger logger = LogManager.getLogger(Handler.class);
    private final BufferedReader reader;
    private final PrintWriter writer;
    private Socket socket;

    public Handler(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run() {
        try {
            String s;
            while ((s = reader.readLine()) != null) {
                writer.println(s);
                writer.flush();
            }
        } catch (IOException e) {
            logger.warn(e);
        }
    }
}
