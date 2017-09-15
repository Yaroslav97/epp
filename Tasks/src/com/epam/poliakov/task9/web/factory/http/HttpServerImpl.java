package com.epam.poliakov.task9.web.factory.http;

import com.epam.poliakov.task9.web.command.WebCommand;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.epam.poliakov.task9.web.abstractFactory.PortConst.PORT_HTTP;

public class HttpServerImpl implements HttpServer {

    private WebCommand webCommand;

    public HttpServerImpl(WebCommand webCommand) {
        this.webCommand = webCommand;
    }

    @Override
    public void create() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT_HTTP);
            System.out.println("HTTP server has started");
            while (true) {
                serverSocket.setSoTimeout(200000);
                Socket socket = serverSocket.accept();
                try {
                    new HttpServerThread(socket, webCommand).start();
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
