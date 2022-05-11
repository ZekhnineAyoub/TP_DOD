package grx.dod.demo.ihm;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProcessingChoice extends JPanel {

	private static final long serialVersionUID = -9167681239181820256L;
	
	transient ButtonGroup choix;
	
	transient JRadioButton pipeline;
	transient JRadioButton parallel;
	
	transient int nbThreads;
	transient JTextField nbField;
	transient JLabel nbLabel;
	
	public ProcessingChoice(int nbThreads) {
		super(new FlowLayout(FlowLayout.CENTER));
		this.setFont(Styles.LABEL_FONT);
		
		this.choix = new ButtonGroup();
		
		this.pipeline = new JRadioButton("Pipeline", true);
		this.pipeline.setFont(Styles.LABEL_FONT);
		this.add(this.pipeline);
		this.choix.add(this.pipeline);

		this.parallel = new JRadioButton("Parallélisme");
		this.parallel.setFont(Styles.LABEL_FONT);
		this.add(this.parallel);
		this.choix.add(this.parallel);
		this.nbThreads = nbThreads;
		this.nbField = new JTextField(String.valueOf(nbThreads));
		this.nbField.setFont(Styles.LABEL_FONT);
		this.nbField.setColumns(3);
		this.add(this.nbField);
		this.nbLabel = new JLabel("Nb thread(s)");
		this.nbLabel.setFont(Styles.LABEL_FONT);
		this.add(this.nbLabel);
	}
	
	public int getNbThreads() {
		String nbExpr = this.nbField.getText();
		
		if (nbExpr.isEmpty()) {
			return nbThreads;
		} else {
			return Integer.valueOf(nbExpr);
		}
	}

}
