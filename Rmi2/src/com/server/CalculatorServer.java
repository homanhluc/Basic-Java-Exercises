package com.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.service.CalculatorImpl;


public class CalculatorServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(8888);
            
            CalculatorImpl obj = new CalculatorImpl();
            UnicastRemoteObject.exportObject(obj,0);
            registry.rebind("connect",obj);

            System.out.println("Server is running!!!");
            
        }
        catch (Exception e) {
            System.out.println("Loi" + e);
        }
    }
}
