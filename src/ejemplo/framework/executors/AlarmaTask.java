package ejemplo.framework.executors;

import java.util.Date;

/**
 * Created by Ricardo on 03/07/2015.
 * Clase 26
 */

/**
 * Simula el despertador del celular
 */
public class AlarmaTask implements Runnable {


    @Override
    public void run() {
        System.out.println(new Date() + " beep beep beep");
    }
}
