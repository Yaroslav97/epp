package com.epam.poliakov.task9.web.factory.launch;

import com.epam.poliakov.task9.web.abstractFactory.ServerAbstractFactory;
import com.epam.poliakov.task9.web.factory.http.HttpServer;

public class HTTPLauncher extends Thread {

    private HttpServer httpServer;

    public HTTPLauncher(ServerAbstractFactory factory) {
        httpServer = factory.httpServer();
    }

    @Override
    public void run() {
        httpServer.create();
    }
}
