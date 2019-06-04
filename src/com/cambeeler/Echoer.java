package com.cambeeler;

import java.io.*;
import java.net.Socket;

public
class Echoer extends Thread
{
    private Socket socket;

    public Echoer(Socket socket)
    {
        System.out.println("Socket Connection is made");
       this.socket = socket;
    }

    @Override
    public
    void run()
    {
        try
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while(true)
            {
                String echoString = input.readLine();
                if(echoString.equalsIgnoreCase("exit"))
                {
                    break;
                }
                System.out.println("Echoing this string: " + echoString);
                output.println(echoString); // Returns the String back to the Client
            }
        }
        catch (IOException  e)
        {
            System.out.println("Oops " + e.getMessage());
        } finally
        {
            try
            {
                socket.close();
            } catch (IOException e)
            {
                System.out.println("Failed to close the socket " + e.getMessage());
            }
        }
    }
}
