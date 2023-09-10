/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fechas;

/**
 *
 * @author Jordy
 */
public class DateValidation {
    public static boolean dateIsValid(String fecha) throws Exception{
        // Verificamos si la fecha tiene el formato correcto
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new Exception("La fecha no tiene el formato correcto");
        }

        // Parseamos el día, mes y año
        String[] partes = fecha.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        // Verificamos que el mes esté en el rango válido (1-12)
        if (mes < 1 || mes > 12) {
            throw new Exception("El mes no se encuentra en un rango valido");
        }
        // Verificamos que el día esté en el rango válido para el mes

        if (dia >= 1 && dia <= daysInMonth(mes, anio)) {
            return true;
        } else {
            return false;
        }
    }
    
    private static int daysInMonth(int mes, int anio) {
        if (mes == 2) {
            // Febrero
            if (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0)) {
                // Año bisiesto
                return 29;
            } else {
                return 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            // Abril, junio, septiembre, noviembre
            return 30;
        } else {
            // Otros meses
            return 31;
        }
    }
}
