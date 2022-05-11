package grx.dod.demo.ihm;

import javax.swing.JLabel;

public class PerformanceLabel extends JLabel {

	private static final long serialVersionUID = 6882052268400082452L;

	transient int nbFormes;
	transient Scenario scenario;
	
	transient long millis;
	
	public PerformanceLabel(int nbFormes, Scenario scenario, long millis) {
		this.nbFormes = nbFormes;
		this.scenario = scenario;
		this.millis = millis;
		this.setText(
			this.millis+" ms pour calculer l'espace d'occupation des "+this.nbFormes+" formes avec "+
			this.scenario
		);
		this.setFont(Styles.LABEL_FONT);
		this.setHorizontalAlignment(CENTER);
		this.setVerticalAlignment(CENTER);
	}

}
