package com.epam.poliakov.task9.web.abstractFactory;

import com.epam.poliakov.task9.web.factory.http.HttpServer;
import com.epam.poliakov.task9.web.factory.tcp.TCPServer;

public interface ServerAbstractFactory {

    TCPServer tcpServer();

    HttpServer httpServer();
}
