package ejemplo.framework.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ricardo on 03/07/2015.
 * Clase 26
 */
public class Test {
    public static void main(String[] args) {
        //hay que indicar el numero de hilos a manejar
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        //Asignar las tareas a ejecutar
        Tarea t1 = new Tarea(1);
        Tarea t2 = new Tarea(2);
        Tarea t3 = new Tarea(3);

        executorService.schedule(t1, 2, TimeUnit.SECONDS);
        executorService.schedule(t2, 5, TimeUnit.SECONDS);
        //Programar la tarea 3 para que se demore 5 segundos y
        //luego se ejecuta cada 10 segundos
        executorService.scheduleAtFixedRate(t3, 5, 10, TimeUnit.SECONDS);
    }
}
