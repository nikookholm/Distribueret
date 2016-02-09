package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import GalgeLogik.Galgelogik;
import brugerautorisation.data.Bruger;

public interface iServerFunctions extends Remote {

	public Bruger login(String username, String password)
			throws RemoteException;

	public Galgelogik accessGL() throws RemoteException;

}