package grx.dod.demo.tp.types.simple;

public class SimpleForme {

        private double x;
        private double y;
        private double rayon;
        private double width;
        private double height;

    //Constructeur Rectangle
    public SimpleForme(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getY() {
        return y;
    }

    public double getRayon() {
        return rayon;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    //constructeur Cercle
    public SimpleForme(double x, double y, double rayon) {
        this.x = x;
        this.y = y;
        this.rayon = rayon;
    }
}
