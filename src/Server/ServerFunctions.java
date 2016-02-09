package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import GalgeLogik.Galgelogik;
import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;

public class ServerFunctions extends UnicastRemoteObject implements iServerFunctions {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3422323;
	private transient Galgelogik  gl;
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
			return ba.hentBruger(username, password);
		}
		catch (Exception e)
		{
			throw new RemoteException("Kunne ikke logge ind");
		}
	}
	

	public Galgelogik accessGL() throws RemoteException
	{
		return gl;
		


	}
	

	
	
}
