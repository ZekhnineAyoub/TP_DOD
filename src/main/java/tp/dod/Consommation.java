package tp.dod;

import java.util.List;

public class Consommation {
    public void consume(List<Forme> formes) {
        for (Forme forme : formes) {
            System.out.println(" > "+forme);
        }
    }

}
