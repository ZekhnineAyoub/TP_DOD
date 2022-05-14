package grx.dod.demo.tp.types.generique;

import grx.dod.demo.tp.Couleur;

import java.util.function.Function;

public class GeneriqueConversion implements Function<GeneriqueForme, GeneriqueForme> {

	@Override
	public GeneriqueForme apply(GeneriqueForme forme) {
		if (forme.getType()== GeneriqueForme.RECTANGLE) {
			return forme;
		} else if (forme.getType()== GeneriqueForme.CERCLE) {

			//Conversion en RECTANGLE
			double x = (double) forme.get("x") - (double)forme.get("rayon");
			double y = (double)forme.get("y") - (double)forme.get("rayon");
			double width = (double)forme.get("rayon") * 2;
			double height = width;
			String color = (String)forme.get("color");

			GeneriqueForme rectangle= new GeneriqueForme(GeneriqueForme.RECTANGLETYPE, x, y, width,height, color);
			//System.out.println(" > "+ rectangle.getType()+ " " + GeneriqueForme.layouts.get(rectangle.getType()).layout(rectangle));

			return rectangle;
		} else {
			// Forme invalide
			return null;
		//}
	}
	}
}
