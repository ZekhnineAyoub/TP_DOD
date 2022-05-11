package grx.dod.demo.ihm;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ControlePanel extends JPanel {

	private static final long serialVersionUID = -1317674255545484883L;

	transient ProcessingChoice processing;
	
	transient AjoutPanel ajout;
	
	public ControlePanel(int nbThreads) {
		super(new BorderLayout());
		
		this.processing = new ProcessingChoice(nbThreads);
		this.add(this.processing, BorderLayout.NORTH);
		
		this.ajout = new AjoutPanel();
		this.add(this.ajout, BorderLayout.SOUTH);
	}

}
