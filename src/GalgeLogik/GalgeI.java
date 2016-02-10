/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalgeLogik;

import java.util.ArrayList;

/**
 *
 * @author Inferno
 */
public interface GalgeI extends java.rmi.Remote {
    ArrayList<String> getBrugteBogstaver()      throws  java.rmi.RemoteException;
    String  getSynligtOrd()                     throws  java.rmi.RemoteException;
    int getAntalForkerteBogstaver()             throws  java.rmi.RemoteException;
    boolean erSpilletSlut()                     throws  java.rmi.RemoteException;
    void gætBogstav(String bogstav)             throws  java.rmi.RemoteException;
    void logStatus()                            throws  java.rmi.RemoteException;
    void nulstil()                              throws  java.rmi.RemoteException;
    boolean login(String user, String pass)     throws  Exception;
    public boolean connectServer()              throws  Exception;
    public boolean erSidsteBogstavKorrekt()     throws  Exception;
    public boolean erSpilletTabt()              throws  Exception;
}
