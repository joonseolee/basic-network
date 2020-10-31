package com.joons.server;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();

            ReceiveThread receiveThread = new ReceiveThread();
            receiveThread.setSocket(socket);
            SendThread sendThread = new SendThread();
            sendThread.setSocket(socket);

            receiveThread.start();
            sendThread.start();

//            basic test
//            OutputStream outputStream = socket.getOutputStream();
//
//            String message = "hello I'm joonseo";
//            outputStream.write(message.getBytes());
//
//            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
