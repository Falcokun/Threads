package ejemplo.newapis;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

/**
 * Created by Ricardo on 03/07/2015.
 * Clase 26
 */
public class Test2 {
    public static void main(String[] args) {
        Set<String> zoneIDs = ZoneId.getAvailableZoneIds();
        for (String s : zoneIDs)
            System.out.println(s);
        ZoneOffset zoneOffset;
    }
    //Averiguar el uso de Zone Offset
}
