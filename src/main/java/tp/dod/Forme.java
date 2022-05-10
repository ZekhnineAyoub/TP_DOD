package tp.dod;

public abstract class Forme{

    String type;
    String color;
    public static final String RECTANGLE = "R";
    public static final String CERCLE = "C";
    public static final String ESPACE = "E";


    protected Forme(String type, String color) {
        this.type = type;
        this.color = color;
    }

}
