package ejemplo.framework.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Ricardo on 03/07/2015.
 * Clase 26
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("\n***Inicio***");
        Executor executor = Executors.newCachedThreadPool();
        AlarmaTask a1 = new AlarmaTask();
        AlarmaTask a2 = new AlarmaTask();

        executor.execute(a1);
        executor.execute(a2);


        System.out.println("\n***Fin***");
    }
}
