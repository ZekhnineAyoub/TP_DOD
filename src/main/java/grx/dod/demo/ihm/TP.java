package grx.dod.demo.ihm;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import grx.dod.demo.tp.Cercle;
import grx.dod.demo.tp.Conversion;
import grx.dod.demo.tp.Emission;
import grx.dod.demo.tp.Espace;
import grx.dod.demo.tp.Forme;
import grx.dod.demo.tp.Generation;
import grx.dod.demo.tp.Rectangle;

public class TP {
	
	public static void draw(List<Forme> formes, Espace espace, Scenario scenario, long millis) {
		JFrame window = new JFrame("Espace d'occupation des formes");
		
		window.setLayout(new BorderLayout());
		window.add(new ScenarioOnglet(formes, espace, millis), BorderLayout.CENTER);
		window.add(new ControlePanel(2), BorderLayout.NORTH);
		
		window.setJMenuBar(new Menu());
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		window.setVisible(true);
	}

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
		
		return (Espace)espace.output(rects).get(0);
	}
	
	public static long start() {
		return System.currentTimeMillis();
	}
	
	public static long end(long start) {
		long end = System.currentTimeMillis();
		
		return (end-start);
	}

	public static void main(String[] args) throws Exception {
		String chemin = "src/main/resources/espace.txt";
		List<Forme> formes = (new Generation(chemin)).output();
		
		long start = start();
		
		Espace espace = espace(formes);
		
		long millis = end(start);
		
		draw(formes, espace, new Scenario(StructureMode.OBJECT), millis);
	}
	
}
