package com.joons.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.function.Supplier;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);

            ReceiveThread receiveThread = new ReceiveThread();
            receiveThread.setSocket(socket);
            SendThread sendThread = new SendThread();
            sendThread.setSocket(socket);

            receiveThread.start();
            sendThread.start();

//            basic test
//            InputStream inputStream = socket.getInputStream();
//            byte[] receiveBuffer = new byte[100];
//            inputStream.read(receiveBuffer);
//
//            System.out.println(new String(receiveBuffer));
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
