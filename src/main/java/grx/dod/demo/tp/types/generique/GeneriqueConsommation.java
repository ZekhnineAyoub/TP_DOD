package grx.dod.demo.tp.types.generique;

import java.util.List;
import java.util.Map;

public class GeneriqueConsommation {

	public void consume(List<GeneriqueForme> formes) {
		/* AFFICHAGE*/
		layout(GeneriqueForme.layouts, formes);
	}

	public void layout(Map<String, LayoutForme> layouts, List<GeneriqueForme> formGeneriques) {
		for (GeneriqueForme formGenerique : formGeneriques) {
			System.out.println(" > "+ formGenerique.getType()+ " " + layouts.get(formGenerique.getType()).layout(formGenerique));
		}
	}

}
