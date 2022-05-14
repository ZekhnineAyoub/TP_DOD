package grx.dod.demo.tp.types.generique;

import java.util.*;

import grx.dod.demo.tp.types.objet.Consommation;
import grx.dod.demo.tp.Couleur;
import grx.dod.demo.tp.types.objet.Filtre;
import grx.dod.demo.tp.types.objet.Forme;


public class LayoutForme {
    private String type;
    private String layout;

    public LayoutForme(String type, String layout) {
        this.type = type;
        this.layout = layout;
    }

    public String getType() {
        return type;
    }

    public String layout(GeneriqueForme data) {
        Set<String> attributes = data.attributes();
        String str = layout;
        Object value;

        for (String attribute : attributes) {
            value = data.get(attribute);
            value = (value!=null ? value.toString() : "");
            str = str.replace("${"+attribute+"}", value.toString());
        }
        return str;
    }

    /* Fonction qui montre comment construire un cercle et un rectangle*/
    public static List<GeneriqueForme> listWithArray() {

        //Construire un Cercle
        Type CERCLE = new Type("CERCLE", "x", "y", "rayon","color");
        GeneriqueForme cercle1= new GeneriqueForme(CERCLE, 4, 3, 5, Couleur.blue);
        GeneriqueForme cercle2= new GeneriqueForme(CERCLE, 4, 3, 5, Couleur.blue);

        //Construire un Rectangle
        Type RECTANGLE = new Type("RECTANGLE", "x", "y","width","height", "color");
        GeneriqueForme rectangle1= new GeneriqueForme(CERCLE, 4, 3, 5, Couleur.green);

        //// Construire une liste de forms
        List<GeneriqueForme> forms = new ArrayList<>();
        forms.add(cercle1);
        forms.add(rectangle1);

        return forms;
    }

    // Affichage des attributs des forms
    public static void layout(Map<String, LayoutForme> layouts, List<GeneriqueForme> formGeneriques) {
        for (GeneriqueForme formGenerique : formGeneriques) {
            System.out.println(" > "+layouts.get(formGenerique.getType()).layout(formGenerique));
        }
    }


    public static void main(String[] args) throws Exception {
        String chemin = "src/main/resources/espace.txt";
        List<GeneriqueForme> formes = (new GeneriqueGeneration(chemin)).output();
        GeneriqueConsommation conso = new GeneriqueConsommation();
        GeneriqueConversion conv= new GeneriqueConversion();
        GeneriqueMutation mutation = new GeneriqueMutation(conv);
        generiqueEmission  emission = new generiqueEmission();

        System.out.println("formes");
        conso.consume(formes);

        List<GeneriqueForme> s1;
        List<GeneriqueForme> s2;

        s1 =   emission.output(mutation.output(GeneriqueFiltre.output(GeneriqueForme.CERCLE,formes)));
        s2 =   emission.output(                GeneriqueFiltre.output(GeneriqueForme.RECTANGLE,formes));



        List<GeneriqueForme> sN = new ArrayList<GeneriqueForme>();
        sN.addAll(s1);
        sN.addAll(s2);

        System.out.println("s1");
        conso.consume(s1);
        System.out.println("s2");
        conso.consume(s2);
        System.out.println("sN");
        conso.consume(emission.output(sN));






    }
}
