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
        
        String[] dateParts = date.split("/");
        
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);
        
        String binday = Integer.toBinaryString(day);
        String binmonth = Integer.toBinaryString(month);
        String binyear = Integer.toBinaryString(year);
        
        String buildDay = StringBinBuilder(binday,5);
        String buildMonth = StringBinBuilder(binmonth,4);
        String buildYear = StringBinBuilder(binyear,23);
        
        String eDate = buildYear + buildMonth + buildDay;
        return Integer.parseInt(eDate, 2);
    }
    
    private static String StringBinBuilder (String binaryString,int ceros){
        // Asegura que la cadena tenga exactamente 5 bits rellenando con ceros a la izquierda si es necesario
        if (binaryString.length() < ceros) {
            int numZeroesToAdd = ceros - binaryString.length();
            StringBuilder zeroes = new StringBuilder();
            for (int i = 0; i < numZeroesToAdd; i++) {
                zeroes.append('0');
            }
            binaryString = zeroes.toString() + binaryString;
        }
        return binaryString;
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
