package com.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import com.service.Calculator;

public class CalculatorClient {
	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		
		try {
			Registry registry = LocateRegistry.getRegistry(host, 8888);
			
			Calculator cal = (Calculator) registry.lookup("connect");
			
			System.out.println("kq: "+cal.RandomService(4, 1, 10));

		} catch (Exception e) {
			System.err.println("Client can't start because Server not running!");
		}
	}
}
