package com.joons.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread {

    private Socket socket;

    @Override
    public void run() {
        super.run();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            String message;

            while(true) {
                message = bufferedReader.readLine();
                printWriter.write(message);
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
