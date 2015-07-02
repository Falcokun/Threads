package ejemplo.latchers;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Ricardo on 01/07/2015.
 * Clase 25
 */
public class SistemaDeDespegue extends Thread {
    private CountDownLatch latch;

    public SistemaDeDespegue(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Sistema de despegue a la espera de los motores");
        try {
            latch.await();
            System.out.println("Sistema de despegue LISTO !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
