package ru.demi.app.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * @author demi
 * @date 05.03.16
 */
public class Client extends Thread {

    private static final Logger logger = LogManager.getLogger(Client.class);
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;
    private String content;
    private int port;
    private int maxTime;

    public Client(String content, int port, int maxTime) throws IOException {
        this.content = content;
        this.port = port;
        this.maxTime = maxTime;
        this.socket = new Socket("localhost", port);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run() {
        long start = new Date().getTime();
        try {
            while ((new Date().getTime() - start) < maxTime) {

                writer.println(content);
                writer.flush();

                String s;
                s = reader.readLine();
                System.out.println(this + ": " + s);

                Thread.sleep(1);
            }

        } catch (IOException | InterruptedException e) {
            logger.warn(e);
        }
    }

    public static void main(String[] args) throws IOException {
        new Client("client 1", 5050, 100).start();
    }
}
