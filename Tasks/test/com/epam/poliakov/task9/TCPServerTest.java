package com.epam.poliakov.task9;

import com.epam.poliakov.task9.shop.controller.ConsoleManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPServerTest {

    public static final int COUNT_OF_PRODUCTS_IN_SHOP = 3;
    public static final int WRONG_COUNT_OF_PRODUCTS_IN_SHOP = 6;
    public static final String GET_COUNT = "get count";
    public static final String GET_ITEM_TESLA = "get item = tesla";
    public static final String SOME_WRONG_COMMANG = "some wrong commang";
    public static final String WRONG_COMMAND = "wrong command";
    public static final String TESLA_803043 = "tesla | 803043";

    private Thread thread;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    @Before
    public void init() throws IOException {
        thread = new Thread(() -> {
            ConsoleManager consoleCommand = new ConsoleManager();
            consoleCommand.command();
        });
        thread.start();

        socket = new Socket("localhost", 3000);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @After
    public void destroy() throws IOException {
        socket.close();
        in.close();
        out.close();

        thread.interrupt();
    }

    @Test
    public void testShouldCheckCommandGetCommandTCPServer() throws IOException, InterruptedException {
        out.println(GET_COUNT);
        String resp = in.readLine();
        assertEquals(COUNT_OF_PRODUCTS_IN_SHOP, Integer.parseInt(resp));

    }

    @Test
    public void testShouldCheckCommandGetCommandTCPServerWrongExpectedValue() throws Exception {
        out.println(GET_COUNT);
        String resp = in.readLine();
        assertNotEquals(WRONG_COUNT_OF_PRODUCTS_IN_SHOP, Integer.parseInt(resp));
    }

    @Test
    public void testShouldCheckCommandGetItemTCPServer() throws Exception {
        out.println(GET_ITEM_TESLA);
        String resp = in.readLine();
        assertEquals(TESLA_803043, resp);
    }

    @Test
    public void testShouldCheckWrongCommandTCPServer() throws Exception {
        out.println(SOME_WRONG_COMMANG);
        String resp = in.readLine();
        assertEquals(WRONG_COMMAND, resp);
    }
}
