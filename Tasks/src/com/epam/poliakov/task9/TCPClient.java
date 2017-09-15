package com.epam.poliakov.task9;

import java.io.*;
import java.net.Socket;

import static com.epam.poliakov.task9.web.abstractFactory.PortConst.PORT_TCP;

/**
 * TCP client for connections to TCP server.
 */
public class TCPClient {

    public static final String IP = "localhost";

    public void client() {
        try (
                Socket socket = new Socket(IP, PORT_TCP);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            BufferedReader inputer = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("$ ");

            String user = inputer.readLine();
            if (user.equalsIgnoreCase("exit")) {
                System.exit(100);
            }
            out.println(user);

            String server = in.readLine();
            System.out.println("Console shop: " + server);
        } catch (IOException e) {
            System.out.println("Cannot obtain socket connection");
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to console shop");

        TCPClient tcpClient = new TCPClient();
        while (true) {
            tcpClient.client();
        }
    }
}
