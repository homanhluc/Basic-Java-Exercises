package com.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import com.service.Calculator;

public class CalculatorClient {
	public static void main(String[] args) {
		//tạo host name cho client
		String host = (args.length < 1) ? null : args[0];
		
		try {
			//xác định vị trí máy chủ
			Registry registry = LocateRegistry.getRegistry(host, 8888);
			
			//khởi tạo đối tượng có thể kết nối đến máy chủ
			Calculator cal = (Calculator) registry.lookup("connect");
			
			
			System.out.println("kq: "+cal.calNumber(1, 10));

		} catch (Exception e) {
			System.err.println("Client can't start because Server not running!");
		}
	}
}
