package com.epam.poliakov.task9.web.abstractFactory;

import com.epam.poliakov.task9.web.command.WebCommand;
import com.epam.poliakov.task9.web.factory.http.HttpServer;
import com.epam.poliakov.task9.web.factory.http.HttpServerImpl;
import com.epam.poliakov.task9.web.factory.tcp.TCPServer;
import com.epam.poliakov.task9.web.factory.tcp.TCPServerImpl;

public class ServerFactory implements ServerAbstractFactory {

    private WebCommand webCommand;

    public ServerFactory(WebCommand webCommand) {
        this.webCommand = webCommand;
    }

    @Override
    public TCPServer tcpServer() {
        return new TCPServerImpl(webCommand);
    }

    @Override
    public HttpServer httpServer() {
        return new HttpServerImpl(webCommand);
    }
}
