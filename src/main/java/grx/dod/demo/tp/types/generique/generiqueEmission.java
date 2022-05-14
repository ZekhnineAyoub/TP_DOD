package grx.dod.demo.tp.types.generique;

import grx.dod.demo.tp.types.objet.Espace;
import grx.dod.demo.tp.types.objet.Forme;
import grx.dod.demo.tp.types.objet.Rectangle;

import java.util.*;

public class generiqueEmission implements Pipeline {

	// Retourne le rectangle représentant l'espace
	
	@Override
	public List<GeneriqueForme> output(List<GeneriqueForme> formes) {
		List<Double> topX = new ArrayList<>();
		List<Double> topY = new ArrayList<>();
		List<Double> bottomX = new ArrayList<>();
		List<Double> bottomY = new ArrayList<>();
		
		double minTopX;
		double minTopY;
		double maxBottomX;
		double maxBottomY;

		double x;
		double y;
		double width;
		double height;
		Set<String> colors = new HashSet<>();

		
		for (GeneriqueForme forme : formes) {
			if (GeneriqueForme.RECTANGLE.equals(forme.getType()) || GeneriqueForme.ESPACE.equals(forme.getType())) {
				//System.out.println("Emission for  ");
				//System.out.println(" > "+GeneriqueForme.layouts.get(forme.getType()).layout(forme));
				topX.add((double)forme.get("x"));
				topY.add((double)forme.get("y"));
				bottomX.add((double)forme.get("x") + (double)forme.get("width"));
				bottomY.add((double)forme.get("y") + (double)forme.get("height"));

				if (GeneriqueForme.ESPACE.equals(forme.getType())) {
					//System.out.println("Emission ESPACE   ");
					colors.addAll((Set<String>)forme.get("colors"));
					//System.out.println(colors);

				} else {
					colors.add((String)forme.get("color"));
				}
			}
		}
		//System.out.println("Emission after for  ");
		if (!topX.isEmpty() && !topY.isEmpty()) {
			minTopX = topX.stream().min((x1, x2) -> x1.compareTo(x2)).get();
			minTopY = topY.stream().min((y1, y2) -> y1.compareTo(y2)).get();
			maxBottomX = bottomX.stream().max((x1, x2) -> x1.compareTo(x2)).get();
			maxBottomY = bottomY.stream().max((y1, y2) -> y1.compareTo(y2)).get();
			
			x = minTopX;
			y = minTopY;

			width = Math.abs(maxBottomX - minTopX);
			height = Math.abs(maxBottomY - minTopY);

			GeneriqueForme espace = new GeneriqueForme(GeneriqueForme.ESPACETYPE, x, y, width,height, colors);
			//System.out.println("Emission return  ");
			return Collections.singletonList(espace);
		} else {
			//System.out.println("Emission return  ");
			return Collections.emptyList();
		}
	}

}
