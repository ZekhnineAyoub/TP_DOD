package grx.dod.demo.ihm;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import grx.dod.demo.tp.Draw;
import grx.dod.demo.tp.Espace;
import grx.dod.demo.tp.Forme;

public class ScenarioPanel extends JPanel {

	private static final long serialVersionUID = 4186161592045375526L;
	
	transient String titre;
	
	transient int nbFormes;
	
	transient Espace espace;
	
	transient Scenario scenario;
	
	transient long millis;
	
	transient Draw dessin;
	
	public ScenarioPanel(String titre, List<Forme> formes, Espace espace, Scenario scenario, long millis) {
		super(new BorderLayout());
		this.titre = titre;
		this.dessin = new Draw(formes, espace);
		this.nbFormes = this.dessin.getNbFormes();
		this.espace = this.dessin.getEspace();
		this.scenario = scenario;
		this.millis = millis;
		this.add(
			new StatutPanel(new CouleurPanel(this.espace), new PerformanceLabel(this.nbFormes, this.scenario, this.millis)),
			BorderLayout.SOUTH
		);
		this.add(this.dessin, BorderLayout.CENTER);
	}
	
	public String getTitre() {
		return titre;
	}

}
