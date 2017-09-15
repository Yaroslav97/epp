package com.epam.poliakov.task9.web.factory.launch;

import com.epam.poliakov.task9.web.abstractFactory.ServerAbstractFactory;
import com.epam.poliakov.task9.web.factory.tcp.TCPServer;

public class TCPLauncher extends Thread {

    private TCPServer tcpServer;

    public TCPLauncher(ServerAbstractFactory factory) {
        tcpServer = factory.tcpServer();
    }

    @Override
    public void run() {
        tcpServer.create();
    }
}
