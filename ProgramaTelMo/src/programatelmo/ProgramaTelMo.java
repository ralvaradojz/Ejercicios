
package programatelmo;
import java.io.*;
import java.util.Scanner;

public class ProgramaTelMo {

    
    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        String numeroTelefono = "32110995";
        double consultaSaldo = 25;
        double totalTranferencia = 0;
        double totalPrestamo = 50;
        double saldoPendiente = 0;
        int mensajesTexto = 10;
        double monto = 0;
        int resp = 0;
        
        while(resp != -1){
            System.out.println("---- Menu ---- ");
            System.out.println(" 1. Consulta de Saldo "); 
            System.out.println(" 2. Transferir Saldo ");
            System.out.println(" 3. Solicitar Prestamito");
            System.out.println("-1. Salir ");
            System.out.println(" Que desea realizar... ? ");
            resp = datos.nextInt(); 
            
            switch(resp){
                case 1:
                    System.out.println("");
                    System.out.println("----------------------------------------");
                    System.out.println("El saldo disponible de su "+numeroTelefono+" es");
                    
                    System.out.println("Saldo... "+consultaSaldo+" lps.");
                    System.out.println("Mensajes de texto disponibles "+mensajesTexto);
                    System.out.println("Transferencias realizadas...   ("+totalTranferencia+")"+" lps.");
                    System.out.println("----------------------------------------");
                    System.out.println("Saldo disponible...   "+consultaSaldo+" lps.");
                    System.out.println("----------------------------------------");
                    System.out.println("Saldo del prestamo pendiente....  "+saldoPendiente+" lps.");
                    break;
                case 2: 
                    System.out.println("");
                    System.out.println("Debito del numero #"+numeroTelefono);
                    System.out.println("Saldo disponible...   "+consultaSaldo+" lps.");
                    System.out.println("Ingrese el monto a transferir... ");
                    monto = datos.nextDouble();
                    
                    if((consultaSaldo-monto)> 10){
                        totalTranferencia += monto;
                        consultaSaldo = consultaSaldo - totalTranferencia;
                    }else{
                        System.err.println("No se puede transferir, monto mayor al disponible");
                        resp = 1;
                    }
                    break;
                case 3: 
                    System.out.println("----------------------------------------");
                    System.out.println("Prestamito para el numero #"+numeroTelefono);
                    System.out.println("Ingrese el monto solicitado... ");
                    monto = datos.nextDouble();
                    if(monto<(consultaSaldo*3)+1){
                        totalTranferencia += monto;
                        saldoPendiente +=monto;
                        consultaSaldo = totalPrestamo - totalTranferencia;
                    }else{
                       System.err.println("Monto no valido, excede el permitido.");
                       resp = 0; 
                    }
                    break;
                default: 
                        resp = 0;
            }
            System.out.println("");
            System.out.println(" ===================================================  "); 
            System.out.println(" Presione -1 para salir, 0 para volver al menu ");
            resp = datos.nextInt();
        }
    }
    
}
