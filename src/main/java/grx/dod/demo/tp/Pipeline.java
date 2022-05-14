package grx.dod.demo.tp;

import grx.dod.demo.tp.types.objet.Forme;
import grx.dod.demo.tp.types.generique.GeneriqueForme;

import java.util.List;

public interface Pipeline {
	
	List<Forme> output(List<Forme> input);


}
