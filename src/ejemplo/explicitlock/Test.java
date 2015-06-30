package ejemplo.explicitlock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 26/06/2015.
 * Clase 23
 */
public class Test {
    static SimpleExplicitLock sep = new SimpleExplicitLock();

    public static void main(String[] args) {
        System.out.println("\n * * **  Inicio ");
        for (int i=0; i < 10; i++) {
            Thread t1 = new Thread(Test::corre);
            t1.setDaemon(false);
            if ( i%2 == 0)
                t1.setPriority(Thread.MAX_PRIORITY);
            t1.start();
        } // del for
        System.out.println("\n * * **  Fin ");
    }

    public static void corre() {
        try {
            TimeUnit.SECONDS.sleep(2);
            sep.actualizaValor();
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
