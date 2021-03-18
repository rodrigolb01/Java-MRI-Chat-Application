package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import client.ChatClient;


public class ChatServerImpl extends UnicastRemoteObject implements ChatServer{
	private static final long serialVersionUID = 1L;
	private ArrayList<ChatClient> chatClients;
	protected ChatServerImpl() throws RemoteException {
		chatClients = new ArrayList<ChatClient>();
	}

	public void registerChatClient(ChatClient client) throws RemoteException {
		this.chatClients.add(client);
	}

	public void broadCastMessage(String message) throws RemoteException {
		for(int i=0; i<chatClients.size(); i++)
		{
			chatClients.get(i).retrieveMessage(message);
		}
	}
}
