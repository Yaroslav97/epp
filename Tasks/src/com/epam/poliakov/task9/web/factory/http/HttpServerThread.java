package com.epam.poliakov.task9.web.factory.http;

import com.epam.poliakov.task9.web.command.WebCommand;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class HttpServerThread extends Thread {

    private WebCommand webCommand;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter out;

    public HttpServerThread(Socket socket, WebCommand webCommand) throws IOException {
        this.socket = socket;
        this.webCommand = webCommand;
        input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    }

    private String header(String resp) {
        StringBuilder builder = new StringBuilder();

        builder.append("HTTP/1.1 200 OK\r\n")
                .append("Server: Personal/")
                .append(new Date().toString())
                .append("\r\n")
                .append("Content-Type: application/json\r\n")
                .append("Content-Length: ")
                .append(resp.getBytes().length)
                .append("\r\n")
                .append("Connection: close\r\n\r\n")
                .append(resp);

        return builder.toString();
    }

    public void run() {
        try {
            String req = input.readLine();

            out.write(header(webCommand.execute(req)));
            out.println(header(webCommand.execute(req)));
        } catch (IOException e) {
            System.out.println("Cannot read inputed data");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}