package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import GalgeLogik.Galgelogik;
import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;

public class ServerFunctions extends UnicastRemoteObject implements iServerFunctions
{
	
	private static final long serialVersionUID = 3422323;
	private boolean 		  authenticated    = false;

	private Galgelogik  gl;
	private Brugeradmin ba;
	
	public ServerFunctions(Galgelogik gl, Brugeradmin ba) throws RemoteException
	{
		this.gl = gl;
		this.ba = ba;
	}
	
	public Bruger login(String username, String password) throws RemoteException
	{
		try
		{
			authenticated = true;
			return ba.hentBruger(username, password);
		}
		catch (Exception e)
		{
			throw new RemoteException("Kunne ikke logge ind");
		}
	}
	public void gætBogstav(String bogstav) throws RemoteException
	{
		if (authenticated)
		{
			gl.gætBogstav(bogstav);			
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	}
	public String getSynligtOrd() throws RemoteException
	{	
		if (authenticated)
		{
			return gl.getSynligtOrd();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	}
	public ArrayList<String> getBrugteBogstaver() throws RemoteException {
		if (authenticated)
		{
			return gl.getBrugteBogstaver();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	}
	public String getOrdet() throws RemoteException {
		if (authenticated)
		{
			return gl.getOrdet();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	}
	public int getAntalForkerteBogstaver() throws RemoteException {
		if (authenticated)
		{
			return gl.getAntalForkerteBogstaver();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	}
	public boolean erSidsteBogstavKorrekt() throws RemoteException {
		if (authenticated)
		{
			return gl.erSidsteBogstavKorrekt();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	}
	public boolean erSpilletVundet() throws RemoteException {
		if (authenticated)
		{
			return gl.erSpilletVundet();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	}
	public boolean erSpilletTabt() throws RemoteException {
		if (authenticated)
		{
			return gl.erSpilletTabt();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	}
	public boolean erSpilletSlut() throws RemoteException {
		if (authenticated)
		{
			return gl.erSpilletSlut();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	}
	public void nulstil() throws RemoteException {
		if (authenticated)
		{
			gl.nulstil();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
		
	}
	public void logStatus() throws RemoteException {
		if (authenticated)
		{
			gl.logStatus();
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}
	
	}
	public void hentOrdFraDr() throws RemoteException {
		if (authenticated)
		{
			try {
				gl.hentOrdFraDr();
			} catch (Exception e) {
				throw new RemoteException("Error getting words from DR ...");
			}
		}
		else
		{
			throw new RemoteException("User not authenticated :");
		}

	}
	
}
