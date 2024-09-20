/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author marku
 */
public class CalculatorServer implements Calculator {

    public CalculatorServer() {}

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divide(int a, int b) throws RemoteException {
        if (b == 0) {
            throw new ArithmeticException("Division por cero");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        try {
            CalculatorServer obj = new CalculatorServer();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            // vinculacion de stub del objeto remoto en el regustro
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Calculator", stub);

            System.out.println("Servidor de calculadora listo");
        } catch (Exception e) {
            System.err.println("Excepcion de servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
