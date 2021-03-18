package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import client.ChatClient;

public interface ChatServer extends Remote{
	void registerChatClient(ChatClient client) throws RemoteException;
	void broadCastMessage(String message) throws RemoteException;
}
