package ejemplo.barreras;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 26/06/2015.
 * Clase 23
 */
public class TestBurger {

    final static int CUANTAS_PARTES = 3;
    static Random r = new Random();

    //la barrera se crea así:
    static CyclicBarrier barrera = new CyclicBarrier(CUANTAS_PARTES, TestBurger::entregaLaOrden);

    public static void main(String[] args) {
        Thread t1 = new Thread(TestBurger::armarLaOrden);
        Thread t2 = new Thread(TestBurger::armarLaOrden);
        Thread t3 = new Thread(TestBurger::armarLaOrden);

        t1.setName("WHOPPER TEJANA");
        t2.setName("PAPAS FRITAS");
        t3.setName("COCA COLA SIN COLA");
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " Proceder a llamar a la víctima ...");
    }

    /*
    Es la simulación de lo que demora el condenado cocinero en preparar
    la Whopper Tejana
    */
    private static void armarLaOrden() {
        int workTime = r.nextInt(10) + 1;
        System.out.println(Thread.currentThread() + " su pedido demorará " + workTime);

        try {
            TimeUnit.SECONDS.sleep(workTime);
            System.out.println(Thread.currentThread() + " ya terminamos una parte de la orden. "
                    + "Ahora debe esperar a que los demás terminen.");

            //esperar a que terminen
            barrera.await();
            //espera a que los demás componentes lleguen a la barrera
            //System.out.println(Thread.currentThread() + " Proceder a llamar a la víctima ...");
        } catch (InterruptedException | BrokenBarrierException ex) {
            ex.printStackTrace();
        }
    }

    private static void entregaLaOrden() {
        System.out.println("Sr. Universe, su pedido está listo!");
    }


}
