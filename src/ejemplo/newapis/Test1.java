package ejemplo.newapis;

import java.time.*;

/**
 * Created by Ricardo on 03/07/2015.
 * Clase 26
 */
public class Test1 {
    public static void main(String[] args) {
        newAPI();
        oldAPI();
    }

    private static void oldAPI() {
        //TODO: Hacer lo mismo con old API
    }

    private static void newAPI() {
        LocalDate soloFecha = LocalDate.now();
        LocalTime soloHora = LocalTime.now();
        LocalDateTime todo = LocalDateTime.now();

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println("La fecha " + soloFecha);
        System.out.println("La hora " + soloHora);
        System.out.println("La fecha hora " + todo);
        System.out.println("La fecha hora y zona " + zonedDateTime);

        LocalDate myFecha = LocalDate.of(2015, Month.JULY, 2);
        LocalTime myHora = LocalTime.of(9, 21);

        System.out.println("Ayer fue: " + myFecha);
        System.out.println("La hora fue: " + myHora);
    }
}
