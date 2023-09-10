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
        if (!DateValidation.dateIsValid(date));
        
        // String:  15/09/1987
        String[] dateParts = date.split("/");
        // int:   15 bin: 1111
        int day = Integer.parseInt(dateParts[0]);
        // int:    9 bin: 1001
        int month = Integer.parseInt(dateParts[1]);
        // int: 1987 bin: 0111 1100 0011
        int year = Integer.parseInt(dateParts[2]);
        
        int intDate = 0;
        /*
        Date bin:   0000 0000 0000 0000 0000 0000 0000 0000
              OR    0000 0000 0000 0000 0000 0000 0000 1111 << += 5 bits
              OR    0000 0000 0000 0000 0000 0001 0010 1111 << += 4 bits
              OR    0000 0000 0000 1111 1000 0111 0010 1111
                    ---------------------------------------
        Date bin:   0000 0000 0000 1111 1000 0111 0010 1111
        Date int:   1017647
        */
        int desplaza = 0;
        
        intDate |= day;
        desplaza += 5;
        intDate |= month << desplaza;
        desplaza += 4;
        intDate |= year << desplaza;
    
        return intDate;
    }
    
    
    public static String decrypt(int eDate){
        int year = ((eDate & 0xFFFFFE00) >> 9);
        /*
                                YYYY   MM    DD
        ----------------------------+ +++- ----
        0000 0000 0000 1111 1000 0111 0010 1111
        1111 1111 1111 1111 1111 1110 0000 0000 AND
        ---------------------------------------
        0000 0000 0000 1111 1000 0110 0000 0000
        
        0000 0000 0000 0000 0000 0111 1100 0011 >> 9
        int: 1987
        */
        int month = (eDate & 0x1E0) >> 5;
        /*
                                YYYY   MM    DD
        ----------------------------+ +++- ----
        0000 0000 0000 1111 1000 0111 0010 1111
        0000 0000 0000 0000 0000 0001 1110 0000 AND
        ---------------------------------------
        0000 0000 0000 0000 0000 0001 0010 0000
        
        0000 0000 0000 0000 0000 0000 0000 1001 >> 5
        int: 9
        */
        int day = (eDate & 0x1F);
        /*
                                YYYY   MM    DD
        ----------------------------+ +++- ----
        0000 0000 0000 1111 1000 0111 0010 1111
        0000 0000 0000 0000 0000 0000 0001 1111 AND
        ---------------------------------------
        0000 0000 0000 0000 0000 0000 0000 1111
        int: 15
         */       
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
