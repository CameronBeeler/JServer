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
            Socket sock = ss.accept();  // will block until a client connects to this server
            System.out.println("Client Connected successfully");
            BufferedReader input = new BufferedReader( new InputStreamReader(sock.getInputStream()) );
            PrintWriter output = new PrintWriter(sock.getOutputStream(), true);

            while(true)
            {
                String echoString = input.readLine();
                if(echoString.equalsIgnoreCase("exit") )
                    break;
                output.println("Echo from server: " + echoString); // this is the msg sent to the client
                System.out.println(echoString);
            }
        }
        catch (IOException e)
        {
            System.out.println("Server Exception: " + e.getMessage());
        }

    }

}
