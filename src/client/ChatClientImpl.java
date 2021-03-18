package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import server.ChatServer;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClient, Runnable{
    private static final long serialVersionUID = 1L;
    private ChatServer chatServer;
    private String username = null;
    
	protected ChatClientImpl(String username, ChatServer chatServer) throws RemoteException {
		this.username = username;
		this.chatServer = chatServer;
		chatServer.registerChatClient(this);
	}

	public void retrieveMessage(String message) throws RemoteException {
		System.out.println(message);
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		String message;
		while(true)
		{
			message = sc.nextLine();
			
			try
			{
				chatServer.broadCastMessage("["+ username + "]: " + message);
			}
			catch(RemoteException e)
			{
				e.printStackTrace();
			}
		}
	}

}
