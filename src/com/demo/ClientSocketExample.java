package com.demo;

import java.io.*;
import java.net.Socket;

public class ClientSocketExample {

    public static void main(String[] args) {
        try {
            System.out.println ("Started ..");
            Thread.sleep (5000l);
            Socket socket = new Socket ("www.google.com", 80);  // host, port
            socket.setSoTimeout (150000); // socket will wait for 15 sec for response

            // writing to socket
            System.out.println ("Writing to socket!");
            Writer writer = new OutputStreamWriter (socket.getOutputStream (), "UTF-8");
            writer.write ("GET / HTTP/1.1 Whatspp \r\n");
            writer.flush ();

            // reading from socket
            InputStream inputStream = socket.getInputStream ();
            int ch = 0;
            System.out.println ("Reading");
            System.out.println (inputStream.read ());
            while((ch = inputStream.read ()) != -1) {
                System.out.print ((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println ("socket reading is complete");
    }
}
