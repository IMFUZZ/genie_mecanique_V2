import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panneau_droite_etudiant extends Panneau_droite {

	JButton bouton_location;
	JButton bouton_brut;
	JButton bouton_retour;
	JButton bouton_bris;
	
	JPanel conteneur_location;
	JPanel conteneur_brut;
	JPanel conteneur_retour;
	JPanel conteneur_bris;
	
	public Panneau_droite_etudiant(Fenetre a_parent){
		
		super(a_parent);
		
		// Création des JPanel qui contiennent les boutons
		conteneur_location = new JPanel();
		conteneur_brut = new JPanel();
		conteneur_retour = new JPanel();
		conteneur_bris = new JPanel();
		
		// Création des images des codes barre
		// *** À remplacer pour du texte avec la font "code barre"
		bouton_location = faire_codebarre("src/images/barcode.png");
		bouton_brut = faire_codebarre("src/images/barcode.png");
		bouton_retour = faire_codebarre("src/images/barcode.png");
		bouton_bris = faire_codebarre("src/images/barcode.png");
	
		// Bordure autour du code barre
		bouton_location.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		bouton_brut.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		bouton_retour.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		bouton_bris.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	
		// Ajoute un titre aux boutons
		conteneur_location.setBorder(BorderFactory.createTitledBorder("Faire location"));
		conteneur_brut.setBorder(BorderFactory.createTitledBorder("Donner bruts"));
		conteneur_retour.setBorder(BorderFactory.createTitledBorder("Faire retour"));
		conteneur_bris.setBorder(BorderFactory.createTitledBorder("Outil brisé"));
	
		// Ajoute les boutons à leur conteneur
		conteneur_location.add(bouton_location);
		conteneur_brut.add(bouton_brut);
		conteneur_retour.add(bouton_retour);
		conteneur_bris.add(bouton_bris);
		
		// Ajoute les conteneurs au panneau
		add(conteneur_location);
		add(conteneur_brut);
		add(conteneur_retour);
		add(conteneur_bris);
		
		/*
		 * Action du bouton location
		 * Lance la fonction faire_location du Contrôleur
		 */
		bouton_location.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.controlleur.faire_location(parent.etudiant);
			}
		});
		bouton_brut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.controlleur.faire_don(parent.etudiant);
			}
		});
		bouton_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.controlleur.faire_retour(parent.etudiant, 0);
			}
		});
		bouton_bris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.controlleur.faire_retour(parent.etudiant, 1);
			}
		});
	}
}
