package com.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.service.CalculatorImpl;


public class CalculatorServer {
    public static void main(String[] args) {
        try {
        	//đăng ký một máy chủ
            Registry registry = LocateRegistry.createRegistry(8888);
            
            //khởi tạo đối tượng có khả năng truy xuất từ xa
            CalculatorImpl obj = new CalculatorImpl();
            
            //đăng ký đối tượng này tại localhost = connect
            //rebind để tránh lỗi repeat name
            registry.rebind("connect",obj);
            
            System.out.println("Server is running!!!");
        }
        catch (Exception e) {
            System.out.println("Loi" + e);
        }
    }
}
