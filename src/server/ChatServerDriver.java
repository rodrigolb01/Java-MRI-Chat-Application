package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ChatServerDriver {

	public static void main(String[] args) throws RemoteException, MalformedURLException{
		System.out.println("Starting chat server..");
		LocateRegistry.createRegistry(32001);
		Naming.rebind("rmi://127.0.0.1:32001/CalculatorService", new ChatServerImpl());
	}

}
