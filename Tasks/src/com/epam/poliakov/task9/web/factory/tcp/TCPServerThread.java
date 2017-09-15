package com.epam.poliakov.task9.web.factory.tcp;

import com.epam.poliakov.task9.web.command.WebCommand;

import java.io.*;
import java.net.Socket;

public class TCPServerThread extends Thread {

    private WebCommand webCommand;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter out;

    public TCPServerThread(Socket socket, WebCommand webCommand) throws IOException {
        this.socket = socket;
        this.webCommand = webCommand;
        input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
    }

    public void run() {
        try {
            String req;
            while ((req = this.input.readLine()) != null) {
                if (req.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Client: " + req);
                out.println(webCommand.execute(req));
            }
        } catch (IOException e) {
            System.out.println("Cannot read input data");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}
