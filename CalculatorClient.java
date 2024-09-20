/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author marku
 */
public class CalculatorClient {
    private CalculatorClient(){}
    
    public static void main(String[] args) {
        try {
            //Obtiene el registro
            Registry registry = LocateRegistry.getRegistry(null);
            
            //Busca el objeto remoto
            Calculator stub = (Calculator) registry.lookup("Calculator");
            
            //Llama a los metodos remotos
            int a=5, b=3;
            System.out.println("Suma: " + stub.add(a, b));
            System.out.println("Resta: " + stub.subtract(a, b));
            System.out.println("Multiplicacion: " + stub.multiply(a, b));
            System.out.println("Division: " + stub.divide(a, b));
            
        } catch (Exception e) {
            System.err.println("Excepcion del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
    
}
