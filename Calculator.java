/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;


import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author marku
 */
public interface Calculator extends Remote {
    int add (int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
    int multiply(int a, int b) throws RemoteException;
    double divide(int a, int b) throws RemoteException;
    
}
