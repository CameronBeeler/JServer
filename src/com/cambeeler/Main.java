package com.cambeeler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args)
    {
	// write your code here
        try(ServerSocket ss = new ServerSocket(5000))
        {
            while(true)
            {
                new Echoer (ss.accept()).start();
            }
        }
        catch (IOException e)
        {
            System.out.println("Server Exception: " + e.getMessage());
        }

    }

}
