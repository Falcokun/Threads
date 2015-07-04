package ejemplo.newapis;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by Ricardo on 03/07/2015.
 * Clase 26
 */
public class Test3 {
    public static void main(String[] args) {
        Instant i1 = Instant.ofEpochSecond(30);
        Instant i2 = Instant.ofEpochSecond(55);
        System.out.println("Instante 1 " + i1);
        System.out.println("Instante 2 " + i2);

        Duration t1 = Duration.ofSeconds(20);
        Duration t2 = Duration.ofSeconds(-15);
        System.out.println("Duracion 1 " + t1);
        System.out.println("Duracion 2 " + t2);

        System.out.println("i1 ocurre antes de i2 ? " + i1.isBefore(i2));
        System.out.println("i1 ocurre despues de i2 ? " + i1.isAfter(i2));

        Instant i3 = i1.plus(t1);
        Instant i4 = i2.plus(t2);
        System.out.println("Instante 3 " + i3);
        System.out.println("Instante 4 " + i4);

        Duration t3 = t1.plus(t2);
        System.out.println("Duracion 3 " + t3);
        //P-T Son parte del ISO
    }
}
