package com.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

	public CalculatorImpl() throws RemoteException {
	}
	@Override
	public ArrayList<Integer> RandomService(int num, int min, int max) throws RemoteException {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		int mm=0;
		Random rand = new Random();
		for (int i = min; i <= max; i++) {
			if (checkNumber(i) == true && i != 0) {
				arr.add(i);
			}
		}
		for(int i = 0;i<num;i++) {
			mm = rand.nextInt(arr.size());
			arr2.add(arr.get(mm));
		}
		return arr2;
	}

	// kiem tra so nt
	public static boolean checkNumber(int n) {
		int dem = 0;
		if (n == 1)
			dem++;
		else {
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0)
					dem++;
			}
		}
		if (dem == 0) {
			return true;
		} else
			return false;
	}

}
