package grx.dod.demo.ihm;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import grx.dod.demo.tp.Couleur;

public class AjoutPanel extends JPanel {

	private static final long serialVersionUID = 8834547852756787659L;
	
	transient JButton cercle;
	transient JButton rectangle;
	
	public AjoutPanel() {
		super(new FlowLayout(FlowLayout.RIGHT));
		
		this.cercle = new JButton("+ Cercle");
		this.cercle.setFont(Styles.LABEL_FONT);
		this.cercle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogCercle();
				
			}
		});
		this.add(this.cercle);
		
		this.rectangle = new JButton("+ Rectangle");
		this.rectangle.setFont(Styles.LABEL_FONT);
		this.rectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogRectangle();
				
			}
		});
		this.add(this.rectangle);
	}
	
	public void dialogCercle() {
		JPanel panneau = new JPanel(new GridLayout(4, 2));
		JLabel posXLabel = new JLabel("Position X: ");
		JTextField posX = new JTextField(10);
		panneau.add(posXLabel);
		panneau.add(posX);
		
		JLabel posYLabel = new JLabel("Position Y: ");
		JTextField posY = new JTextField(10);
		panneau.add(posYLabel);
		panneau.add(posY);
		
		JLabel rayonLabel = new JLabel("Rayon: ");
		JTextField rayon = new JTextField(10);
		panneau.add(rayonLabel);
		panneau.add(rayon);
		
		JLabel couleurLabel = new JLabel("Couleur");
		Couleur[] couleursList = {Couleur.black, Couleur.blue, Couleur.green, Couleur.magenta, Couleur.pink, Couleur.red, Couleur.yellow};
		JComboBox<Couleur> comboBox = new JComboBox<Couleur>(couleursList);
		panneau.add(couleurLabel);
		panneau.add(comboBox);
		
		String[] options = {"Ok", "Annuler"};
		int optionAnswer = JOptionPane.showOptionDialog(null, panneau, "Ajouter un cercle", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		System.out.println(optionAnswer +" "+ posX.getText()+" "+ posY.getText()+" "+rayon.getText()+" "+ comboBox.getSelectedItem().toString());
		
		if (optionAnswer == 0) {
			//draw
		} else {
			//pass
		}
	}
	
	public void dialogRectangle() {
		JPanel panneau = new JPanel(new GridLayout(5, 2));
		JLabel posXLabel = new JLabel("Position X: ");
		JTextField posX = new JTextField(10);
		panneau.add(posXLabel);
		panneau.add(posX);
		
		JLabel posYLabel = new JLabel("Position Y: ");
		JTextField posY = new JTextField(10);
		panneau.add(posYLabel);
		panneau.add(posY);
		
		JLabel largeurLabel = new JLabel("Largeur: ");
		JTextField largeur = new JTextField(10);
		panneau.add(largeurLabel);
		panneau.add(largeur);
		
		JLabel hauteurLabel = new JLabel("Hauteur: ");
		JTextField hauteur = new JTextField(10);
		panneau.add(hauteurLabel);
		panneau.add(hauteur);
		
		JLabel couleurLabel = new JLabel("Couleur");
		Couleur[] couleursList = {Couleur.black, Couleur.blue, Couleur.green, Couleur.magenta, Couleur.pink, Couleur.red, Couleur.yellow};
		JComboBox<Couleur> comboBox = new JComboBox<Couleur>(couleursList);
		panneau.add(couleurLabel);
		panneau.add(comboBox);
		
		String[] options = {"Ok", "Annuler"};
		int optionAnswer = JOptionPane.showOptionDialog(null, panneau, "Ajouter un rectangle", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (optionAnswer == 0) {
			//draw
		} else {
			//pass
		}
	}

}
