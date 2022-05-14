package grx.dod.demo.tp.types.generique;


import grx.dod.demo.tp.types.objet.Conversion;
import grx.dod.demo.tp.types.objet.Forme;

import java.util.List;
import java.util.stream.Collectors;

public class GeneriqueMutation implements Pipeline {

	// Transforme : Cercle => Rectangle

	GeneriqueConversion conversion;

	public GeneriqueMutation(GeneriqueConversion conversion) {
		this.conversion = conversion;
	}
	
	@Override
	public List<GeneriqueForme> output(List<GeneriqueForme> input) {
		if (conversion!=null) {
			return input.stream().map(conversion)
			.collect(Collectors.toList());
		} else {
			return input;
		}
	}

}
