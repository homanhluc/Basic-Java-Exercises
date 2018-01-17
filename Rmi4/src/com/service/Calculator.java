package com.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Calculator extends Remote {
	public ArrayList<?> RandomService(int num, int min, int max ) 			throws RemoteException;
}
