import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class Panneau_haut_etudiant extends Panneau_haut {

	JPanel p_info_etudiant;
	JPanel p_nom_prenom;
	JLabel l_image_etudiant;
	JLabel l_nom_etudiant;
	JLabel l_prenom_etudiant;
	
	TitledBorder b_p_gauche;
	
	String s_nom_etudiant;
	String s_prenom_etudiant;
	
	public Panneau_haut_etudiant(Fenetre a_parent)
	{
		super(a_parent);
		
		s_prenom_etudiant = "Daniel-Junior";
		s_nom_etudiant = "Dubé";
		
		p_info_etudiant = new JPanel();
		p_nom_prenom = new JPanel();
		
		l_nom_etudiant = new JLabel(s_nom_etudiant);
		l_prenom_etudiant = new JLabel(s_prenom_etudiant);
		l_image_etudiant = faire_image("src/images/etudiant1.png", 150, 160);
		l_codebarre_centre = faire_codebarre("src/images/barcode.png");
		
		l_image_etudiant.setFont(f_sousTitre);
		l_nom_etudiant.setFont(f_sousTitre);
		l_prenom_etudiant.setFont(f_sousTitre);
		
		p_info_etudiant.setLayout(new BoxLayout(p_info_etudiant, BoxLayout.X_AXIS));
		p_nom_prenom.setLayout(new BoxLayout(p_nom_prenom, BoxLayout.Y_AXIS));
		p_nom_prenom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		b_p_gauche = BorderFactory.createTitledBorder("Information sur le client");
		b_codeBarre = BorderFactory.createTitledBorder("Retour à la selection de client");
		
		p_gauche.setBorder(
				b_p_gauche);
		p_centre.setBorder(
				b_codeBarre);
	
		p_nom_prenom.add(l_prenom_etudiant);
		p_nom_prenom.add(l_nom_etudiant);
		
		p_info_etudiant.add(l_image_etudiant);
		p_info_etudiant.add(p_nom_prenom);
		
		p_gauche.add(p_info_etudiant);
		
		p_image_centre.add(l_codebarre_centre);
		p_centre.add(p_image_centre);
	}
}
