package grx.dod.demo.ihm;

import java.util.List;

import javax.swing.JTabbedPane;

import grx.dod.demo.tp.Espace;
import grx.dod.demo.tp.Forme;

public class ScenarioOnglet extends JTabbedPane {

	private static final long serialVersionUID = 7546268064901428274L;
	
	transient ScenarioPanel typee;
	transient ScenarioPanel generique;
	transient ScenarioPanel simple;
	
	public ScenarioOnglet(List<Forme> formes, Espace espace, long millis) {
		super();
		this.setFont(Styles.LABEL_FONT);
		this.typee = new ScenarioPanel("Structure typée", formes, espace, new Scenario(StructureMode.OBJECT), millis);
		this.add(this.typee);
		this.setTitleAt(0, this.typee.getTitre());
		
		this.generique = new ScenarioPanel("Structure générique", formes, espace, new Scenario(StructureMode.GENERIC), millis);
		this.add(this.generique);
		this.setTitleAt(1, this.generique.getTitre());
		
		this.simple = new ScenarioPanel("Structure simplifiée", formes, espace, new Scenario(StructureMode.SIMPLE), millis);
		this.add(this.simple);
		this.setTitleAt(2, this.simple.getTitre());
	}

}
