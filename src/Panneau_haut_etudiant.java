import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panneau_haut_etudiant extends Panneau_haut {

	JPanel p_info_etudiant;
	JLabel l_image_etudiant;
	JLabel l_nom_etudiant;
	JLabel l_prenom_etudiant;
	
	String s_nom_etudiant;
	String s_prenom_etudiant;
	
	public Panneau_haut_etudiant()
	{
		s_nom_etudiant = "JUNG UN";
		s_prenom_etudiant = "KIM";
		
		l_nom_etudiant = new JLabel(s_nom_etudiant);
		l_prenom_etudiant = new JLabel(s_prenom_etudiant);
		l_image_etudiant = faire_image("src/images/etudiant1.png", 150, 160);
		l_image_centre = faire_codebarre("src/images/barcode.png");
		
		l_texte_image_centre.setText("Scanner un étudiant");
		
		l_image_etudiant.setFont(f_sousTitre);
		l_nom_etudiant.setFont(f_sousTitre);
		l_prenom_etudiant.setFont(f_sousTitre);
		l_texte_image_centre.setFont(f_sousTitre);
		
		p_info_etudiant = new JPanel();
		
		p_info_etudiant.setLayout(new GridLayout(1, 3));
		
		l_image_etudiant.setBorder(
				BorderFactory.createLineBorder(Color.black));
		l_nom_etudiant.setBorder(
				BorderFactory.createLineBorder(Color.black));
		l_prenom_etudiant.setBorder(
				BorderFactory.createLineBorder(Color.black));
		p_info_etudiant.setBorder(
				BorderFactory.createLineBorder(Color.black));
		
		p_info_etudiant.add(l_image_etudiant);
		p_info_etudiant.add(l_nom_etudiant);
		p_info_etudiant.add(l_prenom_etudiant);
		
		p_gauche.add(p_info_etudiant);
		
		p_image_centre.add(l_image_centre);
		p_centre.add(p_image_centre);
		p_centre.add(p_texte_image_centre);
	}
}
