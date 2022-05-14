package grx.dod.demo.tp.types.generique;

//import grx.dod.demo.tp.types.objet.Cercle;
//import grx.dod.demo.tp.types.objet.Forme;
//import grx.dod.demo.tp.types.objet.Rectangle;

import grx.dod.demo.tp.Couleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class GeneriqueGeneration {

	String chemin;


	public GeneriqueGeneration(String chemin) {
		this.chemin = chemin;
	}
	
	public List<GeneriqueForme> output() throws Exception {
		File fichier = new File(chemin);
		
		try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {
			return lecteur.lines().map(
				line -> {
					GeneriqueForme forme;

					if (line!=null) {
						String[] parts = line.split(";");
						String type = parts[0];

						//Construire un cercle forme generique
						if (GeneriqueForme.CERCLE.equals(type)) {
							forme= new GeneriqueForme(GeneriqueForme.CERCLETYPE, Double.valueOf(parts[1]), Double.valueOf(parts[2]), Double.valueOf(parts[3]), parts[4]);

						} else if (GeneriqueForme.RECTANGLE.equals(type)) {
							//Construire un rectangle forme generique
							forme= new GeneriqueForme(GeneriqueForme.RECTANGLETYPE, Double.valueOf(parts[1]), Double.valueOf(parts[2]), Double.valueOf(parts[3]),Double.valueOf(parts[4]), parts[5]);
						} else {
							// Inconnu
							forme = null;
						}
					} else {
						// Inconnu
						forme = null;
					}
					
					return forme;
				}
			).collect(Collectors.toList());
		}

	}
}
