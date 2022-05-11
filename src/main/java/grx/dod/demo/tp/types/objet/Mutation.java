package grx.dod.demo.tp.types.objet;

import grx.dod.demo.tp.Pipeline;
import grx.dod.demo.tp.types.objet.Conversion;
import grx.dod.demo.tp.types.objet.Forme;

import java.util.List;
import java.util.stream.Collectors;

public class Mutation implements Pipeline {

	// Transforme : Cercle => Rectangle
	
	Conversion conversion;
	
	public Mutation(Conversion conversion) {
		this.conversion = conversion;
	}
	
	@Override
	public List<Forme> output(List<Forme> input) {
		if (conversion!=null) {
			return input.stream().map(conversion)
			.collect(Collectors.toList());
		} else {
			return input;
		}
	}

}
