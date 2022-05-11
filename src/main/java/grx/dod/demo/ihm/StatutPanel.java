package grx.dod.demo.ihm;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class StatutPanel extends JPanel {

	private static final long serialVersionUID = -2497475860298012721L;

	transient CouleurPanel couleurs;
	
	transient PerformanceLabel performance;
	
	public StatutPanel(CouleurPanel couleurs, PerformanceLabel performance) {
		super(new BorderLayout());
		this.add(couleurs, BorderLayout.NORTH);
		this.add(performance, BorderLayout.SOUTH);
	}
	
}
