package ru.demi.app.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author demi
 * @date 05.03.16
 */
public class ClientTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        int numClients = 10;
        List<Client> clients = new ArrayList<>(numClients);
        Date start = new Date();

        for (int i = 0; i < numClients; i++) {
            Client client = new Client("client " + i, 5050, 5000);
            clients.add(client);
            client.start();
        }

        for (int i = 0; i < numClients; i++) {
            clients.get(i).join();
        }

        Date end = new Date();
        System.out.println("Difference : " + (end.getTime() - start.getTime()));
    }
}
