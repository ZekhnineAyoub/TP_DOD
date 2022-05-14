package grx.dod.demo.tp.types.generique;

import grx.dod.demo.tp.Couleur;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GeneriqueForme {
    private String type;

    //types (String)
    public static final String RECTANGLE = "R";
    public static final String CERCLE = "C";
    public static final String ESPACE = "E";

    //Definition des types
    public static final Type CERCLETYPE = new Type(GeneriqueForme.CERCLE, "x", "y", "rayon","color");
    public static final Type RECTANGLETYPE = new Type(GeneriqueForme.RECTANGLE, "x", "y","width","height", "color");
    public static final Type ESPACETYPE = new Type(GeneriqueForme.ESPACE, "x", "y","width","height", "colors");

    //Definition des Layouts
    public static final LayoutForme CERCLELAYOUT = new LayoutForme(GeneriqueForme.CERCLE, "(x:${x}, y:${y}, r:${rayon}, c:${color})");
    public static final LayoutForme RECTANGLELAYOUT = new LayoutForme(GeneriqueForme.RECTANGLE, "(x:${x}, y:${y}, w:${width}, h:${height}, c:${color})");
    public static final LayoutForme ESPACELAYOUT = new LayoutForme(GeneriqueForme.ESPACE, "(x:${x}, y:${y}, w:${width}, h:${height}, c:${colors})");

    public static final Map<String, LayoutForme> layouts = new HashMap<String, LayoutForme> () {{
        put(GeneriqueForme.CERCLE,GeneriqueForme.CERCLELAYOUT );
        put(GeneriqueForme.RECTANGLE, GeneriqueForme.RECTANGLELAYOUT);
        put(GeneriqueForme.ESPACE, GeneriqueForme.ESPACELAYOUT );
    }};

    private Map<String, Object> attributes;

    public GeneriqueForme(Type type, Object ... attributes) {
        this.type = type.getName();
        this.attributes = new HashMap<>();
        if (attributes!=null) {
            String name;
            for (int pos=0 ; pos<attributes.length ; pos++) {
                name = type.get(pos);
                if (name!=null) {
                    this.attributes.put(name, attributes[pos]);
                }
            }
        }
    }

    public GeneriqueForme(String type, Map<String, Object> attributes) {
        this.type = type;
        this.attributes = new HashMap<>();
        if (attributes!=null) {
            this.attributes.putAll(attributes);
        }
    }

    public String getType() {
        return type;
    }

    public Set<String> attributes() {
        return attributes.keySet();
    }

    public Object get(String attribute) {
        return attributes.get(attribute);
    }

}
