/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.sekilaclient;

import java.net.*;
import java.io.*;

/**
 *
 * @author Markus
 */
public class Client {

    private String ip;
    private int port = 2048;

    public Client() {

    }

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public byte[] connect(Object send) {
        try (Socket socket = new Socket(ip, port)) {

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            writer.println(send);

            InputStream input = socket.getInputStream();

            byte[] result = input.readAllBytes();
            socket.close();
            return result;

        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
        return null;
    }
}
