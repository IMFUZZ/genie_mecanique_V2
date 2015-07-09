import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panneau_droite_etudiant extends Panneau_droite {

	JLabel l_image_location;
	JLabel l_image_brute;
	JLabel l_image_retour;
	
	JLabel l_texte_image_location;
	JLabel l_texte_image_brute;
	JLabel l_texte_image_retour;
	
	JPanel p_image_location;
	JPanel p_image_brute;
	JPanel p_image_retour;
	
	public Panneau_droite_etudiant(){
		
		p_image_location = new JPanel();
		p_image_brute = new JPanel();
		p_image_retour = new JPanel();
		
		p_image_location.setMaximumSize(new Dimension(200, 150));
		p_image_brute.setMaximumSize(new Dimension(200, 150));
		p_image_retour.setMaximumSize(new Dimension(200, 150));
		
		l_image_location = faire_codebarre("src/images/barcode.png");
		l_image_brute = faire_codebarre("src/images/barcode.png");
		l_image_retour = faire_codebarre("src/images/barcode.png");
	
		l_image_location.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		l_image_brute.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		l_image_retour.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	
		p_image_location.setBorder(BorderFactory.createTitledBorder("Faire emprunt"));
		p_image_brute.setBorder(BorderFactory.createTitledBorder("Donner brutes"));
		p_image_retour.setBorder(BorderFactory.createTitledBorder("Faire retour"));
	
		p_image_location.add(l_image_location);
		p_image_brute.add(l_image_brute);
		p_image_retour.add(l_image_retour);
		
		add(p_image_location);
		add(p_image_brute);
		add(p_image_retour);
	}
}
