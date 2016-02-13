package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import brugerautorisation.data.Bruger;

public interface iServerFunctions extends Remote {

	public Bruger login(String username, String password)
			throws RemoteException;

	public void gætBogstav(String bogstav) throws RemoteException;
	public String getSynligtOrd() throws RemoteException;
	public ArrayList<String> getBrugteBogstaver() throws RemoteException;
	public String getOrdet() throws RemoteException;
	public  int getAntalForkerteBogstaver() throws RemoteException;
	public  boolean erSidsteBogstavKorrekt() throws RemoteException;
	public  boolean erSpilletVundet() throws RemoteException;
	public boolean erSpilletTabt() throws RemoteException;
	public boolean erSpilletSlut() throws RemoteException;
	public void nulstil() throws RemoteException;
	public void logStatus() throws RemoteException;
	public void hentOrdFraDr() throws RemoteException;

}