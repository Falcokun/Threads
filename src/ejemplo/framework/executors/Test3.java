package ejemplo.framework.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 03/07/2015.
 * Clase 26
 */
public class Test3 {

    public static final int ALARMAS = 1;

    /**
     * Ahora vamos a complucar la logica de la alarma,
     * si no la detengo yo, la detiene el sistema
     */
    public static void main(String[] args) {
        System.out.println("\n***Inicio***");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(ALARMAS);

        AlarmaTask beeper = new AlarmaTask();

        ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 5, 10, TimeUnit.SECONDS);

        //Programar la detencion de la alarma
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                //Cancela el beeper
                beeperHandle.cancel(true);
            }
        }, 60, TimeUnit.SECONDS);
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n***Fin***");
    }
}
