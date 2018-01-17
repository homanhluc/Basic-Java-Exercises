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
			
			Scanner sc = new Scanner(System.in);
			
			int choose = 0;
			boolean kt = true;
			
			do {
				System.out.print("---------------Menu-------------\n");
				System.out.print("1. Tính diện tích hình chữ nhật.\n");
				System.out.print("2. Tính diện tích hình tròn.\n");
				System.out.print("3. Tính diện tích hình tam giác.\n");
				System.out.print("4. Tính diện tích hình thang.\n");
				System.out.print("Bạn chọn:  ");
				choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
				case 1: {
					System.out.print("Nhập cạnh a: ");
					int a = sc.nextInt();
					System.out.print("Nhập cạnh b: ");
					int b = sc.nextInt();
					System.out.print("S = " + cal.calHinhChuNhat(a, b) + "\n");
					break;
				}
				case 2: {
					System.out.print("Nhập bán kính r: ");
					int r = sc.nextInt();
					System.out.print("S = " + cal.calHinhTron(r) + "\n");
					break;
				}
				case 3: {
					System.out.print("Nhập cạnh đáy a: ");
					int a = sc.nextInt();
					System.out.print("Nhập chiều cao h: ");
					int h = sc.nextInt();
					System.out.print("S = " + cal.calHinhTamGiac(a, h) + "\n");
					break;
				}
				case 4: {
					System.out.print("Nhập cạnh a: ");
					int a = sc.nextInt();
					System.out.print("Nhập cạnh b: ");
					int b = sc.nextInt();
					System.out.print("Nhập chiều cao h: ");
					int h = sc.nextInt();
					System.out.print("S = " + cal.calHinhThang(a, b, h) + "\n");
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
