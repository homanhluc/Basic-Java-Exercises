package com.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
	//extends UnicastRemoteObject để cho phép đối tượng có khả năng truy xuất từ xa
    public CalculatorImpl() throws RemoteException {}

    @Override
    public int calHinhChuNhat(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public int calHinhTron(int r) throws RemoteException {
        return (int)(3.14 * r * r);
    }

    @Override
    public int calHinhTamGiac(int a, int h) throws RemoteException {
        return (a * h) / 2;
    }

    @Override
    public int calHinhThang(int a, int b, int h) throws RemoteException {
        return h * ((a + b) / 2);
    }
}
