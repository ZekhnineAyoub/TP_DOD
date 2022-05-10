package tp.dod;

import java.util.ArrayList;
import java.util.List;


public class RunApp {


    // afficher l'espace de la forme
    public static Espace espace(List<Forme> formes) {
        List<Forme> rects = new ArrayList<>();
        Conversion conversion = new Conversion();

        for (Forme forme : formes) {
            if (forme instanceof Rectangle) {
                // Rien à faire
                rects.add(forme);
            } else if (forme instanceof Cercle) {
                // Conversion à faire
                rects.add(conversion.apply(forme));
            } else {
                // On ne sait pas faire
            }
        }

        Emission espace = new Emission();
        System.out.println("heyyy"+espace.output(rects).get(0));
        return (Espace)espace.output(rects).get(0);
    }

    public static void listEspaceOccupationRectangulaireForms(List<Forme> formes) {
        Emission espace = new Emission();
        List<Forme> rects = new ArrayList<>();
        Conversion conversion = new Conversion();

        for (Forme forme : formes) {
            if (forme instanceof Rectangle) {
                // Rien à faire
                rects.add(forme);
            } else if (forme instanceof Cercle) {
                // Conversion à faire
                rects.add(conversion.apply(forme));
            } else {
                // On ne sait pas faire
            }
        }

        Consommation affichage = new Consommation();
        affichage.consume(espace.output(rects));
    }

    static public void main (String [] args) throws Exception {

        //Génération des forms
        String chemin = "src\\main\\resources\\espace.txt";
        List<Forme> formes = (new Generation(chemin)).output();
        Consommation conso = new Consommation();
        System.out.println();
        System.out.println("Formes :");
        conso.consume(formes);
        System.out.println(" => "+formes.size()+" (formes)");

    }

}

