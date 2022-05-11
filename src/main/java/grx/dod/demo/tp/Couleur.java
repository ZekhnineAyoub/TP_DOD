package grx.dod.demo.tp;

import java.awt.Color;

public enum Couleur {

	green	(Color.GREEN),
	blue	(Color.BLUE),
	red		(Color.RED),
	black	(Color.BLACK),
	magenta	(Color.MAGENTA),
	pink	(Color.PINK),
	yellow	(Color.YELLOW);
	
	private Color color;
	
	private Couleur(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
    /*
		colors.put("green", Color.GREEN);
		colors.put("blue", Color.BLUE);
		colors.put("red", Color.RED);
		colors.put("black", Color.BLACK);
		colors.put("magenta", Color.MAGENTA);
		colors.put("pink", Color.PINK);
		colors.put("yellow", Color.YELLOW);
	*/

}
