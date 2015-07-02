package ejemplo.exchangers;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by Ricardo on 01/07/2015.
 * Clase 25
 */
public class TestExchanger {

    public static void main(String[] args) {
        Exchanger<ArrayList<Integer>> exchanger = new Exchanger<>();

        Productor p = new Productor(exchanger, 5);
        Consumidor c = new Consumidor(exchanger);

        p.start();
        c.start();
    }
}
