/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fechas;

import java.util.Scanner;

/**
 *
 * @author Jordy
 */
public class Fechas {

    private static int intDate;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String date;
        
        System.out.println("Ingrese la fecha en formato dd/mm/yyyy: ");
        date = scan.nextLine();
        scan.close();
        try{
            intDate = DateEncryption.encrypt(date);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
        String binaryString = Integer.toBinaryString(intDate);
        System.out.println("Binary representation: " + binaryString);
        String dDate = DateEncryption.decrypt(intDate);
        System.out.println(dDate);
    } 
    
    
}
