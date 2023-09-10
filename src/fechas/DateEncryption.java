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
    
    private static String StringBinBuilder (String binaryString,int bits){
        // Asegura que la cadena tenga exactamente 5 bits rellenando con ceros a la izquierda si es necesario
        if (binaryString.length() < bits) {
            int numZeroesToAdd = bits - binaryString.length();
            StringBuilder zeroes = new StringBuilder();
            for (int i = 0; i < numZeroesToAdd; i++) {
                zeroes.append('0');
            }
            binaryString = zeroes.toString() + binaryString;
        }
        return binaryString;
    }
    
    public static String decrypt(int eDate){
        String binDate = Integer.toBinaryString(eDate);
        String binaryDate = StringBinBuilder(binDate,32);
        
        int day = Integer.parseInt(binaryDate.substring(27, 32), 2);
        int month = Integer.parseInt(binaryDate.substring(23, 27), 2);
        int year = Integer.parseInt(binaryDate.substring(0, 23), 2);

        String dateString = String.format("%02d/%02d/%04d", day, month, year);
        return dateString;
    }
}
