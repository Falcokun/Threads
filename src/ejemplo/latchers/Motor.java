package ejemplo.latchers;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 01/07/2015.
 * Clase 25
 */

public class Motor extends Thread {
    private int ID;
    private CountDownLatch latch;
    private Random r = new Random();

    public Motor(int ID, CountDownLatch latch) {
        this.ID = ID;
        this.latch = latch;
    }

    @Override
    public void run() {
        int tiempoStartUp = r.nextInt(10) + 1;
        System.out.println("Motor " + ID + " arrancando en " + tiempoStartUp + " segundos");
        try {
            TimeUnit.SECONDS.sleep(tiempoStartUp);
            System.out.println("El motor " + ID + " esta operativo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }

    }
}
