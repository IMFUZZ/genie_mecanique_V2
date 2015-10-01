import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class Panneau_haut_gauche_etudiant extends Panneau{

	TitledBorder t_b_codeBarre;
	TitledBorder t_b_info_etudiant;

	JPanel p_info_etudiant;
	JPanel p_remplissage;
	JPanel p_codebarre;
	
	JPanel p_nom_prenom;
	JLabel l_image_etudiant;
	JLabel l_nom_etudiant;
	JLabel l_prenom_etudiant;
	
	JButton l_codebarre_centre;
	
	String s_nom_etudiant;
	String s_prenom_etudiant;
	
	public Panneau_haut_gauche_etudiant(Fenetre a_parent)
	{
		super(a_parent);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		setMaximumSize(new Dimension(1000, 200));
		
		s_prenom_etudiant = parent.etudiant.prenom;
		s_nom_etudiant = parent.etudiant.nom;
		
		p_info_etudiant = new JPanel();
		p_remplissage = new JPanel();
		p_codebarre = new JPanel();
		
		p_nom_prenom = new JPanel();
		
		p_info_etudiant.setMaximumSize(new Dimension(800, 200));
		p_codebarre.setMaximumSize(new Dimension(400, 200));
		
		l_nom_etudiant = new JLabel(s_nom_etudiant);
		l_prenom_etudiant = new JLabel(s_prenom_etudiant);
		l_image_etudiant = faire_image(parent.etudiant.chemin_image, 150, 160);
		l_codebarre_centre = faire_codebarre("src/images/barcode.png");
		
		l_image_etudiant.setFont(f_sousTitre);
		l_nom_etudiant.setFont(f_sousTitre);
		l_prenom_etudiant.setFont(f_sousTitre);
		
		p_info_etudiant.setLayout(new BoxLayout(p_info_etudiant, BoxLayout.X_AXIS));
		p_remplissage.setLayout(new BoxLayout(p_remplissage, BoxLayout.X_AXIS));
		p_remplissage.setMaximumSize(new Dimension(1000, 200));
		p_codebarre.setLayout(new GridLayout(1,1));
		p_codebarre.setAlignmentX(Component.CENTER_ALIGNMENT);
		p_nom_prenom.setLayout(new BoxLayout(p_nom_prenom, BoxLayout.Y_AXIS));
		p_nom_prenom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		t_b_info_etudiant = BorderFactory.createTitledBorder("Information sur le client");
		t_b_codeBarre = BorderFactory.createTitledBorder("Retour à la selection de client");
		
		p_info_etudiant.setBorder(
				t_b_info_etudiant);
		p_codebarre.setBorder(
				t_b_codeBarre);
	
		p_nom_prenom.add(l_prenom_etudiant);
		p_nom_prenom.add(l_nom_etudiant);
		
		p_info_etudiant.add(l_image_etudiant);
		p_info_etudiant.add(p_nom_prenom);
		
		p_codebarre.add(l_codebarre_centre);
		
		add(p_info_etudiant, BorderLayout.WEST);
		add(p_codebarre, BorderLayout.EAST);
		add(p_remplissage, BorderLayout.EAST);
		
		l_codebarre_centre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.set_panneau_recherche();
			}
		});
	}
}
