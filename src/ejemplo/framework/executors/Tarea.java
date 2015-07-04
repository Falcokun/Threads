package ejemplo.framework.executors;

import java.time.LocalDateTime;

/**
 * Created by Ricardo on 03/07/2015.
 * Clase 26
 */
public class Tarea implements Runnable {

    private int taskId;

    public Tarea(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        //Clase luego de Date, mejor
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Tarea #" + taskId + " ejecutandose en " + current);
    }
}
