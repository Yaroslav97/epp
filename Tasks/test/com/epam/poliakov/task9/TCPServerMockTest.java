package com.epam.poliakov.task9;

import com.epam.poliakov.task9.web.command.WebCommand;
import com.epam.poliakov.task9.web.factory.tcp.TCPServerThread;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static com.epam.poliakov.task9.web.abstractFactory.PortConst.PORT_TCP;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TCPServerMockTest {

    public static final String COUNT_OF_PRODUCTS_IN_SHOP = "5";
    public static final String GET_COUNT = "get count";
    public static final String GET_ITEM_TESLA = "get item = tesla";
    public static final String RESPONSE_ON_COMMAND_GET_ITEM = "tesla | 803043";
    public static final String WRONG_COMMAND = "wrong command";
    public static final String LOCALHOST = "localhost";
    public static final int PORT = 3000;

    private Thread thread;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ServerSocket serverSocket;

    @Mock
    private WebCommand command;

    @Before
    public void init() throws IOException {
        command = Mockito.mock(WebCommand.class);

        thread = new Thread() {
            @Override
            public void run() {

                try {
                    serverSocket = new ServerSocket(PORT_TCP);
                    Socket socket = serverSocket.accept();
                    new TCPServerThread(socket, command).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @After
    public void destroy() throws IOException {
        socket.close();
        serverSocket.close();
        in.close();
        out.close();

        thread.interrupt();
    }

    @Test
    public void testShouldCheckGetItemCommandTCPServer() throws IOException {

        when(command.execute(GET_ITEM_TESLA)).thenReturn(RESPONSE_ON_COMMAND_GET_ITEM);

        thread.start();

        socket = new Socket("localhost", 3000);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        out.println(GET_ITEM_TESLA);

        verify(command).execute(GET_ITEM_TESLA);
    }

    @Test
    public void testShouldCheckGetCountCommandTCPServer() throws IOException {

        when(command.execute(GET_COUNT)).thenReturn(COUNT_OF_PRODUCTS_IN_SHOP);

        thread.start();

        socket = new Socket(LOCALHOST, PORT);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        out.println(GET_COUNT);

        verify(command).execute(GET_COUNT);
    }

    @Test
    public void testShouldCheckWrongCommandCommandTCPServer() throws IOException {

        when(command.execute(WRONG_COMMAND)).thenReturn(WRONG_COMMAND);

        thread.start();

        socket = new Socket(LOCALHOST, PORT);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        out.println(WRONG_COMMAND);

        verify(command).execute(WRONG_COMMAND);
    }
}
