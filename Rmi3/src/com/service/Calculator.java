package com.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public String calNumber	(int min, int max) 			throws RemoteException;
}
