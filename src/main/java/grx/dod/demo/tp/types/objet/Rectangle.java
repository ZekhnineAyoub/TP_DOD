package grx.dod.demo.tp.types.objet;

import grx.dod.demo.tp.types.objet.Forme;

public class Rectangle extends Forme {

	double x;
	double y;
	
	double width;
	double height;
	
	public Rectangle(double x, double y, double width, double height, String color) {
		super(RECTANGLE, color);
		this.x = x;
		this.y = y;
		this.width = Math.abs(width);
		this.height = Math.abs(height);
	}
	
	@Override
	public String toString() {
		return "R (x:"+x+", y:"+y+", w:"+width+", h:"+height+", c:"+color+")";
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
