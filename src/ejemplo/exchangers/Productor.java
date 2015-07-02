package ejemplo.exchangers;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 01/07/2015.
 * Clase 25
 */
public class Productor extends Thread {
    private Exchanger<ArrayList<Integer>> exchanger;
    private ArrayList<Integer> buffer = new ArrayList<>();
    private int bufferLimit;
    private Random random = new Random();
    private int currentValue = 0;

    public Productor(Exchanger<ArrayList<Integer>> exchanger, int bufferLimit) {
        this.exchanger = exchanger;
        this.bufferLimit = bufferLimit;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Producto llenado datos...");
            int trabajarTime = random.nextInt(5) + 1;
            try {
                TimeUnit.SECONDS.sleep(trabajarTime);
                for (int i = 0; i < bufferLimit; i++) {
                    buffer.add(++currentValue);
                }
                System.out.println("Productor " + buffer);
                System.out.println("Productor esperando a consumidor");
                //hago una especia de swap con el otro hilo...
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
