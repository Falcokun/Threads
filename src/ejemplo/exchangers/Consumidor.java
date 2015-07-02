package ejemplo.exchangers;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 01/07/2015.
 * Clase 25
 */
public class Consumidor extends Thread {
    private Exchanger<ArrayList<Integer>> exchanger;
    private ArrayList<Integer> buffer;
    private Random random = new Random();

    public Consumidor(Exchanger<ArrayList<Integer>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {

                System.out.println("Consumidor esperando la produccion");
                buffer = exchanger.exchange(buffer);
                System.out.println("El consumidor recibe " + buffer);
                System.out.println("EL consumidor comeinza a consumir");
                //Este tiempo se supone que es el tiempo que demora en consumir todo
                int dormirTime = random.nextInt(5) + 1;
                TimeUnit.SECONDS.sleep(dormirTime);

                //limpiar el buffer
                buffer.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
