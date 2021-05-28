/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calaculadora;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author romero
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
       
       try {
           Registry miRegistro = LocateRegistry.getRegistry("localhost", 1099); //usar otro puerto
           calculadora c = (calculadora) Naming.lookup("//192.168.88.15/Calculadora");
           
           while (true){
               String menu = JOptionPane.showInputDialog("Ejercicio Calculadora \n" + 
                       "Suma ..... (1) \n" +
                       "Resta ....  (2) \n" + 
                       "Multiplicacion ..... (3) \n" + 
                       "Divicion ..... (4) \n\n" + 
                       "CANCELAR PARA SALIR ");
               switch (menu) {
                   case "1":
                   {
                      int x = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el primer numero"));
                      int y = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el segundo numero"));
                      JOptionPane.showInputDialog(null, "La Suma es: " +c.add(x,y));
                      break;
                   }
                   case "2":
                   {
                       int x = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el primer numero"));
                      int y = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el segundo numero"));
                      JOptionPane.showInputDialog(null, "La Resta es: " +c.sub(x,y));
                      break;
                   }
                   case "3":
                   {
                       int x = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el primer numero"));
                      int y = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el segundo numero"));
                      JOptionPane.showInputDialog(null, "La Multiplicacion es: " +c.mul(x,y));
                      break;
                   }
                   case"4":
                   {
                      int x = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el primer numero"));
                      int y = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el segundo numero"));
                      JOptionPane.showInputDialog(null, "La Divicion es: " +c.div(x,y));
                      break;
                   }
                       
               }
           }
       }catch(Exception e){
           JOptionPane.showInputDialog("Servidor no  Conectado" + e);
       }
        
    }
    
}
