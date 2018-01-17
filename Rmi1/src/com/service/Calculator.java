package com.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public int calHinhChuNhat	(int a, int b) 			throws RemoteException;
    public int calHinhTron		(int r) 				throws RemoteException;
    public int calHinhTamGiac	(int a, int h) 			throws RemoteException;
    public int calHinhThang		(int a, int b, int h) 	throws RemoteException;
}
