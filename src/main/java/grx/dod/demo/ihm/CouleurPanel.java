package grx.dod.demo.ihm;

import java.awt.FlowLayout;
import java.util.Collections;
import java.util.Set;

import javax.swing.JPanel;

import grx.dod.demo.tp.Couleur;
import grx.dod.demo.tp.Espace;

public class CouleurPanel extends JPanel {

	private static final long serialVersionUID = 2736050491880715293L;
	
	transient Set<String> colors;
	transient Set<String> _colors;
	
	public CouleurPanel(Espace espace) {
		super(new FlowLayout(FlowLayout.CENTER));
		this.colors = espace.getColors();
		for (String couleur : colors) {
			this.add(new CouleurLabel(Couleur.valueOf(couleur), 25));
		}
	}
	
	public Set<String> getColors() {
		if (_colors==null) {
			_colors = Collections.unmodifiableSet(colors);
		}
		return _colors;
	}

}
