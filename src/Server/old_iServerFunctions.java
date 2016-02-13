package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import GalgeLogik.IGalgelogik;
import brugerautorisation.data.Bruger;

public interface old_iServerFunctions extends Remote {

	public Bruger login(String username, String password)
			throws RemoteException;

	//public IGalgelogik accessGL() throws RemoteException;

}