package grx.dod.demo.tp.types.generique;

import java.util.*;

import grx.dod.demo.tp.Couleur;
import grx.dod.demo.tp.Test;


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

    public static List<GeneriqueForme> listWithArray() {

        //Construire un Cercle
        Type CERCLE = new Type("CERCLE", "x", "y", "rayon","color");

        GeneriqueForme cercle1= new GeneriqueForme(CERCLE, 4, 3, 5, Couleur.blue);
        GeneriqueForme cercle2= new GeneriqueForme(CERCLE, 4, 3, 5, Couleur.blue);

        //Construire un Rectangle
        Type RECTANGLE = new Type("RECTANGLE", "x", "y","width","height", "color");

        GeneriqueForme rectangle1= new GeneriqueForme(CERCLE, 4, 3, 5, Couleur.green);

        //// Construire un tableau de forms
        List<GeneriqueForme> forms = new ArrayList<>();
        forms.add(cercle1);
        forms.add(rectangle1);

        return forms;
    }

    // Afficchage des attributs des forms
    public static void layout(Map<String, LayoutForme> layouts, List<GeneriqueForme> persons) {
        for (GeneriqueForme person : persons) {
            System.out.println(" > "+layouts.get(person.getType()).layout(person));
        }
    }


    public static void main(String[] args) {
        List<GeneriqueForme> persons;

        Map<String, LayoutForme> layouts = new HashMap<>();
        layouts.put("CERCLE", new LayoutForme("CERCLE", "${civility}  ${first_name} ${last_name} (${age})"));
        layouts.put("RECTANGLE", new LayoutForme("RECTANGLE", "${civility}  ${first_name} ${last_name} (${age}) [ ${role} ]"));

        long time;

        /*// Option N°1 :
        System.out.println();
        System.out.println("Option N°1");

        time = Test.start();
        persons = listWithMap();
        layout(layouts, persons);
        Test.end(time);*/

        // Option N° 2 :
        System.out.println();
        System.out.println("Option N°2");

        time = Test.start();
        persons = listWithArray();
        layout(layouts, persons);
        Test.end(time);
    }

}
