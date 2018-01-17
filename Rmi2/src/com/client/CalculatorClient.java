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
			
			Scanner sc = new Scanner(System.in);
			
			int choose = 0;
			boolean kt = true;
			String text = "";
			
			do {
				System.out.print("Nhập chuỗi: ");
				text = sc.nextLine();
				
				System.out.print("---------------Menu-------------\n");
				System.out.print("1. Cắt khoảng trắng thừa của chuỗi\n");
				System.out.print("2. Đảo ngược chuỗi\n");
				System.out.print("3. Đếm số từ trong một chuỗi\n");
				System.out.print("4. Biến thành chuỗi in hoa\n");
				System.out.print("Bạn chọn:  ");
				
				choose = sc.nextInt();
				sc.nextLine();
				
				switch (choose) {
				case 1: {
					System.out.print("Text = " + cal.calRemoveWhiteSpace(text) + "\n");
					break;
				}
				case 2: {
					System.out.print("Text = " + cal.calReverseString(text) + "\n");
					break;
				}
				case 3: {
					System.out.print("Text = " + cal.calCountNumberString(text) + "\n");
					break;
				}
				case 4: {
					System.out.print("Text = " + cal.calUppercaseString(text) + "\n");
					break;
				}
					
				default: System.out.println("Sai Cu Phap!\n");
					break;
				}
			} while (kt);
			sc.close();

		} catch (Exception e) {
			System.err.println("Client can't start because Server not running!");
		}
	}
}
