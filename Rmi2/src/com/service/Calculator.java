package com.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public String calRemoveWhiteSpace	(String text) 	throws RemoteException;
    public String calReverseString		(String text) 	throws RemoteException;
    public String calCountNumberString	(String text) 	throws RemoteException;
    public String calUppercaseString	(String text) 	throws RemoteException;
}
