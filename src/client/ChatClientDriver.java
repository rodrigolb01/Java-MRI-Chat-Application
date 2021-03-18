package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Scanner;

import server.ChatServer;

public class ChatClientDriver {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException
	{
		System.out.println("Starting chat client...");
		ChatServer chatServer = (ChatServer) Naming.lookup("rmi://127.0.0.1:32001/CalculatorService");
		
		Scanner sc = new Scanner(System.in);
		Random clientId = new Random();
		String clientUsername; //you should register the client in the server
		
		System.out.print("Enter your username: ");
		clientUsername = sc.next();
		
		System.out.println("Cliente Id:" + clientId.nextInt(999));
		System.out.println("Cliente Username: " + clientUsername);
		System.out.println("You are connected to the chat: ");
		System.out.println();
		
		new Thread(new ChatClientImpl(clientUsername, chatServer)).start();
	}

}
