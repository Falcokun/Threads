package ejemplo.semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 26/06/2015.
 * Clase 23
 */
public class TestSemaforos {

    final static int CUANTAS_CAJAS_ATIENDEN = 2;
    //recurso compartido; en este caso, un semáforo

    //cajas representa semáforo
    private static Semaphore cajas = new Semaphore(CUANTAS_CAJAS_ATIENDEN);
    /*
    en terminología de semáforos, se conoce como permits
    cuántos recursos va a manejar el semáforo
    en este caso, serán 2 cajas
    */

    private static Random r = new Random();

    public static void main(String[] args) {

        System.out.println("* * * Inicio * * *");

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(TestSemaforos::hazCola);
            t.setName("ALUMNO-" + i);
            if (i == 9) {
                t.setPriority(Thread.MAX_PRIORITY);
            }
            t.start();
        }

        System.out.println("* * * Fin * * *");

    }


    public static void hazCola() {
        System.out.println(Thread.currentThread().getName() + " tratando de colarse");

        try {
            cajas.acquire();

            /*
            lo que hago es colocar un cliente en un recurso
            le indico que queda un recurso menos
            */
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " se coló...");

        //El cliente puede demorar...
        int demoraTime = r.nextInt(10) + 1;

        System.out.println(Thread.currentThread().getName() + " se demorará " + demoraTime);

        try {
            TimeUnit.SECONDS.sleep(demoraTime);
            System.out.println(Thread.currentThread().getName() + " hasta que al fin se va!!!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            cajas.release();
            /*
            lo que hago es liberar un recurso e indicar hey!! recurso libre here, pasa el sgte
            */
        }
    }
}
