/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fechas;

/**
 *
 * @author Jordy
 */
public class DateEncryption {
    //Date String dd/mm/yyyy
    public static int encrypt(String date) throws Exception{
        
        String[] dateParts = date.split("/");
        if (dateParts.length != 3) throw new Exception();
            // Step 2: Convert each component to an integer
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        // Step 3: Combine the integers into a single integer
        int dateAsInt = year * 10000 + month * 100 + day;

        System.out.println(dateAsInt);  // This will print 20230909
        
            
        
        return 1;
    }
    
    
    public static String decrypt(int eDate){
        return "";
    }
    
    
}
