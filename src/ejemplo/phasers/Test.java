package ejemplo.phasers;

import java.util.concurrent.Phaser;

/**
 * Created by Ricardo on 01/07/2015.
 * Clase 25
 */
public class Test {

    final static int CUANTOS_HILOS = 5;

    public static void main(String[] args) {
        //Se debera esparar que los CUANTOS_HILOS hilos terminen
        Phaser phaser = new Phaser(CUANTOS_HILOS);

        for (int i = 0; i < CUANTOS_HILOS; i++) {
            //phaser.register();
            TareaPhasers t = new TareaPhasers(phaser, "Participante-" + i);
            t.start();
        }
        //Aqui deregistramos todos
        phaser.awaitAdvance(0);
        System.out.println("Terminado TODO");
    }
}
