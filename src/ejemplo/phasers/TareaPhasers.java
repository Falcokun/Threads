package ejemplo.phasers;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 01/07/2015.
 * Clase 25
 */
public class TareaPhasers extends Thread {
    private Phaser phaser;
    private String nombre;
    private Random r = new Random();

    public TareaPhasers(Phaser phaser, String nombre) {
        this.phaser = phaser;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Iniciando");
        int dormirTime = r.nextInt(10) + 1;
        try {
            TimeUnit.SECONDS.sleep(dormirTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Esperando completar la fase " + nombre);
        phaser.arriveAndDeregister();
        phaser.awaitAdvance(0);
        System.out.println("Plasando la fase");
    }
}
