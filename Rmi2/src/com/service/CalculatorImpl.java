package com.service;

import java.rmi.RemoteException;
import java.util.StringTokenizer;

public class CalculatorImpl implements Calculator {

	@Override
	public String calRemoveWhiteSpace(String text) throws RemoteException {
		// TODO Auto-generated method stub
		return text.replaceAll("\\s","");
	}

	@Override
	public String calReverseString(String text) throws RemoteException {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder(text);
		return sb.reverse().toString();
	}

	@Override
	public String calCountNumberString(String text) throws RemoteException {
		StringTokenizer st = new StringTokenizer(text);
		int count = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			count++;
		}
		return count+"";
	}

	@Override
	public String calUppercaseString(String text) throws RemoteException {
		// TODO Auto-generated method stub
		return text.toUpperCase().toString();
	}
}
