package com.epam.poliakov.task9.web.factory.tcp;

import com.epam.poliakov.task9.web.command.WebCommand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.epam.poliakov.task9.web.abstractFactory.PortConst.PORT_TCP;

public class TCPServerImpl implements TCPServer {

    private WebCommand webCommand;

    public TCPServerImpl(WebCommand webCommand) {
        this.webCommand = webCommand;
    }

    @Override
    public void create() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT_TCP);
            System.out.println("TCP get countserver started");
            while (true) {
                serverSocket.setSoTimeout(200000);
                Socket socket = serverSocket.accept();
                try {
                    new TCPServerThread(socket, webCommand).start();
                } catch (IOException e) {
                    socket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot obtain socket connection");
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.out.println("Cannot close serverSocket");
            }
        }
    }
}
