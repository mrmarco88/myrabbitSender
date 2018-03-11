package com.filelife.myrabbitSender;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AmqpSender rmqs = new RabbitmqSender();
        
        rmqs.sendMessage("Maronn");
    }
}
