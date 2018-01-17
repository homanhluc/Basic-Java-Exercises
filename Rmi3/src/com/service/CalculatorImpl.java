package com.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
	private static final String Prime = null;
	//extends UnicastRemoteObject để cho phép đối tượng có khả năng truy xuất từ xa
    public CalculatorImpl() throws RemoteException {}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public String calNumber(int min, int max) throws RemoteException {
    	ArrayList arr = new ArrayList();
    	for(int i = min ;i < max; i++){
			if(checkNumber(i)==true && i!=0){
				//System.out.println(Thread.currentThread().getName()+ " / "+i);
				arr.add(i);
			}
		}
		return arr.toString();
    }
    public static boolean checkNumber(int n) {
    	int dem=0;
	    if(n==1)
	       dem++;
	    else
	    {
	       for (int i=2; i<=n/2;i++)
	       {
	          if(n%i==0)
	          dem++;
	       }
	    }
	    if (dem==0){
	       return true;
	    }
	    else
	       return false;
    }
}
