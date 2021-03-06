package Server;

import java.rmi.Naming;

import GalgeLogik.Galgelogik;
import brugerautorisation.transport.rmi.*;


public class Server {
	
	private Brugeradmin ba;
	private Galgelogik gl;

	public static void main(String[] args) {
	
		Server server = new Server();
		
	}
	
	public Server()
	{
		try {
			Initialize();
			run();
		} catch (Exception e) {
			System.err.println("Could not initialize server :(");
		}
		
	}
	private void Initialize() throws Exception
	{
		 ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
		 gl = new Galgelogik();
		 iServerFunctions sfsf = new ServerFunctions(gl, ba);
		 
		 java.rmi.registry.LocateRegistry.createRegistry(1099);
		 Naming.rebind("rmi://localhost/galgeleg", sfsf);
		 System.out.println("Server started ...");
	}
	
	private void run()
	{
		
		try {
			Thread.sleep(200);
			run();
		} catch (InterruptedException e) { 
			System.err.println("Server has stopped running - it's a sad day");
		}
		
	}
	
	


}
