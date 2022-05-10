package tp.dod;

import java.util.ArrayList;
import java.util.List;


public class RunApp {


    static public void main (String [] args) throws Exception {

        //Génération des forms
        String chemin = "src\\main\\resources\\espace.txt";
        List<Forme> formes = (new Generation(chemin)).output();
        Consommation conso = new Consommation();
        System.out.println("Liste des Formes :");
        conso.consume(formes);
        System.out.println(" => "+formes.size()+" (formes)");



    }

}

