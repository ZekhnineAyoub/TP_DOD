package grx.dod.demo.ihm;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {

	private static final long serialVersionUID = -6237953302818325923L;

	transient JMenu fichier;
	transient JMenuItem chargerFichier;
	transient JMenuItem sauvegarderFichier;
	
	public Menu() {
		super();
		this.fichier = new JMenu("Fichier");
		this.fichier.setFont(Styles.LABEL_FONT);
		this.chargerFichier = new JMenuItem("Charger un fichier ...");
		this.chargerFichier.setFont(Styles.LABEL_FONT);
		this.fichier.add(this.chargerFichier);
		this.sauvegarderFichier = new JMenuItem("Sauvegarder dans un fichier ...");
		this.sauvegarderFichier.setFont(Styles.LABEL_FONT);
		this.fichier.add(this.sauvegarderFichier);
		this.add(this.fichier);
	}

}
