package ejemplo.latchers;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Ricardo on 01/07/2015.
 * Clase 25
 */
public class TestLatches {
    final static int CUANTOS = 2;

    public static void main(String[] args) {
        System.out.println("Iniciando despegue con " + CUANTOS + " motores");
        CountDownLatch latch = new CountDownLatch(CUANTOS);
        SistemaDeDespegue despegue = new SistemaDeDespegue(latch);
        despegue.start();
        for (int i = 0; i < CUANTOS; i++) {
            Motor motor = new Motor(i + 1, latch);
            motor.start();
        }

        try {
            despegue.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Despegando...");

    }
}
